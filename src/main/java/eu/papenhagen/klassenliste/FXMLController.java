package eu.papenhagen.klassenliste;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class FXMLController implements Initializable {
    
    @FXML
    private Button addButton;

    @FXML
    private TableView table;

    @FXML
    void pressedAddButton(ActionEvent event) {

    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
