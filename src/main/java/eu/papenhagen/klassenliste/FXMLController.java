package eu.papenhagen.klassenliste;

import eu.papenhagen.klassenliste.entity.Member;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(EntityManager.pingDb()){
            System.out.println("yeaarrr");
        }else{
            System.out.println("nope");
        }
        
                
//        List<Member> memberlist = new ArrayList<>();
//        memberlist = EntityManager.getDate();
//        ObservableList<Member> list = FXCollections.observableArrayList(memberlist);
//        
//        //fill the table
//        name.setCellValueFactory(new PropertyValueFactory<Member,String>("name"));
//        nachname.setCellValueFactory(new PropertyValueFactory<Member,String>("nachname"));
//        gender.setCellValueFactory(new PropertyValueFactory<Member,Boolean>("gender"));
//        age.setCellValueFactory(new PropertyValueFactory<Member,Integer>("age"));
//        bemerkung.setCellValueFactory(new PropertyValueFactory<Member,String>("bemerkung"));
        
        
        
        
    }
}
