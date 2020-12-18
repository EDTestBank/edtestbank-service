package com.ossez.edtestbank.common.models.orm;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ossez.edtestbank.common.dao.DataObject;
import org.hibernate.search.annotations.Indexed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ORM For Table: Subject
 *
 * @author YuCheng Hu
 */

@Entity
@Indexed
@Table(catalog = "edtestbank", name = "SUBJECT")
public class Subject extends DataObject implements Serializable {
    private static final long serialVersionUID = 870272993799063662L;

    private static Logger logger = LoggerFactory.getLogger(Subject.class);

    @Column(name = "subject_name")
    private String subjectName;

    @OneToOne(mappedBy = "subject")
    @JsonBackReference
    private TestBankSubject testBankSubject;

    /**
     * Constructor
     */
    public Subject() {
        this.setDateCreated(new Date());
        this.setDateModified(new Date());
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public TestBankSubject getTestBankSubject() {
        return testBankSubject;
    }

    public void setTestBankSubject(TestBankSubject testBankSubject) {
        this.testBankSubject = testBankSubject;
    }
}
