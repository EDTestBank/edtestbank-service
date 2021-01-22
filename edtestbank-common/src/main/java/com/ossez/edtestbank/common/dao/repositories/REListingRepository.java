package com.ossez.edtestbank.common.dao.repositories;

import com.ossez.edtestbank.common.models.orm.REListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface REListingRepository extends JpaRepository<REListing, Long> {

    REListing getREListingById(Long id);
}
