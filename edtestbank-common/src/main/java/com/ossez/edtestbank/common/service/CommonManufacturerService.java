package com.ossez.edtestbank.common.service;

import com.ossez.edtestbank.common.dao.factories.CommonManufacturerFactory;
import com.ossez.edtestbank.common.models.orm.Alias;
import com.ossez.edtestbank.common.models.orm.CommonManufacturer;
import com.ossez.edtestbank.common.models.orm.Sourcing;
import com.ossez.edtestbank.common.models.orm.Xref;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * CommonManufacturerService to Process data logic
 *
 * @author YuCheng Hu
 */
public class CommonManufacturerService {
    private static final Logger logger = LoggerFactory.getLogger(CommonManufacturerService.class);

    /**
     *
     */
    public static CommonManufacturer getCommonManufacturerByID(Long id) {
        return CommonManufacturerFactory.getCommonManufacturerById(id);
    }

    /**
     * Search Database to get  Alias
     *
     * @param id
     * @return
     */
    public static Set<Alias> getAliasByCommonManufacturerId(Long id) {
        CommonManufacturer commonManufacturer = CommonManufacturerFactory.getCommonManufacturerById(id);
        return ObjectUtils.isNotEmpty(CommonManufacturerFactory.getCommonManufacturerById(id)) ? commonManufacturer.getAliasesSet() : SetUtils.emptySet();
    }

    /**
     * Search Database to get Sourcing
     *
     * @param id
     * @return
     */
    public static Set<Sourcing> getSourcingByCommonManufacturerId(Long id) {
        CommonManufacturer commonManufacturer = CommonManufacturerFactory.getCommonManufacturerById(id);
        return ObjectUtils.isNotEmpty(CommonManufacturerFactory.getCommonManufacturerById(id)) ? commonManufacturer.getSourcingSet() : SetUtils.emptySet();
    }

    /**
     * Search Database to get Xref
     *
     * @param id
     * @return
     */
    public static Set<Xref> getXrefByCommonManufacturerId(Long id) {
        CommonManufacturer commonManufacturer = CommonManufacturerFactory.getCommonManufacturerById(id);
        return ObjectUtils.isNotEmpty(CommonManufacturerFactory.getCommonManufacturerById(id)) ? commonManufacturer.getXrefSet() : SetUtils.emptySet();
    }

}
