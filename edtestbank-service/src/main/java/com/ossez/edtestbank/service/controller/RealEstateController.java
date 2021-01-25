package com.ossez.edtestbank.service.controller;


import com.ossez.edtestbank.common.models.orm.QuestionIndex;
import com.ossez.edtestbank.common.models.orm.REListing;
import com.ossez.edtestbank.common.service.ListingService;
import com.ossez.edtestbank.common.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Search Endpoint
 *
 * @author YuCheng Hu
 */
@RestController
@RequestMapping(value = "/re")
public class RealEstateController {

    ListingService listingService = new ListingService();

    /**
     * Search Question Index
     *
     * @return
     */
    @GetMapping("/sold")
    public ResponseEntity<?> searchUser() {
        REListing reListing=  listingService.getREListingById();

        return new ResponseEntity<REListing>(reListing, HttpStatus.OK);
    }

    @GetMapping("/tax")
    public ResponseEntity<?> searchTax() {
        REListing reListing=  listingService.getREListingById();

        return new ResponseEntity<REListing>(reListing, HttpStatus.OK);
    }

}