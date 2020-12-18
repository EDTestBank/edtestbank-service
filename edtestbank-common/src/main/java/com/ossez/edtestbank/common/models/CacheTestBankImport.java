package com.ossez.edtestbank.common.models;

import com.ossez.edtestbank.common.dao.DataObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(catalog = "edtestbank", name = "CacheTestBankImport")
public class CacheTestBankImport extends DataObject implements Serializable {
    private static final long serialVersionUID = -7594123826762558915L;

    private Long parentId;
    private String description;
    private String title;
    private String questionA;
    private String questionB;
    private String questionC;
    private String questionD;
    private String questionE;
    private String questionF;
    private String answer;
    private String answerNote;
    private String csvFileName;


    public CacheTestBankImport() {
        this.setDateCreated(new Date());
        this.setDateModified(this.getDateCreated());
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestionA() {
        return questionA;
    }

    public void setQuestionA(String questionA) {
        this.questionA = questionA;
    }

    public String getQuestionB() {
        return questionB;
    }

    public void setQuestionB(String questionB) {
        this.questionB = questionB;
    }

    public String getQuestionC() {
        return questionC;
    }

    public void setQuestionC(String questionC) {
        this.questionC = questionC;
    }

    public String getQuestionD() {
        return questionD;
    }

    public void setQuestionD(String questionD) {
        this.questionD = questionD;
    }

    public String getQuestionE() {
        return questionE;
    }

    public void setQuestionE(String questionE) {
        this.questionE = questionE;
    }

    public String getQuestionF() {
        return questionF;
    }

    public void setQuestionF(String questionF) {
        this.questionF = questionF;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerNote() {
        return answerNote;
    }

    public void setAnswerNote(String answerNote) {
        this.answerNote = answerNote;
    }

    public String getCsvFileName() {
        return csvFileName;
    }

    public void setCsvFileName(String csvFileName) {
        this.csvFileName = csvFileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CacheTestBankImport that = (CacheTestBankImport) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(description, that.description)
                .append(title, that.title)
                .append(questionA, that.questionA)
                .append(questionB, that.questionB)
                .append(questionC, that.questionC)
                .append(questionD, that.questionD)
                .append(questionE, that.questionE)
                .append(questionF, that.questionF)
                .append(answer, that.answer)
                .append(answerNote, that.answerNote)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(description)
                .append(title)
                .append(questionA)
                .append(questionB)
                .append(questionC)
                .append(questionD)
                .append(questionE)
                .append(questionF)
                .append(answer)
                .append(answerNote)
                .toHashCode();
    }
}
