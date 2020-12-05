package com.ossez.edtestbank.common.models.orm;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ossez.edtestbank.common.dao.DataObject;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

/**
 * ORM For Table: COMMON_MANUFACTURER
 *
 * @author YuCheng Hu
 */
@Entity
@Indexed
@Table(name = "COMMON_MANUFACTURER", schema = "DBO")
public class CommonManufacturer extends DataObject implements Serializable {
    private static final long serialVersionUID = -8280289776446293064L;

    private static Logger logger = LoggerFactory.getLogger(CommonManufacturer.class);

    @Column(name = "name")
    @Field
    private String manufacturerName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "common_manufacturer_id")
    @JsonManagedReference
    private Set<Alias> aliasSet;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "common_manufacturer_id")
    @JsonManagedReference
    private Set<Xref> xrefSet;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "common_manufacturer_id")
    @JsonManagedReference
    private Set<Sourcing> sourcingSet;

    /**
     * Constructor
     */
    public CommonManufacturer() {
        this.setDateCreated(new Date());
        this.setDateModified(new Date());
        this.setUuid(UUID.randomUUID().toString());
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Set<Alias> getAliasesSet() {
        return aliasSet;
    }

    public Set<Sourcing> getSourcingSet() {
        return sourcingSet;
    }

    public Set<Xref> getXrefSet() {
        return xrefSet;
    }
}
