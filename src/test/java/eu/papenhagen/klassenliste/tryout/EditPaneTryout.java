/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.tryout;

import eu.papenhagen.klassenliste.EditDialog;
import eu.papenhagen.klassenliste.entity.Country;
import eu.papenhagen.klassenliste.entity.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import org.junit.Test;

/**
 *
 * @author jens.papenhagen
 */
public class EditPaneTryout {

    @Test
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void tryout() throws InterruptedException {

        JFXPanel jfxPanel = new JFXPanel(); // To start the platform

        final CountDownLatch B = new CountDownLatch(1);

        Platform.runLater(() -> {
            List<Country> countrylist = new ArrayList<>();
            Country country = new Country(0, "germany");
            countrylist.add(country);
            Member m = new Member(9999, "name", "nachname", true, 35, "bemerkung", countrylist);

            EditDialog ep = new EditDialog();
            ep.EditDialog(m);

            //output the member in the cli
            System.out.println(m.toString());

            B.countDown();
        });

        B.await();
    }
}
