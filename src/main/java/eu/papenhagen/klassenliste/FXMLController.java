package eu.papenhagen.klassenliste;

import eu.papenhagen.klassenliste.entity.Member;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController implements Initializable {

    @FXML
    private Button addButton;
    @FXML
    private TableView table;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn nachname;
    @FXML
    private TableColumn gender;
    @FXML
    private TableColumn age;
    @FXML
    private TableColumn bemerkung;

    @FXML
    void pressedAddButton(ActionEvent event) {
        //create new Member
        Member m = new Member(999999, "Name", "Nachname", true, 12, "Bemerkung");

        EditPane ep = new EditPane();
        ep.EditPane(m);
        
        //refrech table after edit
        table.refresh();
    }

    private MemberSerivce ms = new MemberSerivce();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //get all member form the Database
        List<Member> memberlist = ms.getDate();
        //move this List to a ObservableList
        ObservableList<Member> data = FXCollections.observableArrayList(memberlist);

        //fill the table
        name.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));
        nachname.setCellValueFactory(new PropertyValueFactory<Member, String>("nachname"));
        gender.setCellValueFactory(new PropertyValueFactory<Member, Boolean>("gender"));
        age.setCellValueFactory(new PropertyValueFactory<Member, Integer>("age"));
        bemerkung.setCellValueFactory(new PropertyValueFactory<Member, String>("bemerkung"));

        //fill the data in the table
        table.setItems(data);

        //Create a ContextMenu
        ContextMenu contextMenu = new ContextMenu();
        MenuItem edit = new MenuItem("Edit Member");
        MenuItem delete = new MenuItem("Delete Member");
        //actions for the context menu
        edit.setOnAction((ActionEvent event) -> {
            openEdit();
        });
        delete.setOnAction((ActionEvent event) -> {
            openDelete();
        });

        // Add MenuItem to ContextMenu
        contextMenu.getItems().addAll(edit, delete);

        //add contextmenu to table
        table.setContextMenu(contextMenu);

        //resize polixy javaFX8 
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    /**
     * open the Edit pane with the slected Member out of the table
     */
    public void openEdit() {
        //get the selected member
        Member m = (Member) table.getSelectionModel().getSelectedItem();

        EditPane ep = new EditPane();
        ep.EditPane(m);

        //refrech table after edit
        table.refresh();

    }

    /**
     * creatr a alert like dialog for hint the user he will delete a Member for
     * ever
     */
    public void openDelete() {
        //get the selected member
        Member m = (Member) table.getSelectionModel().getSelectedItem();

        Dialog<Member> dialog = new Dialog<>();

        dialog.setHeaderText("Member löschen");
        dialog.setResizable(true);

        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);

        Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
        okButton.setText("Löschen");

        Optional result = dialog.showAndWait();
        //on OK save the member
        if (result.get() == ButtonType.OK) {
            ms.delete(m);
        } else {
            dialog.close();
        }
    }

}
