package com.ossez.edtestbank.common.utilities;

import com.google.common.collect.Lists;
import com.ossez.edtestbank.common.dao.factories.MatchingFactory;
import com.ossez.edtestbank.common.models.ProcessedFileEntry;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.tika.Tika;
import org.apache.tika.mime.MimeTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * CSVFileUtils for csv data process
 *
 * @author YuCheng Hu
 */
public class CSVFileUtils {
    private static final Logger logger = LoggerFactory.getLogger(CSVFileUtils.class);

    /**
     * Get vendor List from CSV file
     *
     * @param inputFile
     * @return
     */
    public static List<String> getCSVInputFileRowList(File inputFile) {
        List<String> dataList = Lists.newArrayList();
        StringBuffer in = new StringBuffer();


        try {
            in.append(FileUtils.readFileToString(inputFile));
            CSVReader csvReader = new CSVReader(new StringReader(in.toString()));

            //CHECK DATA IF LINE IS BLANK
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                if (ArrayUtils.isNotEmpty(nextLine) && !StringUtils.equalsIgnoreCase(StringUtils.trimToEmpty(ArrayUtils.toString(nextLine)), "{}"))
                    dataList.add(nextLine[0]);
            }

            logger.debug("The Size of cvs file count: {}", dataList.size());
        } catch (IOException | CsvException ex) {
            logger.error("CSV File process error.", ex);
        }

        // CLEAN
        CollectionUtils.filter(dataList, PredicateUtils.notNullPredicate());

        return dataList;
    }


    /**
     *
     * @param inputFile
     * @return
     */
    public static List<String> getExcelInputFileRowList(File inputFile) {
        List<String> dataList = Lists.newArrayList();

        try {
            FileInputStream inputStream = FileUtils.openInputStream(inputFile);

            Workbook wb = WorkbookFactory.create(inputStream);
            Sheet sheet = wb.getSheetAt(0);

            Iterator<Row> iterator = sheet.rowIterator();

            // LOOP Get Cell
            while (iterator.hasNext()) {
                Row row = iterator.next();
                Cell cell = row.getCell(0);
                cell.getStringCellValue();
                dataList.add(cell.getStringCellValue());
                logger.debug("Cell Data - [{}]", cell.getStringCellValue());
            }

            logger.debug("The Size of XLSX file count: {}", dataList.size());
        } catch (IOException ex) {
            logger.error("XLSX File process error.", ex);
        }

        // CLEAN
        CollectionUtils.filter(dataList, PredicateUtils.notNullPredicate());

        return dataList;
    }


    /**
     * @param outputCSVFile
     * @param matchingColsList
     * @return
     */
    public static File writeOutputCSVFile(File outputCSVFile, List<ProcessedFileEntry> matchingColsList) {
        // CONVERT TO CSV DATA
        List<String[]> csvDataList = Lists.newArrayList();
        for (ProcessedFileEntry processedFileEntry : matchingColsList) {
            String[] dataArray = {processedFileEntry.getVendorName(),
                    String.valueOf(processedFileEntry.getRowRef()),
                    processedFileEntry.getMatchFound(),
                    processedFileEntry.getExactMatch(),
                    processedFileEntry.getCommonManufacturerName(),
                    processedFileEntry.getMatchType(),
                    processedFileEntry.getGlobalCanSourceDirect(),
                    processedFileEntry.getGlobalDistributionSourcing()
            };
            csvDataList.add(dataArray);
        }

        try {

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(outputCSVFile), StandardCharsets.UTF_8.name()));

            List<String> headerList = Lists.newArrayList();
            headerList.add("Vendor");
            headerList.add("Row Ref");
            headerList.add("Match Found");
            headerList.add("Exact Match");
            headerList.add("Common Manufacturer");
            headerList.add("Match Type");
            headerList.add("Can Source Direct (Global)");
            headerList.add("Distribution Sourcing (Global)");
//            headerList.add("Can Source Direct (Country)");
//            headerList.add("Distribution Sourcing (Country)");

            // adding header to csv
            writer.writeNext(headerList.toArray(new String[headerList.size()]));
            writer.writeAll(csvDataList);

            // closing writer connection
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return outputCSVFile;
    }

    /**
     * Access Database by using vendor List
     *
     * @param vendorList
     * @return
     */
    public static HashMap<String, BigDecimal> getMatchingMap(List<String> vendorList) {
        return MatchingFactory.getMatchingMap(vendorList);
    }

    /**
     * @param file
     * @return
     */
    public static String getFileMediaType(File file) {
        String fileMediaType = MimeTypes.PLAIN_TEXT;

        try {
            Tika tika = new Tika();
            fileMediaType = tika.detect(file);

        } catch (IOException ex) {
            logger.error("Get File Media Type error.", ex);
        }

        return fileMediaType;
    }

}
