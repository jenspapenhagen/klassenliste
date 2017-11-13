package eu.papenhagen.klassenliste;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

            Scene scene = new Scene(root);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.png")));
            Platform.setImplicitExit(true);
            stage.setOnCloseRequest((ae) -> {
                Platform.exit();
                System.exit(0);
            });
            stage.setTitle("Klassemliste");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

}
