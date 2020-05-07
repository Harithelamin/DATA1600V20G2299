package menue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Main main = new Main();
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);




    @FXML
    private void btnOrder(ActionEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bestilling Form");
            stage.setScene(new Scene(root, 750, 500));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }





    @FXML
    private void colseBtn(){main.terminate(); }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void btnAdminPage(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("admin/admin.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bestilling Form");
            stage.setScene(new Scene(root, 700, 750));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

