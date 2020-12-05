package com.ossez.edtestbank.common.dao.factories;


import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.models.orm.Xref;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * SourcingFactory to process sourcing data
 *
 * @author YuCheng Hu
 */
public class XrefFactory extends Factory {
    private final static Logger logger = LoggerFactory.getLogger(XrefFactory.class);

    /**
     * Save List for Object
     *
     * @param xrefList
     * @return
     */
    public static int save(List<Xref> xrefList) {
        logger.debug("Save Sourcing Object List");
        try {
            xrefList.forEach(xref -> {
                save(xref);
            });
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;

    }

}
