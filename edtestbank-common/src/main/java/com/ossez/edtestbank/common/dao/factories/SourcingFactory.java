package com.ossez.edtestbank.common.dao.factories;


import com.google.common.collect.Lists;
import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.models.orm.Sourcing;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * SourcingFactory to process sourcing data
 *
 * @author YuCheng Hu
 */
public class SourcingFactory extends Factory {
    private final static Logger logger = LoggerFactory.getLogger(SourcingFactory.class);

    /**
     *
     * @param CommonManufacturerIdList
     * @return
     */
    public static List<Sourcing> get(List<Long> CommonManufacturerIdList) {
        logger.debug("Search Database View of Matching to make sure the view has data in");

        List<Sourcing> results = Lists.newArrayList();
        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(Sourcing.class);
            criteria.add(Restrictions.in("commonManufacturerId", CommonManufacturerIdList));

            results = criteria.list();
        } catch (Exception e) {
            logger.error("Get Matching data error.", e);
        } finally {
            Factory.commitTransaction();
        }

        return results;
    }


    /**
     * Save List for Object
     *
     * @param sourcingList
     * @return
     */
    public static int save(List<Sourcing> sourcingList) {
        logger.debug("Save Sourcing Object List");
        try {
            sourcingList.forEach(sourcing -> {
                save(sourcing);
            });
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;

    }

}
