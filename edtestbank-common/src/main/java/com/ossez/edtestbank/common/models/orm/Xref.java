package com.ossez.edtestbank.common.models.orm;

import com.ossez.edtestbank.common.dao.DataObject;
import org.hibernate.search.annotations.Indexed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * ORM For Table: XREF
 *
 * @author YuCheng Hu
 */
@Entity
@Indexed
@Table(name = "XREF", schema = "DBO")
public class Xref extends DataObject implements Serializable {
    private static final long serialVersionUID = 870272993799063662L;

    private static Logger logger = LoggerFactory.getLogger(Xref.class);

    @Column(name = "common_manufacturer_id")
    private long commonManufacturerId;

    @Column(name = "name")
    private String xrefName;

    @Column(name = "source")
    private String sourcing;

    @Column(name = "source_id")
    private String sourcingId;

    /**
     * Constructor
     */
    public Xref() {
        this.setDateCreated(new Date());
        this.setDateModified(new Date());
        this.setUuid(UUID.randomUUID().toString());
    }

    public String getXrefName() {
        return xrefName;
    }

    public void setXrefName(String xrefName) {
        this.xrefName = xrefName;
    }

    public String getSourcing() {
        return sourcing;
    }

    public void setSourcing(String sourcing) {
        this.sourcing = sourcing;
    }

    public String getSourcingId() {
        return sourcingId;
    }

    public void setSourcingId(String sourcingId) {
        this.sourcingId = sourcingId;
    }

    public long getCommonManufacturerId() {
        return commonManufacturerId;
    }

    public void setCommonManufacturerId(long commonManufacturerId) {
        this.commonManufacturerId = commonManufacturerId;
    }
}
