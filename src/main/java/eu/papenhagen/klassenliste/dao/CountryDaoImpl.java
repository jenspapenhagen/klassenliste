/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.dao;

import eu.papenhagen.klassenliste.eao.CountryEao;
import eu.papenhagen.klassenliste.entity.Country;
import eu.papenhagen.klassenliste.entity.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author jay
 */
public class CountryDaoImpl implements CountryDao {

    private HibernateUtil mu = new HibernateUtil();
    private CountryEao coa = new CountryEao();

    @Override
    public void addCountry(Country country) {
        try (Session session = mu.getSession()) {
            mu.getTransaction(session);
            mu.saveSession(country);
        }
    }

    @Override
    public List<Country> listCountry() {
        List<Country> countryList;
        try (Session session = mu.getSession()) {
            mu.getTransaction(session);
            countryList = coa.findAll();
        }
        return countryList;
    }

    @Override
    public void removeCountry(Integer id) {
         try (Session session = mu.getSession()) {
            mu.getTransaction(session);
            Country tempCountry = (Country) mu.getObjectBySession(Country.class, id);
            mu.deleteSession(tempCountry);
        }
    }

    @Override
    public void updateCountry(Country country) {
        try (Session session = mu.getSession()) {
            mu.getTransaction(session);
            if (country != null) {
                Country tempCountry = (Country) mu.getObjectBySession(Country.class, country.getId());
                tempCountry = country;
                mu.mergeSession(country);
            }

        }
    }

}
