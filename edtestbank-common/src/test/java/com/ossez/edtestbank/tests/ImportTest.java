package com.ossez.edtestbank.tests;

import com.google.api.client.util.Lists;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.dao.factories.QuestionFactory;
import com.ossez.edtestbank.common.models.CacheTestBankImport;
import com.ossez.edtestbank.common.models.QDescription;
import com.ossez.edtestbank.common.models.QIndex;
import com.ossez.edtestbank.common.models.QTitle;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Data Import Testing
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ImportTest {
    private static Logger logger = LoggerFactory.getLogger(ImportTest.class);

    @BeforeAll
    protected void setUp() throws Exception {
        Factory.beginTransaction();
    }

    @AfterAll
    protected void tearDown() throws Exception {
        Factory.rollbackTransaction();
    }

    /**
     * testImportCaseStudyAnalysis
     */
    @Test
    public void testImportCaseStudyAnalysis() {



        StringBuffer in = new StringBuffer();
        try {
            Collection<File> files = FileUtils.listFiles(new File("C:\\WorkDir\\Ossez-Com\\EDTestBank\\data"), new String[]{"csv"}, true);

            for(File file:files){
                if (StringUtils.endsWith(file.getName(),"CaseStudyAnalysis.csv")) {
                    in.append(FileUtils.readFileToString(file));
                }

            }


//            logger.debug(in);


            CSVReader csvReader = new CSVReader(new StringReader(in.toString()));
            List<String[]> dataList = Lists.newArrayList();
            dataList = csvReader.readAll();


            String sourceDescriptionId = null;
            Long cacheTestBankImportId = null;


            for (int i = 1; i < dataList.size(); i++) {


                String[] strArray = dataList.get(i);
                String descriptionId = StringUtils.trimToNull(strArray[0]);
                String descriptionParentId = StringUtils.trimToNull(strArray[1]);

                CacheTestBankImport cacheTestBankImport = new CacheTestBankImport();

                if (StringUtils.isNotEmpty(descriptionId)) {
                    sourceDescriptionId = descriptionId;
                    cacheTestBankImport.setDescription(StringUtils.trimToEmpty(strArray[1]));
                    cacheTestBankImport.setCsvFileName("BAT");

//                    cacheTestBankImportId = QuestionFactory.saveCacheTestBankImport(cacheTestBankImport);

                    logger.debug("Saved Index id - {}", cacheTestBankImportId);
                } else if (!StringUtils.isNoneBlank(descriptionId) && StringUtils.equalsIgnoreCase(sourceDescriptionId, descriptionParentId)) {

                    cacheTestBankImport.setParentId(cacheTestBankImportId);

                    cacheTestBankImport.setTitle(StringUtils.trimToEmpty(strArray[2]));
                    cacheTestBankImport.setQuestionA(StringUtils.trimToEmpty(strArray[3]));
                    cacheTestBankImport.setQuestionB(StringUtils.trimToEmpty(strArray[4]));
                    cacheTestBankImport.setQuestionC(StringUtils.trimToEmpty(strArray[5]));
                    cacheTestBankImport.setQuestionD(StringUtils.trimToEmpty(strArray[6]));
                    cacheTestBankImport.setQuestionE(StringUtils.trimToEmpty(strArray[7]));
                    cacheTestBankImport.setQuestionF(StringUtils.trimToEmpty(strArray[8]));
                    cacheTestBankImport.setAnswer(StringUtils.trimToEmpty(strArray[9]));
                    cacheTestBankImport.setAnswerNote(StringUtils.trimToEmpty(strArray[10]));
                    cacheTestBankImport.setCsvFileName("BAT");


//                    QuestionFactory.saveCacheTestBankImport(cacheTestBankImport);
                    logger.debug("Saved Index id - {}", cacheTestBankImportId);
                }


//                if (i > 5)
//
//                    break;
            }


        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }


    }

    /**
     *
     *
     * @throws ValidationException
     */
    @Test
    public void testImportMultipleChoice()  {
//       Reader reader= Files.newBufferedReader(Paths.get(
//               ClassLoader.getSystemResource("csv/twoColumn.csv").toURI()));

        String in = null;
        String csvFileName = "建设工程安全生产技术试题-MC.csv";
        try {
            in = FileUtils.readFileToString(new File(("C:\\WorkDir\\"+ csvFileName)));

//            logger.debug(in);


            CSVReader csvReader = new CSVReader(new StringReader(in));
            List<String[]> dataList = Lists.newArrayList();
            dataList = csvReader.readAll();


            String sourceDescriptionId = null;
            Long cacheTestBankImportId = null;


            for (int i = 1; i < dataList.size(); i++) {


                String[] strArray = dataList.get(i);


                CacheTestBankImport cacheTestBankImport = new CacheTestBankImport();


                cacheTestBankImport.setTitle(StringUtils.trimToEmpty(strArray[0]));
                cacheTestBankImport.setQuestionA(StringUtils.trimToEmpty(strArray[1]));
                cacheTestBankImport.setQuestionB(StringUtils.trimToEmpty(strArray[2]));
                cacheTestBankImport.setQuestionC(StringUtils.trimToEmpty(strArray[3]));
                cacheTestBankImport.setQuestionD(StringUtils.trimToEmpty(strArray[4]));
                cacheTestBankImport.setQuestionE(StringUtils.trimToEmpty(strArray[5]));
                cacheTestBankImport.setQuestionF(StringUtils.trimToEmpty(strArray[6]));
                cacheTestBankImport.setAnswer(StringUtils.trimToEmpty(strArray[7]));
                cacheTestBankImport.setAnswerNote(StringUtils.trimToEmpty(strArray[8]));
                cacheTestBankImport.setCsvFileName(csvFileName);

//                QuestionFactory.saveCacheTestBankImport(cacheTestBankImport);
                logger.debug("Saved Index id - {}", cacheTestBankImportId);


//                if (i > 5)
//
//                    break;
            }


        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }


    }

    /**
     * Tests search functionality for the customer object.
     */
    @Test
    public void testGetQTitle()  {
        QTitle qTitle = QuestionFactory.getQTitleById(1L);
        logger.debug("Question Title Content - {}", qTitle.getQuestionTitle());
    }


}


