package com.ossez.edtestbank.tests;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * Test Logger and function
 * @author YuCheng Hu
 */
public class FirstTest {
    private static Logger logger = LoggerFactory.getLogger(FirstTest.class);

    @Test
    public void testNumber() {
        logger.debug("TEST NUMBERS");
        BigDecimal bd = new BigDecimal(999);


    }
}
