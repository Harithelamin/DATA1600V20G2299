package login;

import menue.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.UserService;
import service.UserServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private UserService userService= new UserServiceImpl();
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPass;
    @FXML
    private Label lblMessage;
    @FXML
    private void btnExit(ActionEvent event){System.exit(0);}

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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblMessage.setVisible(true);
    }

}
