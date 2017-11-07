/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste;

import eu.papenhagen.klassenliste.entity.Member;
import java.util.Optional;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * Edit Pane
 *
 * @author jay
 */
public class EditPane extends Dialog {

    public EntityManager em = new EntityManager();

    public void EditPane(Member m) {

        //id 
        //are not shown
        
        //name
        Label nameLable = new Label("Name: ");
        TextField nameTextField = new TextField();

        nameTextField.setText(m.getName());
        nameTextField.deselect();
        //nachname
        Label nachnameLable = new Label("Nachname: ");
        TextField nachnameTextField = new TextField();

        nachnameTextField.setText(m.getNachname());
        nachnameTextField.deselect();

        //gender
        Label genderLable = new Label("Geschlecht: ");
        ToggleGroup group = new ToggleGroup();
        RadioButton genderrb = new RadioButton();
        RadioButton genderrb2 = new RadioButton();
        genderrb.setSelected(m.isGender());
        genderrb2.setSelected(m.isGender());

        genderrb.setToggleGroup(group);
        genderrb2.setToggleGroup(group);

        genderrb.setText("Männlich");
        genderrb2.setText("Weiblich");

        //alter
        Label alterLable = new Label("Alter: ");
        TextField alterTextField = new TextField();

        alterTextField.setText("" + m.getAge());
        alterTextField.deselect();

        //bemerkung
        Label bemerkungLable = new Label("Bemerkung: ");
        TextArea bemerkungTextArea = new TextArea();
        bemerkungTextArea.setText(m.getBemerkung());

        VBox vb = new VBox(nameLable, nameTextField,
                nachnameLable, nachnameTextField,
                genderLable, genderrb, genderrb2,
                alterLable, alterTextField,
                bemerkungLable, bemerkungTextArea);

        Dialog<Member> dialog = new Dialog<>();

        if (m.getName().equals("Name")) {
            dialog.setTitle("Member hinzufügen");
            dialog.setHeaderText("Member hinzufügen");
        } else {
            dialog.setTitle("Member ändern");
            dialog.setHeaderText("Member ändern");
        }

        dialog.setResizable(true);

        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.setContent(vb);
        dialogPane.getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);

        Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
        okButton.setText("Speichern");

        Optional result = dialog.showAndWait();
        //on OK save the member
        if (result.get() == ButtonType.OK) {
            //this is the default ID for a new member
            if(m.getId() == 999999){
                m.setId(em.getlastID() + 1);
            }
            m.setName(nameTextField.getText());
            m.setNachname(nachnameTextField.getText());
            //try to get the radio button input
            if (group.getSelectedToggle() != null) {
                m.setGender((boolean) group.getSelectedToggle().getUserData());
            } else {
                m.setGender(true);
            }
            m.setAge(Integer.valueOf(alterTextField.getText()));
            m.setBemerkung(bemerkungTextArea.getText());

            em.store(m);
        } else {
            dialog.close();
        }

    }

}
