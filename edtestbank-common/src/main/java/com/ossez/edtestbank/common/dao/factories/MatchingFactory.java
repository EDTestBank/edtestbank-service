package com.ossez.edtestbank.common.dao.factories;


import com.google.common.collect.Lists;
import com.ossez.edtestbank.common.SCOConstants;
import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.models.orm.*;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class MatchingFactory extends Factory {
    private final static Logger logger = LoggerFactory.getLogger(MatchingFactory.class);

    /**
     * Search Matching by ID
     *
     * @param id
     * @return
     */
    public static Matching getMatching(Long id) {
        logger.debug("Search Database View of Matching to make sure the view has data in");
        Object obj = ObjectUtils.NULL;

        try {
            Factory.beginTransaction();
            obj = Factory.getSession().get(Matching.class, id);
        } catch (Exception e) {
            logger.error("Get Matching data error.", e);
        } finally {
            Factory.commitTransaction();
        }

        return (Matching) obj;
    }

    /**
     * Search Database for vendorList to get Matching map
     *
     * @param vendorList
     * @return
     */
    public static HashMap<String, BigDecimal> getMatchingMap(List<String> vendorList) {

        HashMap<String, BigDecimal> matchingMap = new HashMap();
        matchingMap.put(SCOConstants.COUNT_MATCH_SINGLE, BigDecimal.ZERO);
        matchingMap.put(SCOConstants.COUNT_MATCH_MULTI, BigDecimal.ZERO);
        matchingMap.put(SCOConstants.COUNT_MATCH_NO, BigDecimal.ZERO);

        // TODO: 12/1/2020 For VendorList Search, we may need to re-think here how
        try {
            Factory.beginTransaction();
            vendorList.forEach(vendorName -> {
                Integer rowCount = NumberUtils.INTEGER_ZERO;

                Criteria criteria = Factory.createCriteria(Matching.class);
                criteria.add(Restrictions.eq("matchName", vendorName));
                criteria.setProjection(Projections.rowCount());
                criteria.setMaxResults(1);
                criteria.uniqueResult();

                rowCount = NumberUtils.toInt(criteria.uniqueResult().toString());

                if (NumberUtils.compare(rowCount, 1) == 0) {
                    matchingMap.put(SCOConstants.COUNT_MATCH_SINGLE, matchingMap.get(SCOConstants.COUNT_MATCH_SINGLE).add(BigDecimal.ONE));
                } else if (NumberUtils.compare(rowCount, 1) > 0) {
                    matchingMap.put(SCOConstants.COUNT_MATCH_MULTI, matchingMap.get(SCOConstants.COUNT_MATCH_MULTI).add(BigDecimal.ONE));
                } else {
                    matchingMap.put(SCOConstants.COUNT_MATCH_NO, matchingMap.get(SCOConstants.COUNT_MATCH_NO).add(BigDecimal.ONE));
                }
            });
        } catch (Exception e) {
            logger.error("Get Matching data error.", e);
        } finally {
            Factory.commitTransaction();
        }

        return matchingMap;
    }

    /**
     * @param vendorName
     * @return
     */
    public static List<Matching> getMatchingListByVendorName(String vendorName) {

        return getMatchingListByVendorName(vendorName, false);
    }

    public static List<Matching> getMatchingListByVendorName(String vendorName, boolean allowPartialMatch) {

        List<Matching> results = Lists.newArrayList();

        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(Matching.class);
            if (allowPartialMatch) {
                criteria.add(Restrictions.ilike("matchName", vendorName, MatchMode.ANYWHERE));
            } else {
                criteria.add(Restrictions.eq("matchName", vendorName));
            }
            criteria.setMaxResults(50);
            results = criteria.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Factory.commitTransaction();
        }
        return results;
    }
}
