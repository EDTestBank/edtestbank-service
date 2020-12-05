package com.ossez.edtestbank.common.models.orm;

import com.ossez.edtestbank.common.dao.DataObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * ORM For Table: ALIASES
 *
 * @author YuCheng Hu
 */
@Entity
@Table(name = "ALIAS", schema = "DBO")
public class Alias extends DataObject implements Serializable {
    private static final long serialVersionUID = 300583572818846362L;

    private static Logger logger = LoggerFactory.getLogger(Alias.class);

    @Column(name = "common_manufacturer_id")
    private long commonManufacturerId;

    @Column(name = "alias")
    private String manufacturerAlias;

    /**
     * Constructor
     */
    public Alias() {
        this.setDateCreated(new Date());
        this.setDateModified(new Date());
        this.setUuid(UUID.randomUUID().toString());
    }

    public String getManufacturerAlias() {
        return manufacturerAlias;
    }

    public void setManufacturerAlias(String manufacturerAlias) {
        this.manufacturerAlias = manufacturerAlias;
    }

    public long getCommonManufacturerId() {
        return commonManufacturerId;
    }

    public void setCommonManufacturerId(long commonManufacturerId) {
        this.commonManufacturerId = commonManufacturerId;
    }
}
