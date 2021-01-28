package com.ossez.edtestbank.common.service;

import com.ossez.edtestbank.common.models.orm.REListing;

/**
 * Matching Service
 *
 * @author YuCheng Hu
 */
public interface ListingService {
    REListing getREListingById();

    void save(REListing reListing);
}
