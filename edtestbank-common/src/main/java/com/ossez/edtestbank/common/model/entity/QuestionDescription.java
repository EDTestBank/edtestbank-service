package com.ossez.edtestbank.common.model.entity;

import com.ossez.edtestbank.common.dao.DataObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(catalog = "edtestbank", name = "QUESTION_DESCRIPTION")
public class QuestionDescription extends DataObject implements Serializable {
    private static final long serialVersionUID = 4447958368094347892L;

    private String descriptionCtx;


    public QuestionDescription() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDescriptionCtx() {
        return descriptionCtx;
    }

    public void setDescriptionCtx(String descriptionCtx) {
        this.descriptionCtx = descriptionCtx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        QuestionDescription that = (QuestionDescription) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(descriptionCtx, that.descriptionCtx)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(descriptionCtx)
                .toHashCode();
    }
}
