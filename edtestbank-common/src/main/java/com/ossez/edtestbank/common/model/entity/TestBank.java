package com.ossez.edtestbank.common.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ossez.edtestbank.common.dao.DataObject;
import org.hibernate.search.annotations.Indexed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * ORM For Table: XREF
 *
 * @author YuCheng Hu
 */
@Entity
@Indexed
@Table(catalog = "edtestbank", name = "TESTBANK")
public class TestBank extends DataObject implements Serializable {
    private static final long serialVersionUID = 3872779526682815204L;

    private static Logger logger = LoggerFactory.getLogger(TestBank.class);

    @Column(name = "testbank_name")
    private String testbankName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "testbank_id")
    @OrderBy("orderSeq ASC")
    @JsonManagedReference
//    @OneToMany(mappedBy = "testBank", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @OrderBy("orderSeq ASC")
//    @JsonManagedReference
    private List<TestBankSubject> testBankSubjects = new ArrayList<TestBankSubject>();


    /**
     * Constructor
     */
    public TestBank() {
        this.setDateCreated(new Date());
        this.setDateModified(new Date());
    }

    public String getTestbankName() {
        return testbankName;
    }

    public void setTestbankName(String testbankName) {
        this.testbankName = testbankName;
    }

    public List<TestBankSubject> getTestBankSubjects() {
        return testBankSubjects;
    }

    public void setTestBankSubjects(List<TestBankSubject> testBankSubjects) {
        this.testBankSubjects = testBankSubjects;
    }
}
