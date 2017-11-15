/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.tryout;

import org.junit.Test;
import eu.papenhagen.klassenliste.entity.Country;
import eu.papenhagen.klassenliste.entity.Member;

/**
 * a simple tryout for Member entity
 * 
 * @author jens.papenhagen
 */
public class MemberTryout {

    @Test
    public void memberTryout() {
        //create new Member
        Country country = new Country(0, "germany");
        Member m = new Member(999999, "Name", "Nachname", true, 12, "Bemerkung", country);

        System.out.println("Member: " + m.toString());
    }

}
