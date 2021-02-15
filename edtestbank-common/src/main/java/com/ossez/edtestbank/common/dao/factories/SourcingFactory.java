package com.ossez.edtestbank.common.dao.factories;


import com.google.common.collect.Lists;
import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.model.entity.Question;
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
    public static List<Question> get(List<Long> CommonManufacturerIdList) {
        logger.debug("Search Database View of Matching to make sure the view has data in");

        List<Question> results = Lists.newArrayList();
        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(Question.class);
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
     * @param questionList
     * @return
     */
    public static int save(List<Question> questionList) {
        logger.debug("Save Sourcing Object List");
        try {
            questionList.forEach(question -> {
                save(question);
            });
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;

    }

}
