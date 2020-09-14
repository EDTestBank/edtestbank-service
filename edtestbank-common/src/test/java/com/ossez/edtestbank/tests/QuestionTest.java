package com.ossez.edtestbank.tests;

import com.ossez.edtestbank.common.Factory;
import com.ossez.edtestbank.common.ValidationException;
import com.ossez.edtestbank.common.dao.factories.QuestionFactory;
import com.ossez.edtestbank.common.models.QIndex;
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
        Factory.beginTransaction();
    }

    @AfterAll
    protected void tearDown() throws Exception {
        Factory.rollbackTransaction();
    }

    /**
     * Tests search functionality for the customer object.
     */
    @Test
    public void testGetQIndex() throws ValidationException {
        QIndex qIndex = QuestionFactory.getQIndexById(1L);
        logger.debug("Questions Content - {}", qIndex.getQuestions());

        // make sure the customer was found

        assertNotNull(qIndex);

    }

}
