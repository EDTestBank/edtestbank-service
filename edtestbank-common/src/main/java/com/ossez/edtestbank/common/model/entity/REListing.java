package com.ossez.edtestbank.common.model.entity;

import com.ossez.edtestbank.common.dao.DataObject;
import org.hibernate.search.annotations.Indexed;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ORM For Table: REListing
 *
 * @author YuCheng Hu
 */
@Entity
@Indexed
@Table(catalog = "reoctx", name = "re_listing")
public class REListing extends DataObject implements Serializable {
    private static final long serialVersionUID = -5838121102958692727L;

    private static Logger logger = LoggerFactory.getLogger(REListing.class);

    @Column(name = "mls_id")
    private Long mlsId;

    @Column(name = "mls_state")
    private String mlsState;

    @Column(name = "property_class")
    private String propertyClass;

    @Column(name = "property_type")
    private String propertyType;

    @Column(name = "property_address")
    private String propertyAddress;

    @Column(name = "property_town")
    private String propertyTown;

    @Column(name = "property_state")
    private String propertyState;

    @Column(name = "property_county")
    private String propertyCunty;

    @Column(name = "dom")
    private Integer dom;

    @Column(name = "price_listing")
    private BigDecimal priceListing;

    @Column(name = "price_closed")
    private BigDecimal priceClosed;

    @Column(name = "date_listed")
    private DateTime dateListed;

    @Column(name = "date_closed")
    private DateTime dateClosed;


    /**
     * Constructor
     */
    public REListing() {
        this.setDateCreated(new Date());
        this.setDateModified(new Date());
    }

    public Long getMlsId() {
        return mlsId;
    }

    public void setMlsId(Long mlsId) {
        this.mlsId = mlsId;
    }

    public String getMlsState() {
        return mlsState;
    }

    public void setMlsState(String mlsState) {
        this.mlsState = mlsState;
    }

    public String getPropertyClass() {
        return propertyClass;
    }

    public void setPropertyClass(String propertyClass) {
        this.propertyClass = propertyClass;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getPropertyTown() {
        return propertyTown;
    }

    public void setPropertyTown(String propertyTown) {
        this.propertyTown = propertyTown;
    }

    public String getPropertyState() {
        return propertyState;
    }

    public void setPropertyState(String propertyState) {
        this.propertyState = propertyState;
    }

    public String getPropertyCunty() {
        return propertyCunty;
    }

    public void setPropertyCunty(String propertyCunty) {
        this.propertyCunty = propertyCunty;
    }

    public Integer getDom() {
        return dom;
    }

    public void setDom(Integer dom) {
        this.dom = dom;
    }

    public BigDecimal getPriceListing() {
        return priceListing;
    }

    public void setPriceListing(BigDecimal priceListing) {
        this.priceListing = priceListing;
    }

    public BigDecimal getPriceClosed() {
        return priceClosed;
    }

    public void setPriceClosed(BigDecimal priceClosed) {
        this.priceClosed = priceClosed;
    }

    public DateTime getDateListed() {
        return dateListed;
    }

    public void setDateListed(DateTime dateListed) {
        this.dateListed = dateListed;
    }

    public DateTime getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(DateTime dateClosed) {
        this.dateClosed = dateClosed;
    }
}
