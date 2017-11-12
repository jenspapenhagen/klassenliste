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

/**
 *
 * @author jay
 */
@SuppressWarnings("serial")
public class GenericEmo implements Serializable {

    private static final int BULK_INSERT_BATCH_SIZE = 50;
    
    @Inject
    protected EntityManager em;

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
