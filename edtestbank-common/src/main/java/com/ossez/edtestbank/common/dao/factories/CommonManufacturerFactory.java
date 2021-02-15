package com.ossez.edtestbank.common.dao.factories;


import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.model.entity.CommonManufacturer;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonManufacturerFactory {
    private final static Logger logger = LoggerFactory.getLogger(CommonManufacturerFactory.class);

    /**
     * Search ReportManufacturer by ID
     *
     * @param id
     * @return object created
     */
    public static CommonManufacturer getCommonManufacturerById(Long id) {
        logger.debug("Search Database to find CommonManufacturer data by ID");
        Object obj = ObjectUtils.NULL;

        try {
            Factory.beginTransaction();
            obj = Factory.getSession().get(CommonManufacturer.class, id);
        } catch (Exception e) {
            logger.error("Get CommonManufacturer data error.", e);
        } finally {
            Factory.commitTransaction();
        }

        return (CommonManufacturer) obj;
    }

    public static CommonManufacturer getCommonManufacturerByUUID(String uuid) {
        logger.debug("Search Database to find CommonManufacturer dataa by UUID");
        Object result = ObjectUtils.NULL;

        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(CommonManufacturer.class);
            criteria.add(Restrictions.eq("uuid", uuid));
            criteria.setMaxResults(1);

            result = criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Factory.commitTransaction();
        }

        // RETURN OBJ
        return (CommonManufacturer) result;
    }
}
