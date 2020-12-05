package com.ossez.edtestbank.common.dao.factories;

import java.util.Date;

import com.ossez.edtestbank.common.dao.Factory;
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
    
}
