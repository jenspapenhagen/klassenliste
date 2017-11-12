/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.LoggerFactory;

/**
 * static methods for Hibernate
 *
 * @author jay
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(HibernateUtil.class);

    private SessionFactory getSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure(); // configures settings from hibernate.cfg.xml
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

            // If you miss the below line then it will complaing about a missing dialect setting
            serviceRegistryBuilder.applySettings(configuration.getProperties());

            serviceRegistry = serviceRegistryBuilder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Session getSession() {
        Session session = sessionFactory.openSession();

        return session;
    }

    public Object getObjectBySession(Class T, int id) {
        Object output;
        try (Session session = getSession()) {
            getTransaction(session);
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

    private void commitTransaction(Transaction transaction) {
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
