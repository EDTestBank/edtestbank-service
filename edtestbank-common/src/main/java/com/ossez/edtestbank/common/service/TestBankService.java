package com.ossez.edtestbank.common.service;

import com.ossez.edtestbank.common.dao.factories.TestBankFactory;
import com.ossez.edtestbank.common.model.entity.TestBank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * TestBankService to Process data logic
 *
 * @author YuCheng Hu
 */
public class TestBankService {
    private static final Logger logger = LoggerFactory.getLogger(TestBankService.class);

    /**
     *
     */

    public static TestBank getTestBank(Long id) {
        return TestBankFactory.getTestBank(id);
    }

    public static List<TestBank> searchTestBank() {
        return TestBankFactory.searchTestBank();
    }

}
