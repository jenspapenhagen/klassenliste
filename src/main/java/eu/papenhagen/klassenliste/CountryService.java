/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste;

import eu.papenhagen.klassenliste.entity.Country;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author jay
 */
public class CountryService {
    
    /**
     * get all member form the db table member
     *
     * @return List of all Member
     */
    public List<Country> getDate() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql="from Country";
        List<Country> countryList = session.createQuery(hql).list();

        return countryList;
    }
    
}