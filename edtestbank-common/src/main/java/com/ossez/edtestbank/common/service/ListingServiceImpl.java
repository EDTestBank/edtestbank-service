package com.ossez.edtestbank.common.service;

import com.google.common.collect.Lists;
import com.ossez.edtestbank.common.SCOConstants;
import com.ossez.edtestbank.common.dao.factories.ListingFactory;
import com.ossez.edtestbank.common.dao.factories.MatchingFactory;
import com.ossez.edtestbank.common.dao.factories.PostFactory;
import com.ossez.edtestbank.common.dao.factories.SourcingFactory;
import com.ossez.edtestbank.common.dao.repositories.REListingRepository;
import com.ossez.edtestbank.common.models.ProcessedFileEntry;
import com.ossez.edtestbank.common.models.orm.BBSOssezForumPost;
import com.ossez.edtestbank.common.models.orm.Question;
import com.ossez.edtestbank.common.models.orm.REListing;
import com.ossez.edtestbank.common.models.orm.TestBankSubject;
import com.ossez.edtestbank.common.utilities.CSVFileUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tika.mime.MimeTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

/**
 * Matching Service
 *
 * @author YuCheng Hu
 */
@Service
public class ListingServiceImpl implements ListingService{
    private static final Logger logger = LoggerFactory.getLogger(ListingServiceImpl.class);

    @Autowired
    REListingRepository reListingRepository;



    public REListing getREListingById() {
//        return ListingFactory.getREListing(10L);
                return reListingRepository.getREListingById(10L);
    }

    public void save(REListing reListing) {
        ListingFactory.save(reListing);
    }

    /**
     * Search Matching by Search String
     *
     * @param searchQ
     * @param isPartialMatch
     * @return
     */
    public static List<TestBankSubject> getMatchingByVendorName(String searchQ, Boolean isPartialMatch) {
        return MatchingFactory.getMatchingListByVendorName(searchQ, isPartialMatch);
    }

    /**
     *
     * @param token
     * @param clientName
     * @param file
     * @return
     */
    public static HashMap<BBSOssezForumPost, File> initInputFile(String token, String clientName, MultipartFile file) {
        HashMap<BBSOssezForumPost, File> fileHashMap = new HashMap<>();


        String fileSHA3 = StringUtils.EMPTY;
        String eTag = StringUtils.EMPTY;
        String customerFileName = StringUtils.trimToEmpty(clientName);

        BBSOssezForumPost bbsossezForumPost = new BBSOssezForumPost();

        // Set file customerName
        if (StringUtils.isEmpty(customerFileName))
            customerFileName = file.getOriginalFilename();


        try {
            fileSHA3 = DigestUtils.sha3_224Hex(file.getInputStream());
//            bbsossezForumPost.setFileSHA3(fileSHA3);
//
//
//            bbsossezForumPost.setCustomerFileName(customerFileName);
//            bbsossezForumPost.setInputFileName(file.getOriginalFilename());
//            bbsossezForumPost.setFileCountRow(0);
//            bbsossezForumPost.setFileCountAliasMatch(0);
//            bbsossezForumPost.setFileCountDirectMatch(0);
//            bbsossezForumPost.setFileCountNoMatch(0);
//
//
//
//            // SEND FILE TO AZURE STORAGE
//
//            bbsossezForumPost.setAzureInputFileEtag(eTag);
//            logger.debug("eTag from Azure - [{}]", eTag);

            // UPDATE DB
            PostFactory.save(bbsossezForumPost);
        } catch (Exception ex) {
            logger.error("Init input file error.", ex);
            return null;
        }



        return fileHashMap;
    }


