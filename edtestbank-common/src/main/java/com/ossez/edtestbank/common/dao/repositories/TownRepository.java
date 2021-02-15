package com.ossez.edtestbank.common.dao.repositories;

import com.ossez.edtestbank.common.model.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TownRepository
 */
@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

}
