/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.eao;

import eu.papenhagen.klassenliste.entity.Country;
import javax.ejb.Stateless;
import eu.papenhagen.klassenliste.entity.Member;
import java.util.List;

/**
 *
 * @author jay
 */
@Stateless
public class MemberEao extends GenericEao {

    public List<Member> findAll() {
        List list = em.createNamedQuery("Member.findAll")
                .getResultList();

        return list;
    }

    /**
     * Giveback a List of all Member by given gender. Gender-Example:
     *
     * male = true; female = false;
     *
     * @param gender the given gender
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Member> findByGender(boolean gender) {
        List list = em.createNamedQuery("Member.findByGender")
                .setParameter("gender", gender)
                .getResultList();

        return list;
    }

    /**
     * Giveback a List of all Member by given age.
     *
     * @param age for filtering
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Member> findByAge(int age) {
        List list = em.createNamedQuery("Member.findByAge")
                .setParameter("age", age)
                .getResultList();

        return list;
    }

    /**
     * Giveback a List of all Member by given country.
     *
     * @param country for filtering
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Member> findByCountry(Country country) {
        List list = em.createNamedQuery("Member.findByCountry")
                .setParameter("country", country)
                .getResultList();

        return list;
    }
}
