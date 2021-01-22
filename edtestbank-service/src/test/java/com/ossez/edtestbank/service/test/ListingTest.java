package com.ossez.edtestbank.service.test;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.dao.factories.PostFactory;
import com.ossez.edtestbank.common.models.orm.BBSOssezForumAttach;
import com.ossez.edtestbank.common.models.orm.BBSOssezForumPost;
import com.ossez.edtestbank.common.models.orm.REListing;
import com.ossez.edtestbank.common.models.request.TopicRequest;
import com.ossez.edtestbank.common.service.ListingService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Real Estate Listing Data Testing
 *
 * @author YuCheng Hu
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
//@SpringBootTest
public class ListingTest {
    private static Logger logger = LoggerFactory.getLogger(ListingTest.class);

    @Autowired
    ListingService listingService;

    @BeforeAll
    protected void setUp() throws Exception {
        Factory.beginTransaction();
    }

    @AfterAll
    protected void tearDown() throws Exception {
        Factory.rollbackTransaction();
    }

    @Test
    public void testGetREListing() throws IOException, InterruptedException {

        logger.debug("{}", listingService.getREListingById());

    }

    /**
     * Tests search functionality for the customer object.
     */
    @Test
    public void testListingImport() throws IOException, InterruptedException {
        logger.debug("TEST for CommonManufacturer data import from csv file");
        StringBuffer in = new StringBuffer();

        try {
            in.append(FileUtils.readFileToString(FileUtils.getFile(new File("C:\\Users\\yhu\\Downloads\\Spreadsheet1.csv"))));


            CSVReader csvReader = new CSVReader(new StringReader(in.toString()));
            List<String[]> dataList = Lists.newArrayList();
            dataList = csvReader.readAll();

            logger.info("Data Count: {}", dataList.size());

            for (int i = 1; i < dataList.size(); i++) {

                String[] strArray = dataList.get(i);

//                // SET OBJECT
                REListing reListing = new REListing();
                reListing.setMlsId(NumberUtils.toLong(StringUtils.trim(strArray[3])));
                reListing.setMlsState(StringUtils.trim("NH"));
                reListing.setPropertyAddress(StringUtils.trim(strArray[6]));
                reListing.setPropertyTown(StringUtils.trim(strArray[7]));
                reListing.setPropertyState(StringUtils.trim(strArray[8]));
                reListing.setPropertyCunty(StringUtils.trim(strArray[9]));
                reListing.setDom(NumberUtils.toInt(StringUtils.trim(strArray[10])));
                reListing.setPriceListing(NumberUtils.createBigDecimal(StringUtils.remove(StringUtils.remove(StringUtils.trim(strArray[11]), ","), "$")));
                reListing.setPriceClosed(NumberUtils.createBigDecimal(StringUtils.remove(StringUtils.remove(StringUtils.trim(strArray[13]), ","), "$")));


                logger.info("Price Closed: {}", reListing.getPriceListing());

                listingService.save(reListing);
                break;

            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDateTime() throws IOException {
        DateTime dateTime = new DateTime(1256834117 * 1000L);
        System.out.println(dateTime.toString());

    }

    private void processPost(Long tid) throws IOException {
        BBSOssezForumPost bbsOssezForumPost = PostFactory.getBBSOssezForumPostTid(tid);
        if (bbsOssezForumPost == null)
            return;

        logger.debug("Questions Content - {}", bbsOssezForumPost.getSubject());

        String postCtx = bbsOssezForumPost.getMessage();
//        logger.debug(">>>>{}", postCtx);


        String pattern = "\\[attach\\]((\\d)*?)\\[\\/attach\\]";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(postCtx);

        while (m.find()) {
            String attachId = StringUtils.substringBetween(m.group(0), "[attach]", "[/attach]");
            logger.debug("{}", attachId);
            BBSOssezForumAttach bbsOssezForumAttach = PostFactory.getBBSOssezForumAttach(NumberUtils.toLong(attachId));
            if (bbsOssezForumAttach != null) {
                String fullURL = "![](https://cdn.ossez.com/com-ossez-www/data/attachment/forum/" + bbsOssezForumAttach.getAttachment() + ")";
                postCtx = StringUtils.replace(postCtx, m.group(0), fullURL);
            }
        }

        logger.debug("{}", postCtx);


        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("https://www.ossez.com/posts.json");
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        httpPost.setHeader("Api-Key", "8d789c529c4c22bf1dac3de7dbe7b29af10f2429aeb9a1914eff6da70c2265a9");
        httpPost.setHeader("Api-Username", "honeymoose");

        TopicRequest topicRequest = new TopicRequest();
        topicRequest.setTitle(bbsOssezForumPost.getSubject());
        topicRequest.setRaw(postCtx);
        topicRequest.setCreated_at(new DateTime(bbsOssezForumPost.getDateline() * 1000L).toString());
        topicRequest.setCategory(30);

        StringEntity postingString = new StringEntity(new Gson().toJson(topicRequest), StandardCharsets.UTF_8);

        httpPost.setEntity(postingString);


        CloseableHttpResponse response = client.execute(httpPost);

        logger.info("{}", EntityUtils.toString(response.getEntity()), StandardCharsets.UTF_8);
        client.close();
    }

}
