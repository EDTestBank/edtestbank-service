package com.ossez.edtestbank.common.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ossez.edtestbank.common.dao.DataObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;

/**
 * ORM For Table: MATCHING
 */
@Entity
@Table(catalog = "edtestbank", name = "TESTBANK_SUBJECT")
public class TestBankSubject extends DataObject implements Serializable {


    private static Logger logger = LoggerFactory.getLogger(TestBankSubject.class);

//    @ManyToOne
//    @JsonBackReference
//    private TestBank testBank;

    @Column(name = "order_seq")
    private int orderSeq;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    @JsonManagedReference
    private Subject subject;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
//    private Subject subject;



    public int getOrderSeq() {

        return orderSeq;
    }

    public void setOrderSeq(int orderSeq) {
        this.orderSeq = orderSeq;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

//    public TestBank getTestBank() {
//        return testBank;
//    }
//
//    public void setTestBank(TestBank testBank) {
//        this.testBank = testBank;
//    }
}
