package com.ossez.edtestbank.common.dao.factories;

import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.models.orm.QuestionIndex;
import com.ossez.edtestbank.common.models.orm.QTitle;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestionFactory {
    private final static Logger logger = LoggerFactory.getLogger(QuestionFactory.class);

    /**
     * @param id
     * @return
     */
    public static QuestionIndex getQuestionIndex(Long id) {
        return (QuestionIndex) Factory.getSession().get(QuestionIndex.class, id);
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
