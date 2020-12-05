package com.ossez.edtestbank.common.dao;


import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Factor for DAO
 *
 * @author YuCheng Hu
 */
public class Factory {
    private static Logger logger = LoggerFactory.getLogger(Factory.class);

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static int indexBatchSize = 100;

    // blocks the commit function from being called - this is useful for unit testing.
    private static boolean noCommit = false;

    // executes a rollback instead of a commit when commit is called - this is useful for unit testing.
    private static boolean autoRollback = false;

    // prevents the connection from being closed. This is useful for unit testing.
    private static boolean noClose = false;


    public static final String HIBERNATE_CONN_STR = "APPSETTING_HIBERNATE_CONNECTION_STRING";
    public static final String HIBERNATE_CONN_USERNAME = "APPSETTING_HIBERNATE_CONNECTION_USERNAME";
    public static final String HIBERNATE_CONN_PASSWORD = "APPSETTING_HIBERNATE_CONNECTION_PASSWORD";


    /**
     * Get Hibernate connection Session
     *
     * @return gets current session
     */
    public static Session getSession() {
        return Factory.getFactory().getCurrentSession();
    }

    /**
     * Get session connection Get
     *
     * @return connection to session
     */
    public static SessionFactory getFactory() {
        if (Factory.sessionFactory == null)
            Factory.sessionFactory = Factory.initSession();

        return Factory.sessionFactory;
    }

    /**
     * Get SessionFactory
     *
     * @return new session
     */
    public static SessionFactory initSession() {
        Configuration configuration = new Configuration();

        String hibernateConnStr = StringUtils.trimToEmpty(System.getenv(HIBERNATE_CONN_STR));
        String hibernateConnUserName = StringUtils.trimToEmpty(System.getenv(HIBERNATE_CONN_USERNAME));
        String hibernateConnUserPassword = StringUtils.trimToEmpty(System.getenv(HIBERNATE_CONN_PASSWORD));

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        if (StringUtils.isNotBlank(hibernateConnStr) && StringUtils.isNotBlank(hibernateConnUserName) && StringUtils.isNotBlank(hibernateConnUserPassword)) {

            Map<String, Object> settings = new HashMap<>();
            settings.put(Environment.URL, hibernateConnStr);
            settings.put(Environment.USER, hibernateConnUserName);
            settings.put(Environment.PASS, hibernateConnUserPassword);

            serviceRegistry = new StandardServiceRegistryBuilder().configure().applySettings(settings).build();
        } else {
            configuration.configure();
            serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        }

        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();

        return sessionFactory;
    }


    /**
     * Begin DataBase Transaction
     */
    public static void beginTransaction() {

        if (!(Factory.getSession().getTransaction() != null && Factory.getSession().getTransaction().isActive())) {
            Factory.getSession().getTransaction().begin();
        } else {

        }
    }

    public static void commitTransaction() {
        if (isAutoRollback()) {
            Factory.rollbackTransaction();
            return;
        }
        if (Factory.getSession().getTransaction() != null && Factory.getSession().getTransaction().isActive()) {
            if (!noCommit)
                Factory.getSession().getTransaction().commit();
        }
    }

    public static void rollbackTransaction() {
        if (Factory.getSession().getTransaction() != null && Factory.getSession().getTransaction().isActive())
            Factory.getSession().getTransaction().rollback();
    }

    /**
     * Gets an object of type T from Hibernate.
     *
     * @param <T>
     * @param classEntity
     * @param id
     * @return object in form of caller
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> classEntity, int id) {
        Object object = Factory.getSession().get(classEntity, id);

        if (object == null)
            return null;

        return (T) object;
    }

    /**
     * Saves the specified object to the database.
     *
     * @param object
     */
    public static void save(Object object) {
        logger.debug("Save Object to Database");

        if (ObjectUtils.isNotEmpty(object)) {
            try {
                Factory.beginTransaction();
                Factory.getSession().saveOrUpdate(object);
            } catch (Exception e) {
                throw e;
            } finally {
                Factory.commitTransaction();
            }
        } else {
            throw new NullPointerException("Object supplied is null");
        }

    }


    /**
     * Deletes the specified object.
     *
     * @param object
     */
    public static void delete(DataObject object) {
        Factory.getSession().delete(object);
    }

    /**
     * Creates an hibernate criteria object which is used to query against objects.
     *
     * @param classArg
     * @return
     */
    public static <T> Criteria createCriteria(Class<T> classArg) {
        return Factory.getSession().createCriteria(classArg);
    }

    /**
     * Creates an hibernate criteria object with the specified alias.
     *
     * @param classArg
     * @param alias
     * @param <T>
     * @return criteria created by factory
     */
    public static <T> Criteria createCriteria(Class<T> classArg, String alias) {
        return Factory.getSession().createCriteria(classArg, alias);
    }

    /**
     * Serializes an object into a byte array.
     *
     * @param object
     * @return serialized object in bytes other wise it returns error
     */
    public static byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        try {
            ObjectOutputStream serializer = new ObjectOutputStream(stream);
            serializer.writeObject(object);
            serializer.close();
        } catch (IOException ex) {
            Factory.handleException(ex);
        }

        byte[] result = stream.toByteArray();
        stream.close();
        return result;
    }

    private static void handleException(IOException ex) {
        // TODO Auto-generated method stub

    }

    /**
     * Merges the specified instance.
     *
     * @param obj
     */
    public static void merge(DataObject obj) {
        Factory.getSession().merge(obj);
    }

    /**
     * Refreshes the specified instance.
     *
     * @param obj
     */
    public static void refresh(DataObject obj) {
        Factory.getSession().refresh(obj);
    }

    /**
     * Saves or updates the object.
     *
     * @param obj
     */
    public static void saveOrUpdate(DataObject obj) {
        Factory.getSession().saveOrUpdate(obj);
    }

    /**
     * Evicts the specified object from the session.
     *
     * @param obj
     */
    public static void evict(DataObject obj) {
        Factory.getSession().evict(obj);
    }


    /**
     * Creates a hibernate query.
     *
     * @param query
     * @return Factory query
     */
    public static Query createQuery(String query) {
        return Factory.getSession().createQuery(query);
    }

    public static FullTextSession getFullTextSession() {
        return Search.getFullTextSession(Factory.getSession());
    }

    /**
     * Closes the session factory. Should only be called when an application is closing.
     */
    public static void close() {
        if (!isNoClose())
            Factory.getFactory().close();
    }


    /**
     * @param noCommit
     */
    public static void setNoCommit(boolean noCommit) {
        Factory.noCommit = noCommit;
    }

    /**
     * @return the noCommit
     */
    public static boolean isNoCommit() {
        return noCommit;
    }

    /**
     * @param autoRollback
     */
    public static void setAutoRollback(boolean autoRollback) {
        Factory.autoRollback = autoRollback;
    }

    /**
     * @return autoRollback
     */
    public static boolean isAutoRollback() {
        return autoRollback;
    }

    /**
     * @param noClose
     */
    public static void setNoClose(boolean noClose) {
        Factory.noClose = noClose;
    }

    /**
     * @return noClose
     */
    public static boolean isNoClose() {
        return noClose;
    }
}
