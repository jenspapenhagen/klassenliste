/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste;

import eu.papenhagen.klassenliste.entity.Member;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Querry the full table
 *
 * @author jay
 */
public class EntityManager {

    // create session factory
    private SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Member.class)
            .buildSessionFactory();

    // create session
    private Session session = factory.getCurrentSession();

    public List<Member> getDate() {
        session.beginTransaction();
        List<Member> memberList = session.createQuery("from Member").list();

        return memberList;

    }

    public boolean store(Member m) {
        session.beginTransaction();

        Member tempMember = session.get(Member.class, m.getId());
        tempMember = m;

        session.getTransaction().commit();

        return true;
    }

    public boolean delete(Member m) {
        session.beginTransaction();

        Member tempMember = session.get(Member.class, m.getId());
        session.delete(tempMember);

        session.getTransaction().commit();

        return true;
    }

}
