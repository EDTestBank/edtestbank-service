package com.ossez.edtestbank.common.dao.factories;

import java.util.Date;

import com.ossez.edtestbank.common.Factory;
import com.ossez.edtestbank.common.mls.Provider;
import com.ossez.edtestbank.common.mls.RawOffice;
import com.ossez.edtestbank.common.models.QIndex;
import com.ossez.edtestbank.common.models.QTitle;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestionFactory {
    private final static Logger logger = LoggerFactory.getLogger(QuestionFactory.class);


    /**
     * @param id
     * @return
     */
    public static QIndex getQIndexById(Long id) {

        Object obj = Factory.getSession().get(QIndex.class, id);

        if (ObjectUtils.allNotNull(obj))
            return (QIndex) obj;
        else
            return null;
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

    /**
     *
     * @param provider
     * @param officeRID
     * @return
     */
    public static RawOffice get(Provider provider, String officeRID) {
        Object result = null;

        // AgentID NULl CHECK
        if (StringUtils.isBlank(officeRID))
            return null;
        else
            officeRID = StringUtils.trim(officeRID);

        // DO Database Search to load RawAgente
        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(RawOffice.class);
            criteria.add(Restrictions.eq("provider", provider)).add(Restrictions.eq("officeRID", officeRID));

            criteria.setMaxResults(1);
            result = criteria.uniqueResult();
        } finally {
            Factory.commitTransaction();
        }

        // RETURN
        if (result == null)
            return null;

        return (RawOffice) result;
    }

    public static void save(RawOffice rawOffice) {
        try {
            Factory.beginTransaction();
            rawOffice.setDateM(new Date());
            Factory.saveOrUpdate(rawOffice);
            Factory.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param provider
     */
    public static void delete(Provider provider) {
        Factory.delete(provider);
    }
}
