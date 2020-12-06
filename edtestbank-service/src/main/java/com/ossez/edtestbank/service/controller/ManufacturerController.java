package com.ossez.edtestbank.service.controller;


import com.ossez.edtestbank.common.SCOConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/manufacturer")

public class ManufacturerController {
    private static final Logger logger = LoggerFactory.getLogger(ManufacturerController.class);

    /**
     * @param token
     * @return
     */
    @GetMapping("/question")
    public ResponseEntity<?> getCommonManufacturerNameById(@RequestHeader(name = SCOConstants.TOKEN_HEADER) String token) {
        String searchStr = "Search Manufacturer";

        return new ResponseEntity<String>(searchStr, HttpStatus.OK);
    }

}
