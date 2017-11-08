/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * static methods for Hibernate
 * 
 * @author jay
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
  
    /**
     * build the Session Factory 
     * @return 
     */
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
           
        } catch (HibernateException ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
  
    }
    
    /**
     * only get the Session
     */
    public static Session getHibernateSession() {
        Session session = sessionFactory.openSession();

        return session;
    }
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
  
    /**
     * shutdown the hibernate 
     */
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
