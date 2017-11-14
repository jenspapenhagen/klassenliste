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

    @Override
    public void addMember(Member member) {
        try (Session session = (Session) em.getDelegate()) {
            beginTransaction();
            List<Member> memberList = listMember();
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

    @Override
    public List<Member> listMember() {
        List<Member> memberList;
        try (Session session = (Session) em.getDelegate()) {
            beginTransaction();
            //String hql="from Member";
            //String sqlQuery="SELECT * FROM member INNER JOIN country ON member.country_id = country.country_id";

            String sqlQuery = "SELECT * FROM member INNER JOIN country ON member.country_id = country.country_id";

            memberList = nativeSqlQuery(sqlQuery, Member.class);
        }

        return memberList;
    }

    @Override
    public void removeMember(Integer id) {
        try (Session session = (Session) em.getDelegate()) {
            beginTransaction();
            Member tempMember = (Member) em.createNativeQuery("SELECT * FROM Member WHERE id= :id", Member.class).setParameter("id", id).getSingleResult();
            remove(tempMember);
        }
    }

    @Override
    public void updateMember(Member member) {
        try (Session session = (Session) em.getDelegate()) {
            beginTransaction();
            if (member != null) {
                Member tempMember = (Member) em.createNativeQuery("SELECT * FROM Member WHERE id= :id", Member.class).setParameter("id", member.getId()).getSingleResult();
                tempMember = member;
                if (tempMember.equals(member)) {
                    merge(member);
                }
            }

        }
    }

}
