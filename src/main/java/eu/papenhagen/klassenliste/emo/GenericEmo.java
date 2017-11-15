/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.emo;

import eu.papenhagen.klassenliste.entity.AuditEntity;
import java.io.Serializable;
import java.util.Collection;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jay
 */
@SuppressWarnings("serial")
public class GenericEmo implements Serializable {

    private static final int BULK_INSERT_BATCH_SIZE = 50;

    @Inject
    protected EntityManager em;

    private EntityTransaction transaction;

    public GenericEmo() {
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
     * persist the entity in the entitymanager
     *
     * @param entity
     */
    public void persist(Object entity) {
        em.persist(entity);
        commit();
    }

    /**
     * persist the entity in the entitymanager and adding a lastModifiedBy
     * string
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
