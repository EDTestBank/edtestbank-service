package com.ossez.edtestbank.common.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ossez.edtestbank.common.dao.DataObject;
import org.hibernate.search.annotations.Indexed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * ORM For Table: SOURCING
 *
 * @author YuCheng Hu
 */
@Entity
@Indexed
@Table(catalog = "edtestbank", name = "QUESTION")
public class Question extends DataObject implements Serializable {
    private static final long serialVersionUID = -5838121102958692727L;

    private static Logger logger = LoggerFactory.getLogger(Question.class);

    @Column(name = "question_ctx")
    private String questionCtx;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OrderBy("questionNumber ASC")
    @JsonManagedReference
    private List<QuestionTitle> questionTitleList = new ArrayList<>();

    private String uuid;

    /**
     * Constructor
     */
    public Question() {
        this.setDateCreated(new Date());
        this.setDateModified(new Date());
        this.setUuid(UUID.randomUUID().toString());
    }

    public String getQuestionCtx() {
        return questionCtx;
    }

    public void setQuestionCtx(String questionCtx) {
        this.questionCtx = questionCtx;
    }

    public List<QuestionTitle> getqTitleList() {
        return questionTitleList;
    }

    public void setqTitleList(List<QuestionTitle> questionTitleList) {
        this.questionTitleList = questionTitleList;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
