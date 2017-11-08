/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste;

import eu.papenhagen.klassenliste.entity.Member;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Edit Pane this get use in Edit and Create New Member
 *
 * @author jay
 */
public class EditPane extends Dialog {

    private MemberSerivce ms = new MemberSerivce();

    public void EditPane(Member m) {

        boolean isNewMember = false;
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
        ToggleGroup group = new ToggleGroup();
        HBox hb = new HBox();
        Label genderLable = new Label("Geschlecht: ");
        RadioButton genderM = new RadioButton ("Männlich");
        RadioButton genderF = new RadioButton ("Weiblich");
        genderM.setToggleGroup(group);
        genderF.setToggleGroup(group);
        //preselect
        if (m.isGender()) {
            genderM.setSelected(true);
        } else {
            genderF.setSelected(true);
        }
        //add in hbox
        hb.setPadding(new Insets(10));
        hb.setSpacing(5);
        hb.getChildren().addAll(genderLable, genderM, genderF);
        

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
                 hb,
                alterLable, alterTextField,
                bemerkungLable, bemerkungTextArea);

        Dialog<Member> dialog = new Dialog<>();

        if (m.getName().equals("Name")) {
            dialog.setTitle("Member hinzufügen");
            dialog.setHeaderText("Member hinzufügen");
            isNewMember = true;
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
            //the create of a new Member need a own ID and not the default ID
            if (isNewMember) {
                //create new Member for this
                Member tempm = new Member(ms.getlastID() + 1, "", "", true, 12, "");
                m = tempm;
            }
            m.setName(nameTextField.getText());
            m.setNachname(nachnameTextField.getText());

            //get the selecte of the gender checkbox
            boolean gender = true;
            if(genderF.isSelected()) {
                gender = false;
            }

            m.setGender(gender);

            m.setAge(Integer.valueOf(alterTextField.getText()));
            m.setBemerkung(bemerkungTextArea.getText());

            //create or update a member in the db
            if (isNewMember) {
                ms.store(m);
            } else {
                ms.update(m);
            }

        } else {
            dialog.close();
        }

    }

}
