package com.ossez.edtestbank.common.dao.factories;

import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.models.orm.MyScoFile;
import com.ossez.edtestbank.common.models.orm.QuestionIndex;
import com.ossez.edtestbank.common.models.orm.QTitle;
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
    public static QTitle getQTitleById(Long id) {
        Object obj = Factory.getSession().get(QTitle.class, id);

        if (ObjectUtils.allNotNull(obj))
            return (QTitle) obj;
        else
            return null;
    }

}
