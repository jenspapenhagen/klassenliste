/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.dao;

import eu.papenhagen.klassenliste.entity.Country;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Session;

/**
 *
 * @author jay
 */
@Stateless
public class CountryDaoImpl extends GenericDao implements CountryDao {

    @Override
    public void addCountry(Country country) {
        try (Session session = (Session) em.getDelegate()) {
            beginTransaction();
            //check if the country exist, else create it
            List<Country> countryList = listCountry();
            boolean countryExist = false;
            for (Country co : countryList) {
                if (co.getCountryname().equals(country.getCountryname())) {
                    countryExist = true;
                }
            }
            if (countryExist) {
                merge(country);
            }

        }
    }

    @Override
    public List<Country> listCountry() {
        List<Country> countryList;
        try (Session session = (Session) em.getDelegate()) {
            beginTransaction();
            String sqlquery = "SELECT * FROM Country";
            countryList = nativeSqlQuery(sqlquery, Country.class);
        }
        return countryList;
    }

    @Override
    public void removeCountry(Integer id) {
        try (Session session = (Session) em.getDelegate()) {
            beginTransaction();
            Country tempCountry = (Country) em.createNativeQuery("SELECT * FROM Country WHERE id= :id", Country.class ).setParameter("id", id).getSingleResult();
            remove(tempCountry);
        }
    }

    @Override
    public void updateCountry(Country country) {
        try (Session session = (Session) em.getDelegate()) {
            beginTransaction();
            if (country != null) {
                Country tempCountry = (Country) em.createNativeQuery("SELECT * FROM Country WHERE id= :id", Country.class).setParameter("id", country.getId()).getSingleResult();
                if (tempCountry.equals(country)) {
                    merge(country);
                }
            }

        }
    }

}
