package com.ossez.edtestbank.common.models.orm;

import com.ossez.edtestbank.common.dao.DataObject;
import com.ossez.edtestbank.common.models.VendorPreference;
import org.hibernate.search.annotations.Indexed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * ORM For Table: SOURCING
 *
 * @author YuCheng Hu
 */
@Entity
@Indexed
@Table(name = "SOURCING", schema = "DBO")
public class Sourcing extends DataObject implements Serializable {
    private static final long serialVersionUID = -5838121102958692727L;

    private static Logger logger = LoggerFactory.getLogger(Sourcing.class);

    @Column(name = "common_manufacturer_id")
    private long commonManufacturerId;

    @Column(name = "manufacturer_name")
    private String manufacturerName;

    @Column(name = "manufacturer_status")
    private String manufacturerStatus;

    @Column(name = "country")
    private String country;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "tier")
    private String tier;

    @Column(name = "can_source_direct")
    private String canSourceDirect;

    @Column(name = "distribution_sourcing")
    private String distributionSourcing;

    @Column(name = "risk_notes")
    private String riskNotes;

    @Column(name = "vendor_name")
    private String vendorName;

    @Enumerated(EnumType.STRING)
    @Column(name = "vendor_preference")
    private VendorPreference vendorPreference;

    @Column(name = "vendor_contact_name")
    private String vendorContactName;

    @Column(name = "vendor_contact_phone")
    private String vendorContactPhone;

    @Column(name = "vendor_contact_email")
    private String vendorContactEmail;

    @Column(name = "other_field")
    private String otherField;

    @Column(name = "notes")
    private String notes;

    /**
     * Constructor
     */
    public Sourcing() {
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

    public String getManufacturerStatus() {
        return manufacturerStatus;
    }

    public void setManufacturerStatus(String manufacturerStatus) {
        this.manufacturerStatus = manufacturerStatus;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getCanSourceDirect() {
        return canSourceDirect;
    }

    public void setCanSourceDirect(String canSourceDirect) {
        this.canSourceDirect = canSourceDirect;
    }

    public String getDistributionSourcing() {
        return distributionSourcing;
    }

    public void setDistributionSourcing(String distributionSourcing) {
        this.distributionSourcing = distributionSourcing;
    }

    public String getRiskNotes() {
        return riskNotes;
    }

    public void setRiskNotes(String riskNotes) {
        this.riskNotes = riskNotes;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public VendorPreference getVendorPreference() {
        return vendorPreference;
    }

    public void setVendorPreference(VendorPreference vendorPreference) {
        this.vendorPreference = vendorPreference;
    }

    public String getVendorContactName() {
        return vendorContactName;
    }

    public void setVendorContactName(String vendorContactName) {
        this.vendorContactName = vendorContactName;
    }

    public String getVendorContactPhone() {
        return vendorContactPhone;
    }

    public void setVendorContactPhone(String vendorContactPhone) {
        this.vendorContactPhone = vendorContactPhone;
    }

    public String getVendorContactEmail() {
        return vendorContactEmail;
    }

    public void setVendorContactEmail(String vendorContactEmail) {
        this.vendorContactEmail = vendorContactEmail;
    }

    public String getOtherField() {
        return otherField;
    }

    public void setOtherField(String otherField) {
        this.otherField = otherField;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getCommonManufacturerId() {
        return commonManufacturerId;
    }

    public void setCommonManufacturerId(long commonManufacturerId) {
        this.commonManufacturerId = commonManufacturerId;
    }
}
