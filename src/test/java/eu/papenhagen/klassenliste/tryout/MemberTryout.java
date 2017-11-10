/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.tryout;

import org.junit.Test;
import eu.papenhagen.klassenliste.entity.Country;
import eu.papenhagen.klassenliste.entity.Member;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author it6-papeje
 */
public class MemberTryout {

    @Test
    public void memberTryout() {
        //create new Member
        List<Country> countrylist = new ArrayList<>();
        Country country = new Country(0, "germany");
        countrylist.add(country);
        Member m = new Member(999999, "Name", "Nachname", true, 12, "Bemerkung", countrylist);

        System.out.println("Member: " + m.toString());
    }

}
