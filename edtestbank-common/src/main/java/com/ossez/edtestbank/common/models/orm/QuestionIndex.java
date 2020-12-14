package com.ossez.edtestbank.common.models.orm;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ossez.edtestbank.common.DataObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(catalog = "edtestbank", name = "QUESTION_INDEX")
public class QuestionIndex extends DataObject implements Serializable {

    private static final long serialVersionUID = -4012870143841922864L;

    public QuestionIndex() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
