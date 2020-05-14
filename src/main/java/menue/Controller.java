package menue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.UserService;
import service.UserServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Main main = new Main();
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private UserService userService= new UserServiceImpl();
    //login
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPass;
    @FXML
    private Label lblMessage;
    @FXML
    private void btnCancel(ActionEvent event){System.exit(0);}

    @FXML
    private void btnLogin(ActionEvent event){
        if (txtUserName.getText().isEmpty()|| (txtPass.getText().isEmpty())){
            alert.setContentText("Alle felt må fylles ut !");
            alert.showAndWait();
            return;}
        try {
            User user=new User();
            user.setUserName(txtUserName.getText());
            user.setPass(txtPass.getText());
            if(userService.checkUser(user)){
                lblMessage.setText("Takk!");
                lblMessage.setVisible(false);
            }
            else{
                lblMessage.setText("Feil bruker eller pass");
                lblMessage.setVisible(false);
                txtUserName.clear();
                txtPass.clear();
            }
            txtUserName.clear();
            txtPass.clear();
        }catch (NullPointerException e){}

    }




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
            stage.setTitle("Produkter Form");
            stage.setScene(new Scene(root, 700, 800));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

