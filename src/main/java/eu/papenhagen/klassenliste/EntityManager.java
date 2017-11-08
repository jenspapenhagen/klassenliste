/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste;

import eu.papenhagen.klassenliste.entity.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.LoggerFactory;

/**
 * Querry the full table
 *
 * @author jay
 */
public class EntityManager {

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(EntityManager.class);

    /**
     * Ping the Database for fast test
     *
     * @return true on connection was okay, can return
     */
    public boolean pingDb() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/db_database?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String pass = "";
        try {
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection con = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!!!");
            return true;

        } catch (SQLException ex) {
            LOG.error(ex.getMessage());

        }
        return false;
    }

    /**
     * get all member form the db table member
     *
     * @return List of all Member
     */
    public List<Member> getDate() {
        Session session = HibernateUtil.getHibernateSession();
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
        try (Session session = HibernateUtil.getHibernateSession()) {
            Transaction transaction = session.beginTransaction();
            transaction.commit();
            session.save(m);
        }
    }

    /**
     * update a given Member in the DB
     *
     * @param m the given Member
     */
    public void update(Member m) {
        try (Session session = HibernateUtil.getHibernateSession()) {
            Transaction transaction = session.beginTransaction();

            Member tempMember = session.get(Member.class, m.getId());
            tempMember = m;
            transaction.commit();
            session.merge(m);
        }
    }

    /**
     * delete a given Member
     *
     * @param m the given Member
     */
    public void delete(Member m) {
        try (Session session = HibernateUtil.getHibernateSession()) {
            Transaction transaction = session.beginTransaction();

            Member tempMember = session.get(Member.class, m.getId());
            session.delete(tempMember);
            transaction.commit();
        }
    }

}
