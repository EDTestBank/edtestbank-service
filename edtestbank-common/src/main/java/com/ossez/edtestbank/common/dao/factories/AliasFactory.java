package com.ossez.edtestbank.common.dao.factories;

import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.models.orm.Alias;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * AliasFactory to process Alias data
 *
 * @author YuCheng Hu
 */
public class AliasFactory extends Factory {
    private final static Logger logger = LoggerFactory.getLogger(AliasFactory.class);

    /**
     * Save aliasList
     *
     * @param aliasList
     * @return
     */
    public static Boolean save(List<Alias> aliasList) {
        logger.debug("Save Alias Object List to Database");
        try {
            aliasList.forEach(alias -> {
                save(alias);
            });
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
