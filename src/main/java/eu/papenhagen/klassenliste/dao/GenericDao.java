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
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jay
 */
@SuppressWarnings("serial")
public class GenericDao implements Serializable {

    private static final int BULK_INSERT_BATCH_SIZE = 50;

    @Inject
    @PersistenceContext
    protected EntityManager em;

    public GenericDao() {
        em = Persistence.createEntityManagerFactory("basee").createEntityManager();
    }

    public <T> List<T> nativeSqlQuery(String sqlQuery, Class<T> clazz) {
        Query query = em.createNativeQuery(sqlQuery, clazz);
        @SuppressWarnings("unchecked")
        List<T> resultList = query.getResultList();
        return resultList;
    }

    public List<?> nativeSqlQuery(String sqlQuery) {
        Query query = em.createNativeQuery(sqlQuery);
        return query.getResultList();
    }

    public Object merge(Object entity) {
        return em.merge(entity);
    }

    public Object merge(AuditEntity entity, String lastModifiedBy) {
        entity.setLastModifiedBy(lastModifiedBy);
        return em.merge(entity);
    }

    public void persist(Object entity) {
        em.persist(entity);
    }

    public void persist(AuditEntity entity, String createdBy) {
        entity.setCreatedBy(createdBy);
        entity.setLastModifiedBy(createdBy);
        em.persist(entity);
    }

    public <T> void persistBulk(Collection<T> entities) {
        int i = 0;
        for (T entity : entities) {
            persist(entity);
            if (++i % BULK_INSERT_BATCH_SIZE == 0) {
                em.flush();
                em.clear();
            }
        }
        em.flush();
        em.clear();
    }

    public void remove(Object entity) {
        em.remove(entity);
    }
}
