package com.ossez.edtestbank.common.dao.factories;

import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.models.orm.Question;
import com.ossez.edtestbank.common.models.orm.QuestionIndex;
import com.ossez.edtestbank.common.models.orm.QuestionTitle;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Question Factory
 *
 * @author YuCheng Hu
 */
public class QuestionFactory {
    private final static Logger logger = LoggerFactory.getLogger(QuestionFactory.class);

    /**
     * Search QuestionIndex by id
     *
     * @param id
     * @return
     */
    public static QuestionIndex getQuestionIndex(Long id) {
        Object obj = ObjectUtils.NULL;

        try {
            Factory.beginTransaction();
            obj = Factory.getSession().get(QuestionIndex.class, id);

            Factory.commitTransaction();
        } catch (Exception e) {
            logger.error("Get QuestionIndex data error.", e);
            Factory.rollbackTransaction();
        }

        return (QuestionIndex) obj;
    }

    /**
     * Search QuestionIndex by id
     *
     * @param id
     * @return
     */
    public static Question getQuestion(Long id) {
        Object obj = ObjectUtils.NULL;

        try {
            Factory.beginTransaction();
            obj = Factory.getSession().get(Question.class, id);

            Factory.commitTransaction();
        } catch (Exception e) {
            logger.error("Get QuestionIndex data error.", e);
            Factory.rollbackTransaction();
        }

        return (Question) obj;
    }

    public static Question getQuestion(String uuid) {
        Object result = ObjectUtils.NULL;

        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(Question.class);
            criteria.add(Restrictions.eq("uuid", uuid)).addOrder(Order.asc("id"));

            //ORDER
            criteria.addOrder(Order.asc("id"));
            criteria.setMaxResults(1);

            result = criteria.uniqueResult();

            Factory.commitTransaction();
        } catch (Exception e) {
            logger.error("Get QuestionIndex data error.", e);
            Factory.rollbackTransaction();
        }

        return (Question) result;
    }


    /**
     * Get Question Index by UUID
     *
     * @param uuid
     * @return
     */
    public static QuestionIndex getQuestionIndex(String uuid) {
        Object result = ObjectUtils.NULL;

        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(QuestionIndex.class);
            criteria.add(Restrictions.eq("uuid", uuid)).addOrder(Order.asc("id"));

            //ORDER
            criteria.addOrder(Order.asc("id"));
            criteria.setMaxResults(1);

            result = criteria.uniqueResult();

            Factory.commitTransaction();
        } catch (Exception e) {
            logger.error("Get QuestionIndex data error.", e);
            Factory.rollbackTransaction();
        }
        return (QuestionIndex) result;
    }

    /**
     * QTitle
     *
     * @param id
     * @return
     */
    public static QuestionTitle getQTitleById(Long id) {
        Object obj = Factory.getSession().get(QuestionTitle.class, id);

        if (ObjectUtils.allNotNull(obj))
            return (QuestionTitle) obj;
        else
            return null;
    }

}
