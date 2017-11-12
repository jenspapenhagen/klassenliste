/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.dao;

import eu.papenhagen.klassenliste.eao.MemberEao;
import eu.papenhagen.klassenliste.entity.HibernateUtil;
import eu.papenhagen.klassenliste.entity.Member;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author jay
 */
public class MemberDaoImpl implements MemberDao {

    private HibernateUtil mu = new HibernateUtil();
    private MemberEao mea = new MemberEao();

    @Override
    public void addMember(Member member) {
        try (Session session = mu.getSession()) {
            mu.getTransaction(session);
            mu.saveSession(member);
        }

    }

    @Override
    public List<Member> listMember() {
        List<Member> memberList;
        try (Session session = mu.getSession()) {
            mu.getTransaction(session);
            memberList = mea.findAll();
        }
        return memberList;
    }

    @Override
    public void removeMember(Integer id) {
        try (Session session = mu.getSession()) {
            mu.getTransaction(session);
            Member tempMember = (Member) mu.getObjectBySession(Member.class, id);
            mu.deleteSession(tempMember);
        }
    }

    @Override
    public void updateMember(Member member) {
        try (Session session = mu.getSession()) {
            mu.getTransaction(session);
            if (member != null) {
                Member tempMember = (Member) mu.getObjectBySession(Member.class, member.getId());
                tempMember = member;
                mu.mergeSession(member);
            }

        }
    }
    
    
    
}