    /**
     * Process Input File
     * @param bbsossezForumPost
     * @param inputFile
     * @return
     */
    public static BBSOssezForumPost processInputFile(BBSOssezForumPost bbsossezForumPost, File inputFile) {

        List<String> vendorList = Lists.newArrayList();


        try {
            /**
             * PROCESS FILE AND NEED TO UPDATE DATABASE + AZURE
             */

            // READ CSV / TXT / XLSX / XLS FILE
            String fileMediaType = CSVFileUtils.getFileMediaType(inputFile);

            if (StringUtils.equalsIgnoreCase(fileMediaType, MimeTypes.PLAIN_TEXT) || StringUtils.equalsIgnoreCase(fileMediaType, "text/csv"))
                vendorList = CSVFileUtils.getCSVInputFileRowList(inputFile);
            else
                vendorList = CSVFileUtils.getExcelInputFileRowList(inputFile);

            // GET MATCHING LIST - UPDATE DATABASE VALUE
            HashMap<String, BigDecimal> matchingMap = ListingServiceImpl.getMatchingMap(vendorList);
            matchingMap.put(SCOConstants.COUNT_ROW, BigDecimal.valueOf(vendorList.size()));
//            bbsossezForumPost.setFileCountRow(matchingMap.get(SCOConstants.COUNT_ROW).intValue());
//            bbsossezForumPost.setFileCountAliasMatch(matchingMap.get(SCOConstants.COUNT_MATCH_MULTI).intValue());
//            bbsossezForumPost.setFileCountDirectMatch(matchingMap.get(SCOConstants.COUNT_MATCH_SINGLE).intValue());
//            bbsossezForumPost.setFileCountNoMatch(matchingMap.get(SCOConstants.COUNT_MATCH_NO).intValue());

            // GET OUTPUT FILE
            try {
                List<ProcessedFileEntry> matchingColsList = getMatchingFileCols(vendorList);

                // SET OUTPUT file UUID and send this file to azure by this uuid as storage file name
                String outPutFileName = UUID.randomUUID().toString() + ".csv";
//                bbsossezForumPost.setAzureOutputFileUUID(outPutFileName);


            } catch (Exception e) {
                e.printStackTrace();
            }

            // UPDATE DB FOR AFTER PROCESS AND CLEAN TMP FOLDER
            PostFactory.save(bbsossezForumPost);


        } catch (Exception e) {
            logger.error("File Upload API Error", e);
            throw new RuntimeException("Could not store the file. Error:" + e.getMessage());
        }

        return bbsossezForumPost;
    }

    /**
     * Get matching file count for cols
     *
     * @param vendorList
     * @return
     */
    public static List<ProcessedFileEntry> getMatchingFileCols(List<String> vendorList) {
        List<ProcessedFileEntry> matchingColsList = Lists.newArrayList();
        HashSet<Long> commonManufacturerIdSet = new HashSet<>();

        // LOOP TO SEARCH DB
        for (int i = 0; i < vendorList.size(); i++) {
            String vendorName = vendorList.get(i);

            // SEARCH DB
            List<TestBankSubject> dbSearchedList = MatchingFactory.getMatchingListByVendorName(vendorName);

            if (CollectionUtils.isNotEmpty(dbSearchedList) && CollectionUtils.size(dbSearchedList) > 0) {

                // For return of database search list set value to OBJ
                for (TestBankSubject testBankSubject : dbSearchedList) {
//                    commonManufacturerIdSet.add(NumberUtils.toLong(testBankSubject.getCommonManufacturerId()));

                    ProcessedFileEntry processedFileEntry = new ProcessedFileEntry();
                    processedFileEntry.setVendorName(vendorName);
                    processedFileEntry.setRowRef(i + 1);
                    processedFileEntry.setMatchFound(SCOConstants.VALUE_YES);

                    // SET EXACT MATCH
                    if (dbSearchedList.size() > 1) {
                        processedFileEntry.setExactMatch(SCOConstants.VALUE_NO);
                    } else {
                        processedFileEntry.setExactMatch(SCOConstants.VALUE_YES);
                    }
//                    processedFileEntry.setCommonManufacturerName(testBankSubject.getCommonManufacturerName());
//                    processedFileEntry.setCommonManufacturerId(NumberUtils.toLong(testBankSubject.getCommonManufacturerId()));
//                    processedFileEntry.setMatchType(testBankSubject.getMatchType());

                    // ADD TO LIST
                    matchingColsList.add(processedFileEntry);
                }
            } else {
                // NOT FOUND IN DB
                ProcessedFileEntry processedFileEntry = new ProcessedFileEntry();
                processedFileEntry.setVendorName(vendorName);
                processedFileEntry.setRowRef(i + 1);
                processedFileEntry.setMatchFound(SCOConstants.VALUE_NO);

                matchingColsList.add(processedFileEntry);
            }
        }

        HashMap<Long, String> valueMap = getSourcingValues(new ArrayList<Long>(commonManufacturerIdSet));
        matchingColsList.parallelStream().forEach(processedFileEntry -> {
            var vMapValue = valueMap.get(processedFileEntry.getCommonManufacturerId());
            if (vMapValue != null) {
                String[] valuesOfGlobalCanSourceAndDistribution = StringUtils.split(vMapValue);

                try {
                    if (valuesOfGlobalCanSourceAndDistribution != null) {
                        if (valuesOfGlobalCanSourceAndDistribution.length > 0) {
                            var globalSourceDirect = valuesOfGlobalCanSourceAndDistribution[0];
                            if (globalSourceDirect != null) {
                                processedFileEntry.setGlobalCanSourceDirect(globalSourceDirect);
                            }
                        }

                        if (valuesOfGlobalCanSourceAndDistribution.length > 1) {
                            var globalDistributionSourcing = valuesOfGlobalCanSourceAndDistribution[1];
                            if (globalDistributionSourcing != null) {
                                processedFileEntry.setGlobalDistributionSourcing(globalDistributionSourcing);
                            }
                        }
                    }
                } catch (Error error) {
                    logger.debug("Processed file entry", processedFileEntry);
                    throw error;
                }
            }
        });

        logger.debug("Size of matching List - [{}]", matchingColsList.size());

        return matchingColsList;
    }

