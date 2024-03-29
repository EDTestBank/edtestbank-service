package com.ossez.edtestbank.common.service;

import com.ossez.edtestbank.common.dao.factories.CommonManufacturerFactory;
import com.ossez.edtestbank.common.dao.factories.QuestionFactory;
import com.ossez.edtestbank.common.models.orm.*;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

/**
 * QuestionService to Process data logic
 *
 * @author YuCheng Hu
 */
public class QuestionService {
    private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

    /**
     *
     */
    public static QuestionIndex getQuestionIndex(Long id) {
        return QuestionFactory.getQuestionIndex(id);
    }

    public static Question getQuestion(Long id) {
        return QuestionFactory.getQuestion(id);
    }

    public static Question getQuestion(String uuid) {
        return QuestionFactory.getQuestion(uuid);
    }

    public static QuestionIndex getQuestionIndex(String uuid) {
        return QuestionFactory.getQuestionIndex(uuid);
    }

    public static List<QuestionIndex> searchQuestionIndex() {
        return QuestionFactory.searchQuestionIndex();
    }

}
