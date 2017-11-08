/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.tryout;

import eu.papenhagen.klassenliste.EditPane;
import eu.papenhagen.klassenliste.entity.Member;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import org.junit.Test;

/**
 *
 * @author jens.papenhagen
 */
public class EditPaneTryout {

    public boolean complete = false;

    @Test
    public void tryout() throws InterruptedException {

        JFXPanel jfxPanel = new JFXPanel(); // To start the platform

        Platform.runLater(() -> {
            Member m = new Member(9999, "name", "nachname", true, 35, "bemerkung");

            EditPane ep = new EditPane();
            ep.EditPane(m);

            complete = true;
        });
        while (!complete) {
            Thread.sleep(500);
        }
    }
}
