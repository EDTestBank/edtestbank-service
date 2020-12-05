package com.ossez.edtestbank.common.models.orm;

import com.ossez.edtestbank.common.dao.DataObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "MYSCOFILE", schema = "DBO")
public class MyScoFile extends DataObject implements Serializable {
    private static final long serialVersionUID = 5530454436970805656L;

    private static Logger logger = LoggerFactory.getLogger(MyScoFile.class);

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "input_file_name")
    private String inputFileName;

    @Column(name = "file_count_row")
    private Integer fileCountRow;

    @Column(name = "file_count_alias_match")
    private Integer fileCountAliasMatch;

    @Column(name = "file_count_direct_match")
    private Integer fileCountDirectMatch;

    @Column(name = "file_count_no_match")
    private Integer fileCountNoMatch;

    @Column(name = "file_status")
    private String fileStatus;

    @Column(name = "file_sha3")
    private String fileSHA3;

    @Column(name = "azure_input_file_etag")
    private String azureInputFileEtag;

    @Column(name = "azure_output_file_etag")
    private String azureOutputFileEtag;

    @Column(name = "azure_input_file_uuid")
    private String azureInputFileUUID;

    @Column(name = "azure_output_file_uuid")
    private String azureOutputFileUUID;


    /**
     * Constructor
     */
    public MyScoFile() {
        this.setAzureInputFileUUID(UUID.randomUUID().toString());
        this.setDateCreated(new Date());
        this.setDateModified(new Date());
        this.setUuid(UUID.randomUUID().toString());
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getCustomerFileName() {
        return customerName;
    }

    public void setCustomerFileName(String customerName) {
        this.customerName = customerName;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public Integer getFileCountRow() {
        return fileCountRow;
    }

    public void setFileCountRow(Integer fileCountRow) {
        this.fileCountRow = fileCountRow;
    }

    public Integer getFileCountAliasMatch() {
        return fileCountAliasMatch;
    }

    public void setFileCountAliasMatch(Integer fileCountAliasMatch) {
        this.fileCountAliasMatch = fileCountAliasMatch;
    }

    public Integer getFileCountDirectMatch() {
        return fileCountDirectMatch;
    }

    public void setFileCountDirectMatch(Integer fileCountDirectMatch) {
        this.fileCountDirectMatch = fileCountDirectMatch;
    }

    public Integer getFileCountNoMatch() {
        return fileCountNoMatch;
    }

    public void setFileCountNoMatch(Integer fileCountNoMatch) {
        this.fileCountNoMatch = fileCountNoMatch;
    }

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }

    public String getFileSHA3() {
        return fileSHA3;
    }

    public void setFileSHA3(String fileSHA3) {
        this.fileSHA3 = fileSHA3;
    }

    public String getAzureInputFileEtag() {
        return azureInputFileEtag;
    }

    public void setAzureInputFileEtag(String azureInputFileEtag) {
        this.azureInputFileEtag = azureInputFileEtag;
    }

    public String getAzureOutputFileEtag() {
        return azureOutputFileEtag;
    }

    public void setAzureOutputFileEtag(String azureOutputFileEtag) {
        this.azureOutputFileEtag = azureOutputFileEtag;
    }

    public String getAzureOutputFileUUID() {
        return azureOutputFileUUID;
    }

    public void setAzureOutputFileUUID(String azureOutputFileUUID) {
        this.azureOutputFileUUID = azureOutputFileUUID;
    }

    public String getAzureInputFileUUID() {
        return azureInputFileUUID;
    }

    public void setAzureInputFileUUID(String azureInputFileUUID) {
        this.azureInputFileUUID = azureInputFileUUID;
    }
}