/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste;

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

    private final SessionFactory sessionFactory = buildSessionFactory();

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(HibernateUtil.class);

    /**
     * build the Session Factory
     *
     * @return
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
     * only get the Session
     */
    public Session getSession() {
        Session session = sessionFactory.openSession();

        return session;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Object getObjectBySession(Class T, int id) {
        Object output;
        try (Session session = getSession()) {
            Transaction transaction = getTransaction(session);
            output = session.get(T, id);
        }

        return output;
    }

    public void saveSession(Object o) {
        try (Session session = getSession()) {
            Transaction transaction = getTransaction(session);
            session.save(o);
            commitTransaction(transaction);
        }
    }

    public void mergeSession(Object o) {
        try (Session session = getSession()) {
            Transaction transaction = getTransaction(session);
            getSession().merge(o);
            commitTransaction(transaction);
        }
    }

    public void deleteSession(Object o) {
        try (Session session = getSession()) {
            Transaction transaction = getTransaction(session);
            getSession().delete(o);
            commitTransaction(transaction);
        }
    }

    public Transaction getTransaction(Session session) {
        Transaction beginTransaction = session.beginTransaction();

        return beginTransaction;
    }

    public void commitTransaction(Transaction transaction) {
        transaction.commit();
    }

    /**
     * shutdown the hibernate *
     */
    public void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
