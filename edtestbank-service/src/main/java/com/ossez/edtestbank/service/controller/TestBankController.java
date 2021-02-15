package com.ossez.edtestbank.service.controller;


import com.ossez.edtestbank.common.model.entity.Question;
import com.ossez.edtestbank.common.model.entity.QuestionIndex;
import com.ossez.edtestbank.common.model.entity.TestBank;
import com.ossez.edtestbank.common.service.QuestionService;
import com.ossez.edtestbank.common.service.TestBankService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TestBank Endpoint
 *
 * @author YuCheng Hu
 */
@RestController
@RequestMapping(value = "/testbank")
public class TestBankController {
    private static final Logger logger = LoggerFactory.getLogger(TestBankController.class);

    /**
     * Search TestBank
     *
     * @param id
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchTestBank(@RequestParam(required = false) String id) {
        logger.debug("Search TestBank by id or return list");
        String testBankId = StringUtils.trimToNull(id);

        if (StringUtils.isNotBlank(testBankId) && NumberUtils.isDigits(testBankId))
            return new ResponseEntity<TestBank>(TestBankService.getTestBank(NumberUtils.toLong(testBankId)), HttpStatus.OK);
        else
            return new ResponseEntity<List<TestBank>>(TestBankService.searchTestBank(), HttpStatus.OK);
    }

    /**
     * Search Question Index
     *
     * @return
     */
    @GetMapping("/question-list")
    public ResponseEntity<?> searchQuestionIndexList() {
        return new ResponseEntity<List<QuestionIndex>>(QuestionService.searchQuestionIndex(), HttpStatus.OK);
    }

    /**
     * Search Question Index
     *
     * @return
     */
    @GetMapping("/question")
    public ResponseEntity<?> searchUser(@RequestParam String uuid) {
        logger.debug("Get Question by UUID - [{}]", uuid);

        Question question = QuestionService.getQuestion(StringUtils.trimToNull(uuid));

        return new ResponseEntity<Question>(question, HttpStatus.OK);
    }

}
