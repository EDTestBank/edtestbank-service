package com.ossez.edtestbank.service.test.utilities;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

/**
 *
 */
public class TokenTestUtils {

    /**
     * <p>
     * {@code } instances should NOT be constructed in standard
     * programming. Instead, the class should be used as
     * {@code RandomUtils.getHMAC256Token(User);}.
     * </p>
     *
     * <p>
     * This constructor is public to permit tools that require a JavaBean
     * instance to operate.
     * </p>
     */
    public TokenTestUtils() {
        super();
    }

    /**
     * @param token
     * @return
     */
    public static String decodHMAC256Token(String token) {

        return token;
    }

    /**
     * verify token
     *
     * @param token
     * @return
     */
    public static Boolean isValid(String token) {
        return true;
    }

    /**
     * SET Token String to Bearer
     * @param token
     * @return
     */
    public static BearerTokenRequestPostProcessor bearerToken(String token) {
        return new BearerTokenRequestPostProcessor(token);
    }

    /**
     * Insert to MockHttpServletRequest
     */
    private static class BearerTokenRequestPostProcessor implements RequestPostProcessor {

        private String token;

        public BearerTokenRequestPostProcessor(String token) {
            this.token = token;
        }

        @Override
        public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
            request.addHeader("Authorization", "Bearer " + this.token);
            return request;
        }

    }


}