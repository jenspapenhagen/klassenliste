/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.eao;

import eu.papenhagen.klassenliste.entity.Country;
import javax.ejb.Stateless;
import eu.papenhagen.klassenliste.entity.Member;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

/**
 *
 * @author jay
 */
@Stateless
public class MemberEao extends GenericEao {

    public enum Queries {
        ENTITY_GET_ALL,
        ENTITY_GET_BY_VALUE
    }

    public MemberEao() {
        EntityManagerFactory emf = em.getEntityManagerFactory();
    }

    //SELECT * FROM member INNER JOIN country ON member.country_id = country.country_id
    
    public List<Member> findAll() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
        Metamodel m = em.getMetamodel();
        EntityType<Member> Member_ = m.entity(Member.class);
        EntityType<Country> Country_ = m.entity(Country.class);
        
        Root<Member> member = criteriaQuery.from(Member.class);


        criteriaQuery.select(member);

        List<Member> list = em.createQuery(criteriaQuery).getResultList();
        
        
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
