package com.ossez.edtestbank.common.model.entity;

import com.ossez.edtestbank.common.dao.DataObject;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(catalog = "edtestbank", name = "QUESTION_INDEX")
public class QuestionIndex extends DataObject implements Serializable {

    private static final long serialVersionUID = 4245766639954964199L;

    @Column(name = "description")
    private String description;

    public QuestionIndex() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
