package com.ossez.edtestbank.common.dao.factories;


import com.google.common.collect.Lists;
import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.model.entity.TestBank;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * SourcingFactory to process sourcing data
 *
 * @author YuCheng Hu
 */
public class TestBankFactory extends Factory {
    private final static Logger logger = LoggerFactory.getLogger(TestBankFactory.class);

    public static TestBank getTestBank(Long id) {
        Object obj = null;

        try {
            Factory.beginTransaction();
            obj = Factory.getSession().get(TestBank.class, id);

            Factory.commitTransaction();
        } catch (Exception e) {
            logger.error("Get Matching data error.", e);
            Factory.rollbackTransaction();
        }
        return (TestBank) obj;


    }

    /**
     * @return
     */
    public static List<TestBank> searchTestBank() {
        List<TestBank> results = Lists.newArrayList();


        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(TestBank.class);
//            criteria.add(Restrictions.eq("uuid", uuid)).addOrder(Order.asc("id"));

            //ORDER
            criteria.addOrder(Order.desc("dateModified"));
            criteria.setMaxResults(50);

            results = criteria.list();

            Factory.commitTransaction();
        } catch (Exception e) {
            logger.error("Get QuestionIndex data error.", e);
            Factory.rollbackTransaction();
        }
        return results;

    }

}
