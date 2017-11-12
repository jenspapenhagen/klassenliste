/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.service;

import eu.papenhagen.klassenliste.eao.CountryEao;
import eu.papenhagen.klassenliste.entity.Country;
import java.util.List;

/**
 *
 * @author jay
 */
public interface CountryService {

    public void addCountry(Country country);

    public List<Country> listCountry();

    public void removeCountry(Integer id);

    public void updateCountry(Country country);

}
