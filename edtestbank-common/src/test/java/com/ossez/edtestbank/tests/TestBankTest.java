package com.ossez.edtestbank.tests;

import com.ossez.edtestbank.common.model.entity.TestBank;
import com.ossez.edtestbank.common.service.TestBankService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Question Testing
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBankTest {
    private static Logger logger = LoggerFactory.getLogger(TestBankTest.class);

    @BeforeAll
    protected void setUp() throws Exception {
//        Factory.beginTransaction();
    }

    @AfterAll
    protected void tearDown() throws Exception {
//        Factory.rollbackTransaction();
    }

    /**
     * Tests search functionality for the customer object.
     */
    @Test
    public void testGetTestBank()  {
        TestBank testBank = TestBankService.getTestBank(1L);
        logger.debug("Questions Content - {}", testBank.getTestbankName());
        logger.debug("Questions Content - {}", testBank.getTestBankSubjects().get(0).getSubject().getSubjectName());
        logger.debug("Questions Content - {}", testBank.getTestBankSubjects().get(1).getSubject().getSubjectName());
////        logger.debug("Questions Content - {}", questionIndex.getqTitleList().get(0).getqDescription().getDescriptionCtx());
//
//        for (QuestionTitle questionTitle : question.getqTitleList()) {
//            logger.debug("Questions Title Ctx - {}", questionTitle.getQuestionTitle());
//        }
//
//
//        // make sure the customer was found
//        assertNotNull(question);
    }

    /**
     * Tests search functionality for the customer object.
     */
    @Test
    public void testSearchTestBank() {
        List<TestBank> testBankList = TestBankService.searchTestBank();
        logger.debug("Question Title Content - {}", testBankList.get(0).getTestBankSubjects().get(0).getSubject().getSubjectName());
    }

}


