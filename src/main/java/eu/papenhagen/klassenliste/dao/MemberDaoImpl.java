/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.dao;

import eu.papenhagen.klassenliste.entity.Member;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Session;

/**
 *
 * @author jay
 */
@Stateless
public class MemberDaoImpl extends GenericDao implements MemberDao {

    /**
     * add a Member to the DB
     * 
     * @param member 
     */
    @Override
    public void addMember(Member member) {
        try (Session session = (Session) em.getDelegate()) {
            beginTransaction();
            List<Member> memberList = listMember();
            //Transaction get closed in listCountry()
            beginTransaction();
            boolean memberExist = false;
            for (Member me : memberList) {
                if (me.getId() == member.getId()) {
                    memberExist = true;
                }
            }
            //only save on new Member
            if (!memberExist) {
                merge(member);
            }

        }

    }

    /**
     * get a list of all Member
     * 
     * @return this list 
     */
    @Override
    public List<Member> listMember() {
        List<Member> memberList;
        try (Session session = (Session) em.getDelegate()) {
            beginTransaction();
            String sqlQuery = "SELECT * FROM member INNER JOIN country ON member.country_id = country.country_id";

            memberList = nativeSqlQuery(sqlQuery, Member.class);
        }

        return memberList;
    }

    /**
     * remove a Member from the DB
     * 
     * @param id of this Member
     */
    @Override
    public void removeMember(Integer id) {
        try (Session session = (Session) em.getDelegate()) {
            beginTransaction();

            Member tempMember = (Member) em.find(Member.class, id);
            remove(tempMember);

            //delete entity out the DB
            beginTransaction();
            em.createQuery("delete from Member where id = :id", Member.class)
                    .setParameter("id", id)
                    .executeUpdate();
            commit();
        }
    }

    /**
     * update a given Member
     * 
     * @param member that a are updated 
     */
    @Override
    public void updateMember(Member member) {
        try (Session session = (Session) em.getDelegate()) {
            beginTransaction();
            if (member != null) {
                Member tempMember = (Member) em.find(Member.class, member.getId());
                tempMember = member;
                if (tempMember.equals(member)) {
                    merge(member);
                }
            }

        }
    }

}
