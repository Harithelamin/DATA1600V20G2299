package bilInfo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import komponentPriser.*;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class Controller implements Initializable {
    Main main= new Main();
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    ObservableList bil_type_list = FXCollections.observableArrayList();
    ObservableList hestkrefters_list = FXCollections.observableArrayList();
    ObservableList felgs_list = FXCollections.observableArrayList();
    ObservableList settetrekks_list = FXCollections.observableArrayList();
    ObservableList ratt_type_list = FXCollections.observableArrayList();
    ObservableList spoilers_list = FXCollections.observableArrayList();
    ObservableList farge_list = FXCollections.observableArrayList();





    @FXML
    private ImageView imageView;
    @FXML
    private ChoiceBox<String> bil_type;
    @FXML
    private ChoiceBox<String> hestkrefter;
    @FXML
    private ChoiceBox<String> felg;
    @FXML
    private ChoiceBox<String> settetrekk;
    @FXML
    private ChoiceBox<String> ratt_type;
    @FXML
    private ChoiceBox<String> spoiler;
    @FXML
    private ChoiceBox<String> farge;
    @FXML
    private RadioButton integratedGPS;
    @FXML
    private RadioButton soltak;
    @FXML
    private RadioButton hegefester;


    //lablespriser
    @FXML
    private Label lblPrs_bil_type;
    @FXML
    private Label lblPrs_hestkrefter;
    @FXML
    private Label lblPrs_felg;
    @FXML
    private Label lblPrs_settetrekk;
    @FXML
    private Label lblPrs_ratt_type;
    @FXML
    private Label lblPrs_spoiler;
    @FXML
    private Label lblPrs_farge;
    @FXML
    private Label lblPrs_integratedGPS;
    @FXML
    private Label lblPrs_soltak;
    @FXML
    private Label lblPrs_hegefester;



    @FXML
    private Label lblPrs_koponents;
    @FXML
    private Label lblPrs_mos;
    @FXML
    private Label lblPrs_totalPris;

    //btnlabls
    @FXML
    private Button btnSave;
    @FXML
    private Button btnReset;
    @FXML
    private void btnExit(){main.terminate();};
    @FXML
    private void btnCalculate(){
        validationForm();
    }
    @FXML
    private void btnReset(){

        HidePrisLables();

        bil_type.setValue(null);
        hestkrefter.setValue(null);
        felg.setValue(null);
        settetrekk.setValue(null);
        ratt_type.setValue(null);
        spoiler.setValue(null);
        farge.setValue(null);
        integratedGPS.setSelected(false);
        soltak.setSelected(false);
        hegefester.setSelected(false);
    }
    @FXML
    private void btnSave()
    {
        validationForm();

        BilInfo bilInfo = new BilInfo();
        bilInfo.setRegDato(main.getCurrentDate());
        bilInfo.setBil_type(bil_type.getValue());
        bilInfo.setHestkrefter(Double.parseDouble(hestkrefter.getValue()));
        bilInfo.setFelg(felg.getValue());
        bilInfo.setSettetrekk(settetrekk.getValue());
        bilInfo.setRatt_type(ratt_type.getValue());
        bilInfo.setSpoiler(spoiler.getValue());
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

    private void validationForm() {
        if ((bil_type.getSelectionModel().isEmpty())) {
            alert.setContentText("Biltypen er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            return;
        }
        if ((hestkrefter.getSelectionModel().isEmpty())) {
            alert.setContentText("Hestkreften er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            return;
        }
        if (felg.getSelectionModel().isEmpty()){
            alert.setContentText("Felgen er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            return;
        }
        if (settetrekk.getSelectionModel().isEmpty()){
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
        if (spoiler.getSelectionModel().isEmpty()){
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        File file = new File("src/bilde.Jpg");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);


        HidePrisLables();
        fillpriser();

    }

    public void fillpriser(){
        KomponentsPriser komponentsPriser= new KomponentsPriser();
        komponentsPriser.setPriserDato(main.getCurrentDate());

        ArrayList<Bil_type> bil_types = new ArrayList<Bil_type>();
        bil_types.add(new Bil_type("Elektrisk",50000.00));
        bil_types.add(new Bil_type("Bensin",32000.00));
        bil_types.add(new Bil_type("Hybrid",132000.00));
        komponentsPriser.setBil_type(bil_types);

        loadBilTypeData(bil_types);


        ArrayList<Hestkrefter> hestkrefters = new ArrayList<>();
        hestkrefters.add(new Hestkrefter("2.0", 12000.00));
        hestkrefters.add(new Hestkrefter("2.2", 14000.00));
        hestkrefters.add(new Hestkrefter("3.0", 16400.00));
        komponentsPriser.setHestkrefter(hestkrefters);
        
        loadHestkrefterData(hestkrefters);

        ArrayList<Felg>felgs = new ArrayList<>();
        felgs.add(new Felg("Classic", 40000.00));
        felgs.add(new Felg("Nikel", 49000.00));
        felgs.add(new Felg("Alamonum", 70000.00));
        komponentsPriser.setFelg(felgs);
        
        loadFelgData(felgs);

        ArrayList<Settetrekk>settetrekks = new ArrayList<>();
        settetrekks.add(new Settetrekk("Plastik",49000.00));
        settetrekks.add(new Settetrekk("Skin",62000.00));
        komponentsPriser.setSettetrekk(settetrekks);

        loadSettetrekkData(settetrekks);

        ArrayList<Ratt_type> ratt_types = new ArrayList<>();
        ratt_types.add(new Ratt_type("Vanlig",21000.00));
        ratt_types.add(new Ratt_type("Klassik",29000.00));
        ratt_types.add(new Ratt_type("Sport",35000.00));
        komponentsPriser.setRatt_type(ratt_types);

        loadRattTypeData(ratt_types);

        ArrayList<Spoiler>spoilers = new ArrayList<>();
        spoilers.add(new Spoiler("Med Spoiler", 16000.20));
        spoilers.add(new Spoiler("Uten Spoiler", 00.00));
        komponentsPriser.setSpoiler(spoilers);

        loadSpoilerData(spoilers);

        ArrayList<Farge>farges = new ArrayList<>();
        farges.add(new Farge("Hvit", 34000.00));
        farges.add(new Farge("Svart", 36080.00));
        farges.add(new Farge("Rød", 33600.00));
        farges.add(new Farge("Blue", 31750.00));
        komponentsPriser.setFarge(farges);

        loadFargeData(farges);

        komponentsPriser.setIntegratedGPS(16870.00);
        komponentsPriser.setSoltak(12500.00);
        komponentsPriser.setHegefester(8210.00);
        System.out.println(komponentsPriser.toString());
    }

    private void loadBilTypeData(ArrayList<Bil_type> bil_types){
        bil_type_list.removeAll();

        for (int i = 0; i <bil_types.size();i++)
        {
            bil_type_list.add(bil_types.get(i).navn);
        }

        bil_type.getItems().addAll(bil_type_list);
    }

    private void loadHestkrefterData(ArrayList<Hestkrefter> hestkrefters) {
        hestkrefters_list.removeAll();
        for (int i = 0; i <hestkrefters.size();i++)
        {
            hestkrefters_list.add(hestkrefters.get(i).navn);
        }
        hestkrefter.getItems().addAll(hestkrefters_list);
    }

    private void loadFelgData(ArrayList<Felg> felgs) {
        felgs_list.removeAll();
        for (int i = 0; i <felgs.size();i++)
        {
            felgs_list.add(felgs.get(i).navn);
        }
        felg.getItems().addAll(felgs_list);
    }

    private void loadSettetrekkData(ArrayList<Settetrekk> settetrekks) {
        settetrekks_list.removeAll();
        for (int i = 0; i <settetrekks.size();i++)
        {
            settetrekks_list.add(settetrekks.get(i).navn);
        }
        settetrekk.getItems().addAll(settetrekks_list);
    }

    private void loadRattTypeData(ArrayList<Ratt_type> ratt_types){
        ratt_type_list.removeAll();
        for (int i = 0; i <ratt_types.size();i++)
        {
            ratt_type_list.add(ratt_types.get(i).navn);
        }
        ratt_type.getItems().addAll(ratt_type_list);
    }

    private void loadSpoilerData(ArrayList<Spoiler> spoilers) {
        spoilers_list.removeAll();
        for (int i = 0; i <spoilers.size();i++)
        {
            spoilers_list.add(spoilers.get(i).navn);
        }
        spoiler.getItems().addAll(spoilers_list);
    }

    private void loadFargeData(ArrayList<Farge> farges){
        farge_list.removeAll();
        for (int i = 0; i <farges.size();i++)
        {
            farge_list.add(farges.get(i).navn);
        }
        farge.getItems().addAll(farge_list);
    }

    private void HidePrisLables(){
        lblPrs_bil_type.setVisible(false);
        lblPrs_hestkrefter.setVisible(false);
        lblPrs_felg.setVisible(false);
        lblPrs_settetrekk.setVisible(false);
        lblPrs_ratt_type.setVisible(false);
        lblPrs_spoiler.setVisible(false);
        lblPrs_farge.setVisible(false);
        lblPrs_integratedGPS.setVisible(false);
        lblPrs_soltak.setVisible(false);
        lblPrs_hegefester.setVisible(false);

        lblPrs_koponents.setVisible(false);
        lblPrs_mos.setVisible(false);
        lblPrs_totalPris.setVisible(false);

        btnSave.setVisible(false);
    }

    private void getCompnentsPriser(){

    }
}

