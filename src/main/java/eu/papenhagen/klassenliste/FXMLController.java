package eu.papenhagen.klassenliste;

import eu.papenhagen.klassenliste.entity.Country;
import eu.papenhagen.klassenliste.entity.Member;
import java.io.InputStream;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private TableColumn country;
    @FXML
    private TableColumn bemerkung;

    private MemberSerivce ms = new MemberSerivce();

    //get all member form the Database
    private List<Member> memberlist = ms.getDate();

    //move this List to a ObservableList
    private ObservableList<Member> data = FXCollections.observableArrayList(memberlist);

    @FXML
    void pressedAddButton(ActionEvent event) {
        //create new Member
        Country country = new Country(1, "germany");
        Member m = new Member(999999, "Name", "Nachname", true, 12, "Bemerkung", country);

        EditDialog ep = new EditDialog();
        ep.EditDialog(m);

        //add the new member to the ObservableList
        data.add(m);

        //refrech table after edit
        table.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        InputStream is1 = getClass().getResourceAsStream("/images/male-icon.png");
        InputStream is2 = getClass().getResourceAsStream("/images/female-icon.png");
        Image maleimage = new Image(is1);
        Image femaleimage = new Image(is2);

        //fill the table
        name.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));
        nachname.setCellValueFactory(new PropertyValueFactory<Member, String>("nachname"));
        gender.setCellValueFactory(new PropertyValueFactory<Member, Image>("gender"));
        age.setCellValueFactory(new PropertyValueFactory<Member, Integer>("age"));
        country.setCellValueFactory(new PropertyValueFactory<Country, String>("country"));
        bemerkung.setCellValueFactory(new PropertyValueFactory<Member, String>("bemerkung"));

        //add images and tooltip
        gender.setCellFactory((Object col) -> {
            return new TableCell<Member, Boolean>() {
                private final ImageView imageView = new ImageView();

                {
                    // initialize ImageView + set as graphic
                    imageView.setFitWidth(20);
                    imageView.setFitHeight(20);
                    setGraphic(imageView);
                }

                @Override
                protected void updateItem(Boolean item, boolean empty) {
                    if (empty || item == null) {
                        // no image for empty cells
                        imageView.setImage(null);
                    } else {
                        // set image for non-empty cell
                        imageView.setImage(item ? maleimage : femaleimage);
                        Tooltip tip = new Tooltip(item ? "Männlich" : "Weiblich");
                        setTooltip(tip);
                    }
                }

            };
        });

        //fill the data in the table
        table.setItems(data);

        //Create a ContextMenu
        ContextMenu contextMenu = new ContextMenu();
        MenuItem edit = new MenuItem("Edit Member");
        MenuItem delete = new MenuItem("Delete Member");
        //actions for the context menu
        edit.setOnAction((ActionEvent event) -> {
            editMember();
        });
        delete.setOnAction((ActionEvent event) -> {
            deleteMember();
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
    public void editMember() {
        //get the selected member
        Member m = (Member) table.getSelectionModel().getSelectedItem();

        EditDialog ep = new EditDialog();
        if (m != null) {
            ep.EditDialog(m);
        }

        //refrech table after edit
        table.refresh();

    }

    /**
     * creatr an alert-like dialog for hint the user he will delete a Member for
     * ever
     */
    public void deleteMember() {
        //get the selected member
        Member m = (Member) table.getSelectionModel().getSelectedItem();
        if (m != null) {
            Dialog<Member> dialog = new Dialog<>();

            dialog.setHeaderText("Member löschen");
            dialog.setResizable(true);

            DialogPane dialogPane = dialog.getDialogPane();
            dialogPane.getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);

            Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
            okButton.setText("Löschen");

            Optional result = dialog.showAndWait();
            //on OK save the member
            if (result.get() == ButtonType.OK && m.getAge() <= 0) {
                ms.delete(m);
            } else {
                dialog.close();
            }
            //remove the Member from the ObservableList
            data.remove(m);
        }

        //refrech table after delete
        table.refresh();

    }

}
