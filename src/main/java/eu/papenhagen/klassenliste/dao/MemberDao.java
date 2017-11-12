/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.dao;

import eu.papenhagen.klassenliste.entity.Member;
import java.util.List;

/**
 *
 * @author jay
 */
public interface MemberDao {

    public void addMember(Member member);

    public List<Member> listMember();

    public void removeMember(Integer id);

    public void updateMember(Member member);
}
