/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.LoggerFactory;

/**
 * static methods for Hibernate
 *
 * @author jay
 */
public class HibernateUtil {

    private final SessionFactory sessionFactory;

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(HibernateUtil.class);

    public HibernateUtil() {
        sessionFactory = buildSessionFactory();
    }

    /**
     * build the Session Factory out of Configuration /root/ hibernate.cfg.xml
     *
     * @return SessionFactory out of the Configuration
     */
    private SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();

        } catch (HibernateException ex) {
            LOG.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

    /**
     * get Session out of the SessionFactory
     *
     * @return the open Session
     */
    public Session getSession() {
        Session session = sessionFactory.openSession();

        return session;
    }

    /**
     * Get entity out of Session by Class and id of this entity
     *
     * @param class T
     * @param id
     * @return
     */
    public Object getObjectBySession(Class T, int id) {
        Object output;
        try (Session session = getSession()) {
            getTransaction(session);
            output = session.get(T, id);
        }

        return output;
    }

    /**
     * update a object with the DB
     *
     * @param o of any type
     */
    public void updateSession(Object o) {
        try (Session session = getSession()) {
            Transaction transaction = getTransaction(session);
            session.flush();
            session.saveOrUpdate(o);
            commitTransaction(transaction);
        }
    }

    /**
     * save a object with the DB
     *
     * @param o of any type
     */
    public void saveSession(Object o) {
        try (Session session = getSession()) {
            Transaction transaction = getTransaction(session);
            session.flush();
            session.save(o);
            commitTransaction(transaction);
        }
    }

    /**
     * merge a object with the DB
     *
     * @param o of any type
     */
    public void mergeSession(Object o) {
        try (Session session = getSession()) {
            Transaction transaction = getTransaction(session);
            getSession().merge(o);
            commitTransaction(transaction);
        }
    }

    /**
     * delete a object in the DB
     *
     * @param o of any type
     */
    public void deleteSession(Object o) {
        try (Session session = getSession()) {
            Transaction transaction = getTransaction(session);
            getSession().delete(o);
            commitTransaction(transaction);
        }
    }

    /**
     * get a Transaction
     * @param session are need to get a
     * @return Transaction out of the session
     */
    public Transaction getTransaction(Session session) {
        Transaction beginTransaction = session.beginTransaction();

        return beginTransaction;
    }

    /**
     * commit the Transaction
     * and save to DB
     * @param transaction 
     */
    private void commitTransaction(Transaction transaction) {
        transaction.commit();
    }

    /**
     * shutdown the hibernate *
     */
    public void shutdown() {
        // Close caches and connection pools
        sessionFactory.close();
    }
}
