package com.ossez.edtestbank.common.models.orm;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * ORM For Table: MATCHING
 */
@Entity
@Indexed
@Table(name = "MATCHING", schema = "DBO")
public class Matching implements Serializable {
    private static final long serialVersionUID = 1693990211007417357L;

    private static Logger logger = LoggerFactory.getLogger(Matching.class);

    @Id
    private Long id;

    @Column(name = "match_name")
    private String matchName;

    @Field
    @Column(name = "match_type")
    private String matchType;

    @Column(name = "common_manufacturer_id")
    private String commonManufacturerId;

    @Column(name = "common_manufacturer_name")
    private String commonManufacturerName;

    /**
     * Constructor
     */
    public Matching() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getCommonManufacturerId() {
        return commonManufacturerId;
    }

    public void setCommonManufacturerId(String commonManufacturerId) {
        this.commonManufacturerId = commonManufacturerId;
    }

    public String getCommonManufacturerName() {
        return commonManufacturerName;
    }

    public void setCommonManufacturerName(String commonManufacturerName) {
        this.commonManufacturerName = commonManufacturerName;
    }
}
