package com.ossez.edtestbank.service.configuration;

import com.ossez.edtestbank.service.filter.AuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtClaimsSetVerifier;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * SecurityResourceServerConfig
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Value(" ${security.oauth2.resource.jwt.key-uri}")
    private String keySetUri;

    @Value("${security.oauth2.client.accepted-audience-id}")
    private String audienceId;

    @Value("${security.oauth2.client.accepted-client-id}")
    private String clientId;

    @Value("${security.oauth2.aad.aliases}")
    private String[] aadAliases;

    @Value("${security.oauth2.accepted.tenants}")
    private String[] acceptedTenants;

    private final String AAD_SCOPE_CLAIM = "scp";

    @Bean
    public AuthenticationTokenFilter jwtAuthenticationTokenFilterBean() throws Exception {
        return new AuthenticationTokenFilter();
    }


    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        // FOR H2 CONSOLE
        httpSecurity.headers().frameOptions().sameOrigin();

        // DISABLE CSRF
        httpSecurity.csrf().disable();

        //FILTER
        httpSecurity
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/*").permitAll();
//                .access("#oauth2.hasScope('" + accessAsUserScope + "')"); // required scope to access /api URL


    }



    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtConverter = new JwtAccessTokenConverter();

        DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
        accessTokenConverter.setScopeAttribute(AAD_SCOPE_CLAIM);

        jwtConverter.setAccessTokenConverter(accessTokenConverter);

        return jwtConverter;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        // we need to set resourceId to null so that spring doesn't try to verify this.
        // this is because the aud claim is variable in AAD (e.g. clientId or api://clientId ).
        // we then verify this in our custom verifier (AADClaimsVerifier)
        resources.resourceId(null);
    }


}
