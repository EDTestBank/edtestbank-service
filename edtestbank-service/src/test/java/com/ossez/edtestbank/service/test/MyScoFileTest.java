package com.ossez.edtestbank.service.test;

import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.dao.factories.IndexFactory;
import com.ossez.edtestbank.common.dao.factories.MyScoFileFactory;
import com.ossez.edtestbank.common.models.orm.MyScoFile;
import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * File Function Testing
 *
 * @author YuCheng Hu
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyScoFileTest {
    private static final Logger logger = LoggerFactory.getLogger(MyScoFileTest.class);

    public Properties props = new Properties();

    @Value("${sco.azure.storage.account-name}")
    private String storageAccountName;

    @Value("${sco.azure.storage.account-key}")
    private String storageAccountKey;

    @Value("${sco.azure.storage.container-name}")
    private String storageContainerName;


    @BeforeAll
    public void setUp() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        props.load(loader.getResourceAsStream("log4j.properties"));

    }

    /**
     * Test data search function for H2 Database.
     * <p>
     * Data will init when Spring Boot start
     *
     * @throws Exception
     */
    @Test
    public void getMyScoFileTest() throws Exception {
        logger.debug("Test Search MyScoFile Table by ID 1");

        Factory.beginTransaction();
        IndexFactory.createIndex();
        MyScoFile myScoFile = MyScoFileFactory.getMyScoFile(1L);
        Factory.commitTransaction();

        assertNotNull(myScoFile.getInputFileName());
    }

}
