package com.ossez.edtestbank.common.service.intf;

import com.ossez.edtestbank.common.model.entity.REListing;
import com.ossez.edtestbank.common.model.entity.Town;

import java.util.List;

/**
 * Matching Service
 *
 * @author YuCheng Hu
 */
public interface MetadataService {
    REListing getREListingById();

    void save(Town town);
    
    void save(List<Town> towns);
}
