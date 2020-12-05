package com.ossez.edtestbank.common.utilities;

import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.token.store.JwtClaimsSetVerifier;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/**
 * AAD (Azure Active Directory) Token Claims Verifier
 *
 * @author YuCheng Hu
 */
public class AADClaimsVerifier implements JwtClaimsSetVerifier {
    private static final String ISS_CLAIM = "iss";
    private static final String AUD_CLAIM = "aud";
    private static final String CLIENT_ID = "appid";
    private static final String V1_AUD_PREFIX = "api://";
    private static final String V1_ISSUER_FORMAT = "https://%s/%s/";
    private static final String V2_ISSUER_FORMAT = "https://%s/%s/v2.0";


    private HashSet<String> acceptedIssuers = new HashSet<String>();
    private final String audienceId;
    private final String clientId;

    /**
     * AADClaimsVerifier Constructor
     *
     * @param aadAliases
     * @param acceptedTenants
     * @param applicationId
     */
    public AADClaimsVerifier(final String[] aadAliases, final String[] acceptedTenants, final String applicationId, final String clientId) {
        // In production, you'd want to get a valid list of issuers from:
        // https://login.microsoftonline.com/common/discovery/instance?authorization_endpoint=https://login.microsoftonline.com/common/oauth2/v2.0/authorize&api-version=1.1
        // You must get all the values under the metadata[].aliases[] properties.

        Assert.notEmpty(aadAliases, "aadAliases cannot be empty");
        for (final String issuer : aadAliases) {
            Assert.notNull(issuer, "AADAlias value cannot be null");
        }

        Assert.notEmpty(acceptedTenants, "acceptedTenants cannot be empty");
        for (final String tenant : acceptedTenants) {
            Assert.notNull(tenant, "acceptedTenant value cannot be null");
        }

        Assert.notNull(applicationId, "applicationId (for audience claim) cannot be null");

        this.audienceId = applicationId;
        this.clientId = clientId;

        generateAcceptedIssuers(aadAliases, acceptedTenants);
    }

    /**
     * @param aadAliases
     * @param acceptedTenants
     */
    private void generateAcceptedIssuers(final String[] aadAliases, final String[] acceptedTenants) {
        for (int i = 0; i < aadAliases.length; i++) {
            for (int j = 0; j < acceptedTenants.length; j++) {
                acceptedIssuers.add(String.format(V1_ISSUER_FORMAT, aadAliases[i], acceptedTenants[j]));
                acceptedIssuers.add(String.format(V2_ISSUER_FORMAT, aadAliases[i], acceptedTenants[j]));
            }
        }
    }

    /**
     * @param claims
     * @throws InvalidTokenException
     */
    public void verify(final Map<String, Object> claims) throws InvalidTokenException {
        if (CollectionUtils.isEmpty(claims))
            throw new InvalidTokenException("token must contain claims");
        if (!claims.containsKey("iss"))
            throw new InvalidTokenException("token must contain issuer (iss) claim");
        if (!claims.containsKey("aud"))
            throw new InvalidTokenException("token must contain audience (aud) claim");


        final String jwtIssuer = (String) claims.get(ISS_CLAIM);
        if (!Arrays.stream(acceptedIssuers.toArray()).anyMatch(x -> x.equals(jwtIssuer))) {
            throw new InvalidTokenException("Invalid Issuer (iss) claim: " + jwtIssuer);
        }

        final String jwtAud = (String) claims.get(AUD_CLAIM);
        if (!jwtAud.equals(V1_AUD_PREFIX + audienceId)) {
            throw new InvalidTokenException("Invalid Audience (aud) claim: " + jwtAud);
        }

        final String jwtClient = (String) claims.get(CLIENT_ID);
        if (!jwtClient.equals(clientId)) {
            throw new InvalidTokenException("Invalid Client (appid) claim: " + jwtClient);
        }

    }
}
