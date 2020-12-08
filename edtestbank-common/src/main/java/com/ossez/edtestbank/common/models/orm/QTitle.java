package com.ossez.edtestbank.common.models.orm;

import com.ossez.edtestbank.common.DataObject;
import com.ossez.edtestbank.common.models.QDescription;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Entity for Table QTitle
 */
@Entity
@Table(catalog = "edtestbank", name = "QTitle")
public class QTitle extends DataObject implements Serializable {
    private static final long serialVersionUID = -3772701853278423848L;

    @ManyToOne
    private QuestionIndex questionIndex;
    @OneToOne
    private QDescription qDescription;

    private String questionTitle;
    private int questionNumber;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public QuestionIndex getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(QuestionIndex questionIndex) {
        this.questionIndex = questionIndex;
    }

    public QDescription getqDescription() {
        return qDescription;
    }

    public void setqDescription(QDescription qDescription) {
        this.qDescription = qDescription;
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

        QTitle qTitle = (QTitle) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(questionTitle, qTitle.questionTitle)
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