    /**
     * Search Database to get MatchMap by vendorList
     *
     * @param vendorList
     * @return
     */
    public static HashMap<String, BigDecimal> getMatchingMap(List<String> vendorList) {
        return MatchingFactory.getMatchingMap(vendorList);
    }

    /**
     * Function to get SourceValues return map by key is commonManufacturerId, value is the vale string split by space
     *
     * @param commonManufacturerIdList
     * @return
     */
    public static HashMap<Long, String> getSourcingValues(List<Long> commonManufacturerIdList) {
        HashMap<Long, String> valueMap = new HashMap<Long, String>();

        HashMap sourcingMap = getSourcingMap(SourcingFactory.get(commonManufacturerIdList));

        commonManufacturerIdList.parallelStream().forEach(commonManufacturerId -> {
            List<Question> questionList = (List<Question>) sourcingMap.get(commonManufacturerId);

            if (CollectionUtils.isNotEmpty(questionList)) {
                List<String> canSourceDirectValueList = Lists.newArrayList();
                List<String> distributionSourcingValueList = Lists.newArrayList();

                questionList.forEach(question -> {
//                    canSourceDirectValueList.add(question.getCanSourceDirect());
//                    distributionSourcingValueList.add(question.getDistributionSourcing());
                });

                valueMap.put(commonManufacturerId, getMaxValue(canSourceDirectValueList) + StringUtils.SPACE + getMaxValue(distributionSourcingValueList));
            }

        });

        return valueMap;
    }

    /**
     * Get sourcing map, the key of this map is commonManufacturerId
     *
     * @param questionList
     * @return
     */
    private static HashMap<Long, List> getSourcingMap(List<Question> questionList) {
        HashMap<Long, List> sourcingMap = new HashMap<Long, List>();

        questionList.parallelStream().forEach(question -> {
//            Long commonManufacturerId = question.getCommonManufacturerId();
//            if (sourcingMap.containsKey(commonManufacturerId)) {
//                sourcingMap.get(commonManufacturerId).add(question);
//            } else {
//                sourcingMap.put(commonManufacturerId, Arrays.asList(new Question[]{question}));
//            }
        });
        return sourcingMap;
    }

    /**
     * Get value from value list
     *
     * @param valueList
     * @return
     */
    private static String getMaxValue(List<String> valueList) {
        HashSet<Integer> valueSet = new HashSet<Integer>();
        String strValue = StringUtils.EMPTY;

        // Read value to Integer
        valueList.parallelStream().forEach((value -> {
            value = StringUtils.substring(StringUtils.upperCase(StringUtils.trimToEmpty(value)), 0, 1);

            switch (value) {
                case "A":
                    valueSet.add(1);
                    break;
                case "B":
                    valueSet.add(2);
                    break;
                case "C":
                    valueSet.add(3);
                    break;
                case "D":
                    valueSet.add(4);
                    break;
                case "E":
                    valueSet.add(5);
                    break;
            }
        }));

        // Find value in HashSet
        int getMinValue = Collections.min(valueSet);

        // Get value to return
        switch (getMinValue) {
            case 1:
                strValue = "A";
                break;
            case 2:
                strValue = "B";
                break;
            case 3:
                strValue = "C";
                break;
            case 4:
                strValue = "D";
                break;
            case 5:
                strValue = "E";
                break;
        }
        return strValue;
    }
}
