package menue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("menue/menue.fxml"));
        primaryStage.setTitle("Bilfirma ");
        primaryStage.setScene(new Scene(root, 650, 300));
        primaryStage.show();
    }

    //This method used to exit the Contact person Form.
    public static void terminate() {

        System.exit(0);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
