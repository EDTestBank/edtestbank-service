package com.ossez.edtestbank.common.models.orm;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ossez.edtestbank.common.DataObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Entity for Table QTitle
 */
@Entity
@Table(catalog = "edtestbank", name = "QUESTION_TITLE")
public class QuestionTitle extends DataObject implements Serializable {
    private static final long serialVersionUID = -3772701853278423848L;

    @ManyToOne
    @JsonBackReference
    private Question question;

    @OneToOne
    private QuestionDescription questionDescription;

    private String questionTitle;
    private int questionNumber;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public QuestionDescription getqDescription() {
        return questionDescription;
    }

    public void setqDescription(QuestionDescription questionDescription) {
        this.questionDescription = questionDescription;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        QuestionTitle questionTitle = (QuestionTitle) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(this.questionTitle, questionTitle.questionTitle)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(questionTitle)
                .toHashCode();
    }
}
