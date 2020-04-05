package contactPerson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import validation.EmailFormatValidator;
import validation.NameValidator;
import validation.PhoneNumberValidator;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Main main = new Main();
    EmailFormatValidator emailFormatValidator;
    PhoneNumberValidator phoneNumberValidator;
    NameValidator nameValidator;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);


    @FXML
    private TextField personIdField;
    @FXML
    private TextField fullNameField;
    @FXML
    private TextField mobileNoField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField websiteField;
    @FXML
    private TextField affiliationField;
    @FXML
    private TextField otherInfoField;

    @FXML
    private Label  lbl_status;


    @FXML
    private TableView<ContactPerson> table = new TableView();

    @FXML private TableColumn<ContactPerson, String> personId;
    @FXML private TableColumn<ContactPerson, String> fullName;
    @FXML private TableColumn<ContactPerson, String> mobileNo;
    @FXML private TableColumn<ContactPerson, String> address;



    //Select the file, path, and either csv, or obj
    @FXML
    private void exportBtn(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV File", "*.vsv")
                ,new FileChooser.ExtensionFilter("OBJ File", "*.obj")
        );
        try {
            fileChooser.showSaveDialog(new Stage());
            if(fileChooser != null){
                //main.exportFile(fileChooser.getInitialDirectory(), fileChooser.getSelectedExtensionFilter());
                main.export(fileChooser);
            }
        } catch (Exception ex)
        {
        }
    }



    //define the fields that will be showed in the contact person form sa a table view.
    public void populateMyTable() throws IOException, ClassNotFoundException {
        List<ContactPerson> contactPerson= main.findAllContactPerson();
        personId.setCellValueFactory(new PropertyValueFactory<ContactPerson, String>("personId"));
        fullName.setCellValueFactory(new PropertyValueFactory<ContactPerson, String>("fullName"));
        mobileNo.setCellValueFactory(new PropertyValueFactory<ContactPerson, String>("mobileNo"));
        address.setCellValueFactory(new PropertyValueFactory<ContactPerson, String>("address"));
        table.getItems().setAll(main.findAllContactPerson());
    }

    //New button
    @FXML
    private void newBtn(){

        // put a message that inform which field should be input.
        //alert.setContentText("please input all blue fields!");
        //alert.showAndWait();


        //get a new code, which be insert as contact person code, after saving.
        personIdField.setText(String.valueOf(main.getCode()));

        //clean all fields.
        fullNameField.setText("");fullNameField.getStyleClass().add("bluecustom");
        mobileNoField.setText("");mobileNoField.getStyleClass().add("bluecustom");
        emailField.setText("");emailField.getStyleClass().add("bluecustom");
        addressField.setText("");addressField.getStyleClass().add("bluecustom");
        addressField.setText("");addressField.getStyleClass().add("bluecustom");
        websiteField.setText("");websiteField.getStyleClass().add("bluecustom");
        affiliationField.setText("");affiliationField.getStyleClass().add("bluecustom");
        otherInfoField.setText("");otherInfoField.getStyleClass().add("bluecustom");

    }

    //Find button
    @FXML
    private void findBtn() throws Exception {

        if(!personIdField.getText().matches("[0-9 ]+$")) {
            alert.setContentText("please input the contact person id!");
            alert.showAndWait();
            personIdField.setEditable(true);
            return;
        } else getDataByContactPersonId();
    }

    //Save button
    @FXML
    private void saveBtn() throws Exception {
        if (personIdField.getText().isEmpty())
        {
            newBtn();
        }
        //chech if isContactPersonIdUnique ?
        if (main.isContactPersonIdUnique(Integer.valueOf(personIdField.getText())))
        {alert.setContentText("Please enter unique id.");
            alert.showAndWait();

            return;}
        //check filed full name
       // if(!fullNameField.getText().matches("[aA-zZ ]+$")) {
        {
            if(!fullNameField.getText().matches("[aA-zZ ]+$")) {
                alert.setContentText("Please enter your full name.\n" + "Please make sure enter a valid name");
                alert.showAndWait();
                fullNameField.getStyleClass().add("custom");
                return;
            }
        }
        //check field mobile number.
        if(!mobileNoField.getText().matches("[0-9 ]+$")) {
            alert.setContentText("Please enter your mobile number.\n" + "Please make sure enter a valid mobile number");
            alert.showAndWait();
            mobileNoField.getStyleClass().add("custom");
            return;
        }
        //check field email.
       // if(!emailFormatValidator.validate(emailField.getText())) {
         //   alert.setContentText("Please enter your email address.\n" + "Please make sure enter a valid email address");
           // alert.showAndWait();
            //emailField.getStyleClass().add("custom");
            //return;
        //}
        //check the address field
        if (addressField.getText().isEmpty()){
            alert.setContentText("Please enter your address.\n" + "Please make sure enter a valid address");
            alert.showAndWait();
            addressField.getStyleClass().add("custom");
            return;
        }
        //check the website field
        if (websiteField.getText().isEmpty()){
            alert.setContentText("Please enter your website.\n" + "Please make sure enter a valid website");
            alert.showAndWait();
            websiteField.getStyleClass().add("custom");
            return;
        }
        //check the affiliation field
        if (affiliationField.getText().isEmpty()){
            alert.setContentText("Please enter your affiliation.\n" + "Please make sure enter a valid affiliation");
            alert.showAndWait();
            affiliationField.getStyleClass().add("custom");
            return;
        }
        //check the other info field
        if (otherInfoField.getText().isEmpty()){
            alert.setContentText("Please enter your otherInfo.\n" + "Please input any otherInfo");
            alert.showAndWait();
            otherInfoField.getStyleClass().add("custom");
            return;
        }

        //after checking all fields.
        //create new contact person.
        ContactPerson contactPerson = new ContactPerson();
        //fil up contact person by entered info.
        contactPerson.setPersonId(main.getCode());
        contactPerson.setCreatedOn(main.getCurrentDate());
        contactPerson.setFullName(fullNameField.getText());
        contactPerson.setMobileNo(mobileNoField.getText());
        contactPerson.setEmail(emailField.getText());
        contactPerson.setAddress(addressField.getText());
        contactPerson.setWebsite(websiteField.getText());
        contactPerson.setAffiliation(affiliationField.getText());
        contactPerson.setOtherInfo(otherInfoField.getText());
        //saving
        main.saveToCsv(contactPerson);
        //message to the user.
        lbl_status.setText("Record inserted!");
        //ready to register a new contact person.
        newBtn();
        alert.setContentText("the Contact person was registered .\n" + "you can register new one now.");
        alert.showAndWait();

        //show all records in the table view.
        populateMyTable();
    }

    @FXML
    private void deleteBtn() throws Exception {

        //check if the user allready inputed the contact person id who want to delete.
        if(!personId.getText().isEmpty()) {


            ContactPerson contactPerson = new ContactPerson();
            contactPerson.setPersonId(Integer.parseInt(personIdField.getText()));

            //deleting
            //main.deleteContactPerson(contactPerson);
            main.deleteContactPerson(personIdField.getText());
            //message to the user.
            lbl_status.setText("Record deleted!");

            //show all records in the table view.
            populateMyTable();

        }
        else System.out.println("Not Null allowed");
        alert.setContentText("Please enter contact person id who want to delete");
        alert.showAndWait();
        //show all records in the table view.
        populateMyTable();
        lbl_status.setText("");

    }


    @FXML
    private void getDataByContactPersonId() throws Exception{

        if(!personIdField.getText().isEmpty()) {
            ContactPerson contactPerson = main.findByContactPersonId(Integer.parseInt(personIdField.getText()));
            if (contactPerson != null)
            {
                fullNameField.setText(contactPerson.getFullName());
                mobileNoField.setText(contactPerson.getMobileNo());
                emailField.setText(contactPerson.getEmail());
                addressField.setText(contactPerson.getAddress());
                websiteField.setText(contactPerson.getWebsite());
                affiliationField.setText(contactPerson.getAffiliation());
                otherInfoField.setText(contactPerson.getOtherInfo());
                lbl_status.setText("Record  found!");
            }
            else {
                alert.setContentText("Record not found!, Please enter contact person id who want to find");
                alert.showAndWait();
            }
            }
    }
    @FXML
    private void updateBtn()throws Exception {
        //check filed full name
        // if(!fullNameField.getText().matches("[aA-zZ ]+$")) {
        if (!fullNameField.getText().matches("[aA-zZ ]+$")) {
            alert.setContentText("Please enter your full name.\n" + "Please make sure enter a valid name");
            alert.showAndWait();
            fullNameField.getStyleClass().add("custom");
            return;
        }
        //check field mobile number.
        if (!mobileNoField.getText().matches("[0-9 ]+$")) {
            alert.setContentText("Please enter your mobile number.\n" + "Please make sure enter a valid mobile number");
            alert.showAndWait();
            mobileNoField.getStyleClass().add("custom");
            return;
        }
        //check field email.
        if (!emailFormatValidator.validate(emailField.getText())) {
            alert.setContentText("Please enter your email address.\n" + "Please make sure enter a valid email address");
            alert.showAndWait();
            emailField.getStyleClass().add("custom");
            return;
        }
        //check the address field
        if (addressField.getText().isEmpty()) {
            alert.setContentText("Please enter your address.\n" + "Please make sure enter a valid address");
            alert.showAndWait();
            addressField.getStyleClass().add("custom");
            return;
        }
        //check the website field
        if (websiteField.getText().isEmpty()) {
            alert.setContentText("Please enter your website.\n" + "Please make sure enter a valid website");
            alert.showAndWait();
            websiteField.getStyleClass().add("custom");
            return;
        }
        //check the affiliation field
        if (affiliationField.getText().isEmpty()) {
            alert.setContentText("Please enter your affiliation.\n" + "Please make sure enter a valid affiliation");
            alert.showAndWait();
            affiliationField.getStyleClass().add("custom");
            return;
        }
        //check the other info field
        if (otherInfoField.getText().isEmpty()) {
            alert.setContentText("Please enter your otherInfo.\n" + "Please input any otherInfo");
            alert.showAndWait();
            otherInfoField.getStyleClass().add("custom");
            return;
        }
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setPersonId(Integer.parseInt(personIdField.getText()));
        //contactPerson.setPersonId(personIdField.getText());
        contactPerson.setFullName(fullNameField.getText());
        contactPerson.setMobileNo(mobileNoField.getText());
        contactPerson.setEmail(emailField.getText());
        contactPerson.setAddress(addressField.getText());
        contactPerson.setWebsite(websiteField.getText());
        contactPerson.setAffiliation(affiliationField.getText());
        contactPerson.setAffiliation(affiliationField.getText());
        contactPerson.setOtherInfo(otherInfoField.getText());
        main.updateByid(contactPerson);
        System.out.println("record updated");
        lbl_status.setText("Record updated!");
    }

    @FXML
    private void colseBtn(){main.terminate(); }

    @FXML
    private void menueBtn(ActionEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("culturhouse/Menue.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 650, 300));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        personIdField.setEditable(false); personIdField.getStyleClass().add("custom");
        try {
            populateMyTable();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
