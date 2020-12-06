package com.ossez.edtestbank.service.test;


import com.ossez.edtestbank.common.SCOConstants;
import com.ossez.edtestbank.service.test.utilities.TokenTestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * AuthorizeTokenTest to test Spring framework with AAD Token
 *
 * @author YuCheng Hu
 */
@AutoConfigureMockMvc
@WebMvcTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuthorizeTokenTest {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizeTokenTest.class);

    private static final String FILE_NAME_VALID_JWT = "jwt-valid.txt";
    private static final String FILE_NAME_INVALID_JWT = "jwt-invalid.txt";
    private static final String FILE_NAME_EXPIRED_JWT = "jwt-expired.txt";

    private final static String URL_TEMPLATE = "/search/user";

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public void setUp() throws Exception {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
    }

    /**
     * @throws Exception
     */
    @Test
    public void testValidToken() throws Exception {
        logger.debug("Run Valid Token, API should return http code 200");
        String validJwt = FileUtils.readFileToString(new File(SCOConstants.PATH_DATA_EXCHANGE + SCOConstants.INPUT_DATA_FOLDER + "/" + FILE_NAME_VALID_JWT));

        MvcResult result = mockMvc.perform(post(URL_TEMPLATE).with(bearerToken(validJwt))).andExpect(status().isOk()).andReturn();
        assertNotNull(result.getResponse().getContentAsString());
    }

    /**
     * Test Invalid Token
     *
     * @throws Exception
     */
    @Test
    public void testInvalidToken() throws Exception {
        logger.debug("Run Valid Token, API should return http code 401");

        String invalidJwt = FileUtils.readFileToString(new File(SCOConstants.PATH_DATA_EXCHANGE + SCOConstants.INPUT_DATA_FOLDER + "/" + FILE_NAME_INVALID_JWT));

        MvcResult result = mockMvc.perform(post(URL_TEMPLATE).with(TokenTestUtils.bearerToken(invalidJwt))).andExpect(status().is4xxClientError()).andReturn();
        assertNotNull(result.getResponse().getContentAsString());
    }

    /**
     * @throws Exception
     */
    @Test
    public void testModifiedToken() throws Exception {
        logger.debug("Run Valid Token, API should return http code 401");

        String validJwt = FileUtils.readFileToString(new File(SCOConstants.PATH_DATA_EXCHANGE + SCOConstants.INPUT_DATA_FOLDER + "/" + FILE_NAME_VALID_JWT));

        MvcResult result = mockMvc.perform(post(URL_TEMPLATE).with(bearerToken(validJwt))).andExpect(status().is4xxClientError()).andReturn();
        assertNotNull(result.getResponse().getContentAsString());
    }


    /**
     * Test Expired Token
     *
     * @throws Exception
     */
    @Test
    public void testExpiredToken() throws Exception {
        logger.debug("Run Expired Token, API should return http code 401");

        String expiredJwt = FileUtils.readFileToString(new File(SCOConstants.PATH_DATA_EXCHANGE + SCOConstants.INPUT_DATA_FOLDER + "/" + FILE_NAME_EXPIRED_JWT));

        MvcResult result = mockMvc.perform(post(URL_TEMPLATE).with(TokenTestUtils.bearerToken(expiredJwt))).andExpect(status().is4xxClientError()).andReturn();
        assertNotNull(result.getResponse().getContentAsString());
    }


    /**
     * @throws Exception
     */
    @Test
    public void testNULLToken() throws Exception {
        logger.debug("Run Valid Token, API should return http code 401");

        MvcResult result = mockMvc.perform(post(URL_TEMPLATE).with(TokenTestUtils.bearerToken(StringUtils.EMPTY))).andExpect(status().is4xxClientError()).andReturn();
        assertNotNull(result.getResponse().getContentAsString());
    }


    /**
     * @throws Exception
     */
    @Test
    public void testGetBirthdayDOW() throws Exception {
        testDOW("SATURDAY");

    }

    /**
     * SET Token String to Bearer
     *
     * @param token
     * @return
     */
    private static BearerTokenRequestPostProcessor bearerToken(String token) {
        return new BearerTokenRequestPostProcessor(token);
    }

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


    /**
     * @param dow
     * @throws Exception
     */
    private void testDOW(String dow) throws Exception {
        String token = "xxx";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/search/user")
                .header("authentication", "Bearer " + token))
                .andExpect(status().is4xxClientError())
                .andReturn();
    }
}
