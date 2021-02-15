package com.ossez.edtestbank.common.dao.factories;


import com.google.common.collect.Lists;
import com.ossez.edtestbank.common.dao.Factory;
import com.ossez.edtestbank.common.model.entity.BBSOssezForumAttach;
import com.ossez.edtestbank.common.model.entity.BBSOssezForumPost;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class PostFactory extends Factory {
    private final static Logger logger = LoggerFactory.getLogger(PostFactory.class);

    /**
     * Search ReportManufacturer by ID
     *
     * @param id
     * @return
     */
    public static BBSOssezForumPost getBBSOssezForumPost(Long id) {
        logger.debug("Search Database to find MyScoFile by ID");

        Object obj = Factory.getSession().get(BBSOssezForumPost.class, id);

        if (ObjectUtils.allNotNull(obj))
            return (BBSOssezForumPost) obj;
        else
            return null;
    }

    public static BBSOssezForumPost getBBSOssezForumPostTid(Long tid) {
        logger.debug("Search Database to find MyScoFile by ID");
        Object result = ObjectUtils.NULL;

        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(BBSOssezForumPost.class);
            criteria.add(Restrictions.eq("tid", tid)).addOrder(Order.asc("id"));
            criteria.setMaxResults(1);
            result =  criteria.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }


        return (BBSOssezForumPost) result;

    }



    public static BBSOssezForumAttach getBBSOssezForumAttach(Long id) {
        logger.debug("Search Database to find MyScoFile by ID");

        Object result = ObjectUtils.NULL;

        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(BBSOssezForumAttach.class);
            criteria.add(Restrictions.eq("id", id)).addOrder(Order.asc("id"));
            criteria.setMaxResults(1);
            result =  criteria.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return (BBSOssezForumAttach) result;


    }

    /**
     * @param oid
     * @return
     */
    public static List<BBSOssezForumPost> getMyScoFiles(String oid) {
        logger.debug("Search Database for all files associated with user");
        List<BBSOssezForumPost> results = Lists.newArrayList();
        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(BBSOssezForumPost.class);
            criteria.add(Restrictions.eq("userId", oid)).addOrder(Order.asc("id"));
            results = criteria.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Factory.commitTransaction();
        }
        return results;
    }

    /**
     * Search MyFile from Database
     *
     * @param oid
     * @param fileUUID
     * @return
     */
    public static BBSOssezForumPost getMyScoFile(String oid, String fileUUID, Boolean isInputFile) {
        logger.debug("Search Database for all files associated with user");

        Object result = ObjectUtils.NULL;
        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(BBSOssezForumPost.class);
            criteria.add(Restrictions.eq("userId", oid));

            // SEARCH INPUT OR OUTPUT
            if (isInputFile)
                criteria.add(Restrictions.and(Restrictions.eq("azureInputFileUUID", fileUUID)));
            else
                criteria.add(Restrictions.and(Restrictions.eq("azureOutputFileUUID", fileUUID)));

            //ORDER
            criteria.addOrder(Order.asc("id"));
            criteria.setMaxResults(1);

            result = criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Factory.commitTransaction();
        }

        // RETURN OBJ
        if (ObjectUtils.allNotNull(result))
            return (BBSOssezForumPost) result;

        return null;
    }

    public static BBSOssezForumPost getMyScoFileByInputFileUUID(String oid, String inputFileUUID) {
        logger.debug("Search Database for all files associated with user");

        Object result = ObjectUtils.NULL;
        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(BBSOssezForumPost.class);
            criteria.add(Restrictions.eq("userId", oid));
            criteria.add(Restrictions.and(Restrictions.eq("azureInputFileUUID", inputFileUUID)));
            criteria.addOrder(Order.asc("id"));
            criteria.setMaxResults(1);

            result = criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Factory.commitTransaction();
        }

        // RETURN OBJ
        if (ObjectUtils.allNotNull(result))
            return (BBSOssezForumPost) result;

        return null;
    }


    /**
     * Search myFile by userid and order by ID desc
     *
     * @param oid
     * @return
     */
    public static List<BBSOssezForumPost> getUserMyScoFilesForFrontend(String oid) {
        logger.debug("Search Database for all files associated with user for specific params");
        List<BBSOssezForumPost> results = Lists.newArrayList();

        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(BBSOssezForumPost.class);
            criteria.add(Restrictions.eq("userId", oid)).addOrder(Order.desc("id"));
            results = criteria.list();
        } catch (Exception e) {
            logger.error("Search MyFile table Error", e);
        } finally {
            Factory.commitTransaction();
        }
        return results;
    }


    /**
     * @param outputUUID
     * @param oid
     * @return specific file from user's file list
     */
    public static BBSOssezForumPost getSpecificFile(String oid, String outputUUID) {
        Object result = ObjectUtils.NULL;
        try {
            Factory.beginTransaction();
            Criteria criteria = Factory.createCriteria(BBSOssezForumPost.class);
            criteria.add(Restrictions.eq("userId", oid));
            criteria.add(Restrictions.and(Restrictions.eq("azureOutputFileUUID", outputUUID)));
            criteria.addOrder(Order.asc("id"));
            criteria.setMaxResults(1);
            result = criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Factory.commitTransaction();
        }

        // RETURN OBJ
        if (ObjectUtils.allNotNull(result))
            return (BBSOssezForumPost) result;

        return null;
    }
}
