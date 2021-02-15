package com.ossez.edtestbank.common.dao.repositories;

import com.ossez.edtestbank.common.model.entity.PropertyTax;
import com.ossez.edtestbank.common.model.entity.REListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PropertyTax Repository
 */
@Repository
public interface PropertyTaxRepository extends JpaRepository<REListing, Long> {

    PropertyTax getPropertyTaxById(Long id);
}
