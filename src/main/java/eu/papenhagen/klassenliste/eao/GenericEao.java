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

/**
 *
 * @author jay
 */
@SuppressWarnings("serial")
public class GenericEao implements Serializable {

    @Inject
    protected EntityManager em;

    public Object merge(Object entity) {
        return em.merge(entity);
    }

    public Object merge(AuditEntity entity, String lastModifiedBy) {
        entity.setLastModifiedBy(lastModifiedBy);
        return em.merge(entity);
    }

  

}
