package bilInfo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;



public class Controller implements Initializable {
    Main main= new Main();
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    ObservableList bil_type_list = FXCollections.observableArrayList();
    ObservableList ratt_type_list=FXCollections.observableArrayList();
    ObservableList farge_list=FXCollections.observableArrayList();

    private void loadBilTypeData(){
        bil_type_list.removeAll();
        bil_type_list.addAll("Elektrisk","Bensin","Hybrid");
        bil_type.getItems().addAll(bil_type_list);
    }
    private void loadRattTypeData(){
        ratt_type_list.removeAll();
        ratt_type_list.addAll("Sport","Klassik","Vanlig");
        ratt_type.getItems().addAll(ratt_type_list);
    }
    private void loadFargeData(){
        farge_list.removeAll();
        farge_list.addAll("Svart","Rød","Hvit");
        farge.getItems().addAll(farge_list);
    }
    @FXML
    private ImageView imageView;
    @FXML
    private ChoiceBox<String> bil_type;
    @FXML
    private TextField hestkrefter;
    @FXML
    private TextField felg;
    @FXML
    private TextField settetrekk;
    @FXML
    private ChoiceBox<String> ratt_type;
    @FXML
    private TextField spoiler;
    @FXML
    private ChoiceBox<String> farge;
    @FXML
    private RadioButton integratedGPS;
    @FXML
    private RadioButton soltak;
    @FXML
    private RadioButton hegefester;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnReset;
    @FXML
    private void btnExit(){main.terminate();};
    @FXML
    private void btnReset(){
        bil_type.setValue(null);
        hestkrefter.setText("");
        felg.setText("");
        settetrekk.setText("");
        ratt_type.setValue(null);
        spoiler.setText("");
        farge.setValue(null);
        integratedGPS.setSelected(false);
        soltak.setSelected(false);
        hegefester.setSelected(false);
    }
    @FXML
    private void btnSave()
    {
        if ((bil_type.getSelectionModel().isEmpty())) {
            alert.setContentText("Biltypen er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            return;
        }
        if ((hestkrefter.getText().isEmpty())) {
            alert.setContentText("Hestkreften er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            return;
        }
        if (!hestkrefter.getText().matches("[0-9 ]+$")){
            alert.setContentText("Hestkreften må være number!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            return;
        }
        if (felg.getText().isEmpty()){
            alert.setContentText("Felgen er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            return;
        }
        if (settetrekk.getText().isEmpty()){
            alert.setContentText("Settetrekken er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            return;
        }
        if ((ratt_type.getSelectionModel().isEmpty())) {
            alert.setContentText("Ratten er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            return;
        }
        if (spoiler.getText().isEmpty()){
            alert.setContentText("spoilen er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            return;
        }
        if ((farge.getSelectionModel().isEmpty())) {
            alert.setContentText("Farget er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            return;
        }
        BilInfo bilInfo = new BilInfo();
        bilInfo.setRegDato(main.getCurrentDate());
        bilInfo.setBil_type(bil_type.getValue());
        bilInfo.setHestkrefter(Double.parseDouble(hestkrefter.getText()));
        bilInfo.setFelg(felg.getText());
        bilInfo.setSettetrekk(settetrekk.getText());
        bilInfo.setRatt_type(ratt_type.getValue());
        bilInfo.setSpoiler(spoiler.getText());
        bilInfo.setFarge(farge.getValue());
        bilInfo.setIntegratedGPS(integratedGPS.isSelected());
        bilInfo.setSoltak(soltak.isSelected());
        bilInfo.setHegefester(hegefester.isSelected());

        //saving
        //System.out.println(bilInfo.toString());
        main.saveToObject(bilInfo);
        main.loadObject();

        //message to the user.
        //lbl_status.setText("Billen er registered!");
        //ready to register a new contact person.
        btnReset();
        alert.setContentText("Bilen er registered!");
        alert.showAndWait();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        File file = new File("src/bilde.Jpg");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);

        loadBilTypeData();
        loadRattTypeData();
        loadFargeData();

    }
}
