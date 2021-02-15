package com.ossez.edtestbank.common.service.intf;

import com.ossez.edtestbank.common.model.entity.REListing;

/**
 * Matching Service
 *
 * @author YuCheng Hu
 */
public interface ListingService {
    REListing getREListingById();

    void save(REListing reListing);


}
