/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.service;

import eu.papenhagen.klassenliste.entity.Member;
import eu.papenhagen.klassenliste.dao.MemberDao;
import eu.papenhagen.klassenliste.dao.MemberDaoImpl;
import java.util.List;

/**
 *
 * @author jay
 */
public class MemberSerivceImpl implements MemberSerivce {

    private MemberDao MemberDao = new MemberDaoImpl();

    @Override
    public void addMember(Member member) {
        MemberDao.addMember(member);
    }

    @Override
    public List<Member> listMember() {
        return MemberDao.listMember();
    }

    @Override
    public void removeMember(Integer id) {
        MemberDao.removeMember(id);
    }

    @Override
    public void updateMember(Member member) {
        MemberDao.updateMember(member);
    }

}
