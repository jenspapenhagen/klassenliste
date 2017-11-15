/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.tryout;

import eu.papenhagen.klassenliste.EditDialog;
import eu.papenhagen.klassenliste.entity.Country;
import eu.papenhagen.klassenliste.entity.Member;
import java.util.concurrent.CountDownLatch;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import org.junit.Test;

/**
 * A Tryout for the Edit Pane
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
            Country country = new Country(0, "germany");
            Member m = new Member(9999, "name", "nachname", true, 35, "bemerkung", country);

            EditDialog ep = new EditDialog();
            ep.EditDialog(m, 9999);

            //output the member in the cli
            System.out.println(m.toString());

            B.countDown();
        });

        B.await();
    }
}
