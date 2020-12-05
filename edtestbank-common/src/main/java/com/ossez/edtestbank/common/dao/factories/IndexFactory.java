package com.ossez.edtestbank.common.dao.factories;


import com.ossez.edtestbank.common.dao.Factory;
import org.hibernate.search.FullTextSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IndexFactory
 *
 * @author YuCheng Hu
 */
public class IndexFactory {
    private final static Logger logger = LoggerFactory.getLogger(IndexFactory.class);

    /**
     * Create Lucene full text search index
     *
     * @return
     */
    public static int createIndex() {
        logger.debug("Create Full Text search Index");
        try {
            FullTextSession fullTextSession = org.hibernate.search.Search.getFullTextSession(Factory.getSession());
            fullTextSession.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

}
