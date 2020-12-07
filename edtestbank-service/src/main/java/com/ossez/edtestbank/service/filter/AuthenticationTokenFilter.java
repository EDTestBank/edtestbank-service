package com.ossez.edtestbank.service.filter;


import com.nimbusds.jose.shaded.json.JSONArray;
import com.ossez.edtestbank.common.SCOConstants;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * AuthenticationTokenFilter
 */
@Component
@EnableResourceServer
public class AuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationTokenFilter.class);

    /**
     * @param httpServletRequest
     * @param httpServletResponse
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        logger.debug("Request TOKEN Authentication Filter.");

        String tokenHeader = httpServletRequest.getHeader(SCOConstants.TOKEN_HEADER);

//        if (StringUtils.isEmpty(tokenHeader)|| !tokenHeader.startsWith(SCOConstants.TOKEN_HEAD)) {
//            httpServletResponse.sendError(HttpStatus.UNAUTHORIZED.value());
//            return ;
//        }

        // SET User Group by getting from group id config
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Authorization, Origin, X-Requested-With, Content-Type, Accept");

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


    /**
     * SET Group
     *
     * @param tokenHeader
     * @return user role
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        String token = StringUtils.EMPTY;
        String username = StringUtils.EMPTY;
        String role = "ROLE_ANONYMOUS";

        // PARSE JWT TOKEN STRING
        if (StringUtils.startsWithIgnoreCase(tokenHeader, SCOConstants.TOKEN_HEAD)) {
            token = StringUtils.trimToEmpty(StringUtils.removeStartIgnoreCase(tokenHeader, SCOConstants.TOKEN_HEAD));

            try {
                SignedJWT sjwt = SignedJWT.parse(token);
                JWTClaimsSet claims = sjwt.getJWTClaimsSet();

                username = (String) claims.getClaim("name");
                JSONArray groups = (JSONArray) claims.getClaim("groups");

                role = "ROLE_ADMIN";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // SET USERNAME
        if (StringUtils.isNotBlank(username)) {
            return new UsernamePasswordAuthenticationToken(username, null,
                    Collections.singleton(new SimpleGrantedAuthority(role))
            );
        }
        return null;
    }
}
