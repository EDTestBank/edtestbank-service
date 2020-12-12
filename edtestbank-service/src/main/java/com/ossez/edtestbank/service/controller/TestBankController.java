package com.ossez.edtestbank.service.controller;


import com.ossez.edtestbank.common.SCOConstants;
import com.ossez.edtestbank.common.models.orm.QuestionIndex;
import com.ossez.edtestbank.common.service.QuestionService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * question Endpoint
 *
 * @author YuCheng Hu
 */
@RestController
@RequestMapping(value = "/testbank")
public class TestBankController {
    private static final Logger logger = LoggerFactory.getLogger(TestBankController.class);

    /**
     * Search Question Index
     *
     * @return
     */
    @GetMapping("/question")
    public ResponseEntity<?> searchUser(@RequestParam String uuid) {
        logger.debug("Get Question by UUID - [{}]", uuid);

        QuestionIndex questionIndex = QuestionService.getQuestionIndex(StringUtils.trimToNull(uuid));
        
        return new ResponseEntity<QuestionIndex>(questionIndex, HttpStatus.OK);
    }

}
