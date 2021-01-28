package com.ossez.edtestbank.service.controller;


import com.ossez.edtestbank.common.models.orm.QuestionIndex;
import com.ossez.edtestbank.common.models.orm.REListing;
import com.ossez.edtestbank.common.models.request.RealEstateRequest;
import com.ossez.edtestbank.common.service.ListingService;
import com.ossez.edtestbank.common.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

/**
 * Search Endpoint
 *
 * @author YuCheng Hu
 */
@RestController
@RequestMapping(value = "/re")
public class RealEstateController {

    private static final Logger logger = LoggerFactory.getLogger(RealEstateController.class);

    @Autowired
    ListingService listingService;

    /**
     * Search Question Index
     *
     * @return
     */
    @PostMapping("/sold")
    public ResponseEntity<?> searchUser(@RequestBody RealEstateRequest realEstateRequest) {

        logger.debug("realEstateRequest - {}", realEstateRequest.getPropertyTown());

        REListing reListing = listingService.getREListingById();

        return new ResponseEntity<REListing>(reListing, HttpStatus.OK);
    }

    @PostMapping("/soldm")
    public ResponseEntity<?> searchUsers(@RequestBody MultiValueMap<String, String> values) {

        logger.debug("K=V Map - {}", values);

        REListing reListing = listingService.getREListingById();

        return new ResponseEntity<REListing>(reListing, HttpStatus.OK);
    }

    /**
     * Search Tax by send request
     *
     * @param realEstateRequest
     * @return
     */
    @GetMapping("/tax")
    public ResponseEntity<?> searchTax(@RequestBody RealEstateRequest realEstateRequest) {
        REListing reListing = listingService.getREListingById();

        return new ResponseEntity<REListing>(reListing, HttpStatus.OK);
    }

}
