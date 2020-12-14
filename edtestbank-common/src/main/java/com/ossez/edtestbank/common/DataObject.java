package com.ossez.edtestbank.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Resolution;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * DataObject
 *
 * @author YuCheng Hu
 */
@MappedSuperclass
public abstract class DataObject {
    public abstract interface Save {

    }

    public abstract interface Update {

    }

    public static final String ID_PROPERTY_NAME = "id";
    public static final String CREATE_DATE_PROPERTY_NAME = "createDate";
    public static final String MODIFY_DATE_PROPERTY_NAME = "modifyDate";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_modified")
    private Date dateModified;

    private String uuid;

    @JsonProperty
    @DocumentId
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return
     */
    @JsonProperty
    @DateBridge(resolution = Resolution.SECOND)
    @Column(nullable = false, updatable = false)
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }




    /**
     * @return
     */
    @JsonProperty
    @DateBridge(resolution = Resolution.SECOND)
    @Column(nullable = false)
    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataObject that = (DataObject) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
