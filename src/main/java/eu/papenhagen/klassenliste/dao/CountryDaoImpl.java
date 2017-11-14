/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.dao;

import eu.papenhagen.klassenliste.entity.Country;
import eu.papenhagen.klassenliste.entity.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author jay
 */
public class CountryDaoImpl implements CountryDao {

    private HibernateUtil hibernate = new HibernateUtil();

    @Override
    public void addCountry(Country country) {
        try (Session session = hibernate.getSession()) {
            hibernate.getTransaction(session);
            //check if the country exist, else create it
            List<Country> countryList = listCountry();
            boolean countryExist = false;
            for (Country co : countryList) {
                if (co.getCountryname().equals(country.getCountryname())) {
                    countryExist = true;
                }
            }
            if (countryExist) {
                hibernate.saveSession(country);
            }

        }
    }

    @Override
    public List<Country> listCountry() {
        List<Country> countryList;
        try (Session session = hibernate.getSession()) {
            hibernate.getTransaction(session);
            String hql = "from Country";
            countryList = session.createQuery(hql).list();
        }
        return countryList;
    }

    @Override
    public void removeCountry(Integer id) {
        try (Session session = hibernate.getSession()) {
            hibernate.getTransaction(session);
            Country tempCountry = (Country) hibernate.getObjectBySession(Country.class, id);
            hibernate.deleteSession(tempCountry);
        }
    }

    @Override
    public void updateCountry(Country country) {
        try (Session session = hibernate.getSession()) {
            hibernate.getTransaction(session);
            if (country != null) {
                Country tempCountry = (Country) hibernate.getObjectBySession(Country.class, country.getId());
                if (tempCountry.equals(country)) {
                    hibernate.saveSession(country);
                }
            }

        }
    }

}
