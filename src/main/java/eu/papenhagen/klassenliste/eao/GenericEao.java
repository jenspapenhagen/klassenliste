/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.eao;

import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import eu.papenhagen.klassenliste.entity.AuditEntity;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jay
 */
@SuppressWarnings("serial")
public class GenericEao implements Serializable {

    @Inject
    protected EntityManager em;

    private EntityTransaction transaction;

    public GenericEao() {
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
     * merge the entity in the entitymanager and adding a lastModifiedBy string
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
     * commit to DB
     */
    public void commit() {
        transaction.commit();
    }

}
