/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.dao;

import eu.papenhagen.klassenliste.entity.HibernateUtil;
import eu.papenhagen.klassenliste.entity.Member;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author jay
 */
public class MemberDaoImpl extends GenericDao implements MemberDao {

    private HibernateUtil hibernate = new HibernateUtil();

    @Override
    public void addMember(Member member) {
        try (Session session = hibernate.getSession()) {
            hibernate.getTransaction(session);
            hibernate.saveSession(member);
        }

    }

    @Override
    public List<Member> listMember() {
        List<Member> memberList;
        try (Session session = hibernate.getSession()) {
            hibernate.getTransaction(session);
            //String hql="from Member";
            //String sqlQuery="SELECT * FROM member INNER JOIN country ON member.country_id = country.country_id";
            String sqlQuery = "SELECT * FROM member INNER JOIN country ON member.country_id = country.country_id";
            NativeQuery <Member> createNativeQuery = session.createNativeQuery(sqlQuery, Member.class);
            memberList = createNativeQuery.getResultList();
        }
        return memberList;
    }

    @Override
    public void removeMember(Integer id) {
        try (Session session = hibernate.getSession()) {
            hibernate.getTransaction(session);
            Member tempMember = (Member) hibernate.getObjectBySession(Member.class, id);
            hibernate.deleteSession(tempMember);
        }
    }

    @Override
    public void updateMember(Member member) {
        try (Session session = hibernate.getSession()) {
            hibernate.getTransaction(session);
            if (member != null) {
                Member tempMember = (Member) hibernate.getObjectBySession(Member.class, member.getId());
                tempMember = member;
                hibernate.mergeSession(member);
            }

        }
    }

}