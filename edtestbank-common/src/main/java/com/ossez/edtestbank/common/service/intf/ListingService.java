package com.ossez.edtestbank.common.service.intf;

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
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.math.BigDecimal;
import java.util.*;

/**
 * Matching Service
 *
 * @author YuCheng Hu
 */
public interface ListingService {
    REListing getREListingById();

    void save(REListing reListing);


}
