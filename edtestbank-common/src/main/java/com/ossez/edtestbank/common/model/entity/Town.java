package com.ossez.edtestbank.common.model.entity;

import com.ossez.edtestbank.common.dao.DataObject;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * ORM For Table: REListing
 *
 * @author YuCheng Hu
 */
@Entity
@Indexed
@Table(catalog = "reoctx", name = "town")
public class Town extends DataObject implements Serializable {
    private static final long serialVersionUID = -5642825200496609111L;

    @Column(name = "municipal")
    private String municipal;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;


    /**
     * Constructor
     */
    public Town() {
        this.setDateCreated(new Date());
        this.setDateModified(new Date());
    }

    public String getMunicipal() {
        return municipal;
    }

    public void setMunicipal(String municipal) {
        this.municipal = municipal;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
