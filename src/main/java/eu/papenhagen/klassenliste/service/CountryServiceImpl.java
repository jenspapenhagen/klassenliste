/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.service;

import eu.papenhagen.klassenliste.dao.CountryDao;
import eu.papenhagen.klassenliste.dao.CountryDaoImpl;
import eu.papenhagen.klassenliste.entity.Country;
import java.util.List;

/**
 *
 * @author jay
 */
public class CountryServiceImpl  implements CountryService{
    
     private CountryDao countryDao = new CountryDaoImpl();

    @Override
    public void addCountry(Country country) {
        countryDao.addCountry(country);
    }

    @Override
    public List<Country> listCountry() {
         return countryDao.listCountry();
    }

    @Override
    public void removeCountry(Integer id) {
       countryDao.removeCountry(id);
    }

    @Override
    public void updateCountry(Country country) {
        countryDao.updateCountry(country);
    }
    
}
