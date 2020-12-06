package com.ossez.edtestbank.service.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Non Statically allocates values based on Environment Variables for usage
 */
@Component
public class PropertiesConfiguration {

    public static String clientId;
    public static String tenetId;
    public static String clientSecret;
    public static String connectionString;
    public static String storageAccountNameAzureKey;
    public static String storageAccountKeyAzureKey;
    public static String storageEndpointAzureKey;
    public static String storageContainerMasterAzureKey;
    public static String storageContainerProcessedAzureKey;
    public static String storageUiBaseUrlAzureKey;
    public static String storageUiAppInsightKeyAzureKey;
    public static String storageKeyVaultSecretKey;
    public static Boolean roleAuthentication;
    public static String audienceId;

    @Value("${sco.azure.appconfiguration.client-id}")
    public void setClientId(String clientIdParam) {
        clientId = clientIdParam;
    }

    @Value("${sco.azure.appconfiguration.tenet-id}")
    public void setTenetId(String tenetIdParam) {
        tenetId = tenetIdParam;
    }

    @Value("${sco.azure.appconfiguration.client-secret}")
    public void setClientSecret(String clientSecretParam) {
        clientSecret = clientSecretParam;
    }

    @Value("${sco.azure.appconfiguration.connection-string}")
    public void setConnectionString(String connectionStringParam) {
        connectionString = connectionStringParam;
    }

    @Value("${sco.azure.appconfiguration.storage-account-name}")
    public void setStorageAccountNameAzureKey(String storageAccountNameParam) {
        storageAccountNameAzureKey = storageAccountNameParam;
    }

    @Value("${sco.azure.appconfiguration.storage-account-key}")
    public void setStorageAccountKeyAzureKey(String storageAccountKeyParam) {
        storageAccountKeyAzureKey = storageAccountKeyParam;
    }

    @Value("${sco.azure.appconfiguration.storage-endpoint}")
    public void setStorageEndpointAzureKey(String storageEndpointParam) {
        storageEndpointAzureKey = storageEndpointParam;
    }

    @Value("${sco.azure.appconfiguration.storage-container-master}")
    public void setStorageContainerMasterAzureKey(String storageContainerMasterParam) {
        storageContainerMasterAzureKey = storageContainerMasterParam;
    }

    @Value("${sco.azure.appconfiguration.storage-container-processed}")
    public void setStorageContainerProcessedAzureKey(String storageContainerProcessedParam) {
        storageContainerProcessedAzureKey = storageContainerProcessedParam;
    }

    @Value("${sco.azure.appconfiguration.storage-ui-baseurl}")
    public void setStorageUiBaseUrlAzureKey(String storageUiBaseUrlParam) {
        storageUiBaseUrlAzureKey = storageUiBaseUrlParam;
    }

    @Value("${sco.azure.appconfiguration.storage-ui-app-insight-key}")
    public void setStorageUiAppInsightKeyAzureKey(String storageUiAppInsightKeyParam) {
        storageUiAppInsightKeyAzureKey = storageUiAppInsightKeyParam;
    }


    @Value("${sco.azure.appconfiguration.storage-key-vault-key}")
    public void setStorageKeyVaultSecretKey(String storageKeyVaultSecretKeyParam) {
        storageKeyVaultSecretKey = storageKeyVaultSecretKeyParam;
    }

    @Value("${sco.azure.activedirectory.role-authentication}")
    public void setRoleAuthentication(Boolean roleAuthenticationParam) {
        roleAuthentication = roleAuthenticationParam;
    }
}
