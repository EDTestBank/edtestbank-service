package com.ossez.edtestbank.common.models;

import java.io.Serializable;

/**
 * ParsedFile Object need to output for OBJ
 *
 * @author YuCheng Hu
 */
public class ProcessedFileEntry implements Serializable {
    private static final long serialVersionUID = 2789464328633821485L;

    private String vendorName;
    private Integer rowRef;
    private String matchFound;
    private String exactMatch;
    private String CommonManufacturerName;
    private Long CommonManufacturerId;
    private String matchType;
    private String globalCanSourceDirect;
    private String globalDistributionSourcing;

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getMatchFound() {
        return matchFound;
    }

    public Integer getRowRef() {
        return rowRef;
    }

    public void setRowRef(Integer rowRef) {
        this.rowRef = rowRef;
    }

    public void setMatchFound(String matchFound) {
        this.matchFound = matchFound;
    }

    public String getExactMatch() {
        return exactMatch;
    }

    public void setExactMatch(String exactMatch) {
        this.exactMatch = exactMatch;
    }

    public String getCommonManufacturerName() {
        return CommonManufacturerName;
    }

    public void setCommonManufacturerName(String commonManufacturerName) {
        CommonManufacturerName = commonManufacturerName;
    }

    public Long getCommonManufacturerId() {
        return CommonManufacturerId;
    }

    public void setCommonManufacturerId(Long commonManufacturerId) {
        CommonManufacturerId = commonManufacturerId;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getGlobalCanSourceDirect() {
        return globalCanSourceDirect;
    }

    public void setGlobalCanSourceDirect(String globalCanSourceDirect) {
        this.globalCanSourceDirect = globalCanSourceDirect;
    }

    public String getGlobalDistributionSourcing() {
        return globalDistributionSourcing;
    }

    public void setGlobalDistributionSourcing(String globalDistributionSourcing) {
        this.globalDistributionSourcing = globalDistributionSourcing;
    }
}
