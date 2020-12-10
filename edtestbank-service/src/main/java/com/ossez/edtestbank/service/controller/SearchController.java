package com.ossez.edtestbank.service.controller;


import com.microsoft.applicationinsights.TelemetryClient;

import com.ossez.edtestbank.common.dao.factories.QuestionFactory;
import com.ossez.edtestbank.common.models.orm.QuestionIndex;
import com.ossez.edtestbank.common.models.response.SearchResponse;
import com.ossez.edtestbank.common.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Search Endpoint
 *
 * @author YuCheng Hu
 */
@RestController
@RequestMapping(value = "/search")
public class SearchController {


    /**
     * Search Question Index
     *
     * @return
     */
    @GetMapping("/question-index")
    public ResponseEntity<?> searchUser() {

        QuestionIndex questionIndex = QuestionService.getQuestionIndex(1L);
//        SearchResponse searchResponse = new SearchResponse();
//        searchResponse.setUuid(UUID.randomUUID().toString());
//        questionIndex = new QuestionIndex();
//        questionIndex.setQuestions("dddddd");


        return new ResponseEntity<QuestionIndex>(questionIndex, HttpStatus.OK);
    }

}
