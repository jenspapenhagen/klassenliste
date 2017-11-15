/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.dao;

import eu.papenhagen.klassenliste.entity.AuditEntity;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author jay
 */
@SuppressWarnings("serial")
public class GenericDao implements Serializable {

    private static final int BULK_INSERT_BATCH_SIZE = 50;

    @Inject
    protected EntityManager em;

    private EntityTransaction transaction;

    public GenericDao() {
        init();
    }

    private void init() {
        em = Persistence.createEntityManagerFactory("basee").createEntityManager();
        transaction = em.getTransaction();
    }

    /**
     * Transaction get startet
     */
    public void beginTransaction() {
        if (!transaction.isActive()) {
            transaction.begin();
        } else {
            init();
        }
    }

    /**
     * Warper for nativeSqlQuery that drop a list
     * with a parsing Class as help
     * 
     * @param <T> pparsing Class
     * @param sqlQuery are parst to the DB 
     * @return a List of goven Type
     */
    public <T> List<T> nativeSqlQuery(String sqlQuery, Class T) {
        Query query = em.createNativeQuery(sqlQuery, T);
        @SuppressWarnings("unchecked")
        List<T> resultList = query.getResultList();
        return resultList;
    }

    /**
     * Warper for nativeSqlQuery that drop a list
     * 
     * @param sqlQuery are parst to the DB 
     * @return a List of goven Type
     */
    public List<?> nativeSqlQuery(String sqlQuery) {
        Query query = em.createNativeQuery(sqlQuery);
        return query.getResultList();
    }

    /**
     * merge the entity in the entitymanager
     * 
     * @param entity
     * @return the feedback of the merge
     * 
     */
    public Object merge(Object entity) {
        Object merge = em.merge(entity);
        commit();

        return merge;
    }

    /**
     * merge the entity in the entitymanager
     * and adding a lastModifiedBy string
     * 
     * @param entity a AuditEntity
     * @param lastModifiedBy as Change Autor
     * @return the feedback of the merge
     */
    public Object merge(AuditEntity entity, String lastModifiedBy) {
        entity.setLastModifiedBy(lastModifiedBy);
        AuditEntity merge = em.merge(entity);
        commit();

        return merge;
    }

    /**
     * persist the entity in the entitymanager
     * 
     * @param entity 
     */
    public void persist(Object entity) {
        em.persist(entity);
        commit();
    }

    /**
     * persist the entity in the entitymanager
     * and adding a lastModifiedBy string
     * 
     * @param entity
     * @param createdBy 
     */
    public void persist(AuditEntity entity, String createdBy) {
        entity.setCreatedBy(createdBy);
        entity.setLastModifiedBy(createdBy);
        em.persist(entity);
        commit();
    }

    /**
     * persist a lot of entities by split it into smaller pices
     * 
     * @param <T>
     * @param entities 
     */
    public <T> void persistBulk(Collection<T> entities) {
        int i = 0;
        for (T entity : entities) {
            persist(entity);
            if (++i % BULK_INSERT_BATCH_SIZE == 0) {
                em.flush();
                em.clear();
            }
        }
        flushAndClear();
    }

    /**
     * remove the entity out of the entitymanager
     * 
     * @param entity that get remove 
     */
    public void remove(Object entity) {
        em.remove(entity);
        commit();
    }

    /**
     * commit to DB
     */
    public void commit() {
        transaction.commit();
    }

    public void flushAndClear() {
        em.flush();
        em.clear();
    }
}
