package com.ossez.edtestbank.tests;

import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.dao.factories.QuestionFactory;
import com.ossez.edtestbank.common.models.orm.QuestionIndex;
import com.ossez.edtestbank.common.models.orm.QTitle;
import com.ossez.edtestbank.common.service.QuestionService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Question Testing
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuestionTest {
    private static Logger logger = LoggerFactory.getLogger(QuestionTest.class);

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
    public void testGetQuestionIndex()  {
        QuestionIndex questionIndex = QuestionService.getQuestionIndex(1L);
        logger.debug("Questions Content - {}", questionIndex.getqTitleList().size());
//        logger.debug("Questions Content - {}", questionIndex.getqTitleList().get(0).getqDescription().getDescriptionCtx());

        for (QTitle qTitle: questionIndex.getqTitleList()) {
            logger.debug("Questions Title Ctx - {}", qTitle.getQuestionTitle());
        }


        // make sure the customer was found
        assertNotNull(questionIndex);
    }

    /**
     * Tests search functionality for the customer object.
     */
    @Test
    public void testGetQTitle() {
        QTitle qTitle = QuestionFactory.getQTitleById(1L);
        logger.debug("Question Title Content - {}", qTitle.getQuestionTitle());
    }


}


