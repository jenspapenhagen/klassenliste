/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.eao;

import eu.papenhagen.klassenliste.entity.Country;
import java.util.List;

/**
 *
 * @author jay
 */
public class CountryEao extends GenericEao {

    /**
     * Giveback a List of all Country that starts with firstletter
     *
     * @param firstletter the starting letter
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Country> findByFirstLetter(String firstletter) {
        List list = em.createNamedQuery("Country.findByFirstLetter")
                .setParameter("letter", firstletter)
                .getResultList();

        return list;
    }

    /**
     * Giveback a List of all Country that ends with lastletter
     *
     * @param lastletter the ending letter
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Country> findByLastLetter(String lastletter) {
        List list = em.createNamedQuery("Country.findByLastLetter")
                .setParameter("letter", lastletter)
                .getResultList();

        return list;
    }

}
