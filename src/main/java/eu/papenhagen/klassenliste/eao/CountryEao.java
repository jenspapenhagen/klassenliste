/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.eao;

import eu.papenhagen.klassenliste.entity.Country;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;

/**
 *
 * @author jay
 */
@Stateless
public class CountryEao extends GenericEao {

    /**
     * findAll Countrys
     * @return a list of all Countrys
     */
    @SuppressWarnings("unchecked")
    public List<Country> findAll() {
        List list = em.createNamedQuery("Country.findAll")
                .getResultList();
        
        //remove duplicates from a list
        Set<Country> depdupeCountry = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(depdupeCountry);

        return list;
    }

}
