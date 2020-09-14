package com.ossez.edtestbank.common.models;

import com.ossez.edtestbank.common.DataObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(catalog = "edtestbank", name = "QIndex")
public class QIndex extends DataObject implements Serializable {

    private static final long serialVersionUID = -4012870143841922864L;

    private String questions;
    @OneToMany(mappedBy = "qIndex")
    @OrderBy("questionNumber ASC")
    private List<QTitle> qTitleList = new ArrayList<>();


    public QIndex() {
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        QIndex qIndex = (QIndex) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(questions, qIndex.questions)
                .isEquals();
    }

    public List<QTitle> getqTitleList() {
        return qTitleList;
    }

    public void setqTitleList(List<QTitle> qTitleList) {
        this.qTitleList = qTitleList;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(questions)
                .toHashCode();
    }
}
