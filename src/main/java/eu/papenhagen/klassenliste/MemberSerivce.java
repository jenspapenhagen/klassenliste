/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste;

import eu.papenhagen.klassenliste.entity.Member;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jay
 */
public class MemberSerivce {

    private EntityManager em = new EntityManager();

    /**
     * get all member form the db table member
     *
     * @return List of all Member
     */
    public List<Member> getDate() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Member> memberList = session.createQuery("from Member").list();

        return memberList;
    }

    /**
     * get last ID form member table
     *
     * @return the id of the last member
     */
    public int getlastID() {
        List<Member> memberList = getDate();
        Member m = memberList.get(memberList.size() - 1);

        return m.getId();
    }

    /**
     * store a new Member object in the db
     *
     * @param m new Member
     */
    public void store(Member m) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(m);
            transaction.commit();
        }
    }

    /**
     * update a given Member in the DB
     *
     * @param m the given Member
     */
    public void update(Member m) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            Member tempMember = session.get(Member.class, m.getId());
            tempMember = m;
            session.merge(m);
            transaction.commit();

        }
    }

    /**
     * delete a given Member
     *
     * @param m the given Member
     */
    public void delete(Member m) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            Member tempMember = session.get(Member.class, m.getId());
            session.delete(tempMember);
            transaction.commit();
        }
    }

}
