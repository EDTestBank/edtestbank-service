package com.ossez.edtestbank.common.dao.repositories;

import com.ossez.edtestbank.common.models.orm.REListing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface REListingRepository extends CrudRepository<REListing, Long> {

    REListing getREListingById(Long id);
}
