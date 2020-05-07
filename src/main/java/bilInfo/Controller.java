package bilInfo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import komponentPriser.*;
import service.Repo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class Controller implements Initializable {
    Main main= new Main();
    Repo repo = new Repo();
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    //

    ObservableList bil_type_list = FXCollections.observableArrayList();
    ObservableList hestkrefters_list = FXCollections.observableArrayList();
    ObservableList felgs_list = FXCollections.observableArrayList();
    ObservableList settetrekks_list = FXCollections.observableArrayList();
    ObservableList ratt_type_list = FXCollections.observableArrayList();
    ObservableList spoilers_list = FXCollections.observableArrayList();
    ObservableList farge_list = FXCollections.observableArrayList();

    //price variables
    double bil_typePris;
    double fargePris;
    double felgPris;
    double hestekreftPris;
    double ratt_typePris;
    double settetrekkPris;
    double spilerPris;
    double integrateGPSPris;
    double soltakPris;
    double hengefestPris;
    double komponenterPris;
    double MVA;
    double totalPris;

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

    // To show the Currency type
    @FXML
    private Label lblNok1;
    @FXML
    private Label lblNok2;
    @FXML
    private Label lblNok3;
    @FXML
    private Label lblTotal;
    @FXML
    private Label lbMVA;
    @FXML
    private Label lblMåBetales;



    @FXML
    private Label lblPrs_koponents;
    @FXML
    private Label lblMVA;
    @FXML
    private Label lblPrs_totalPris;


    //tableview
    @FXML
    private TableView<Bestilling> bistilling_Table= new TableView();
    @FXML
    private TableColumn<Bestilling, Date> bestillingDato;
    @FXML
    private TableColumn<Bestilling, Double> kPris;
    @FXML
    private TableColumn<Bestilling, Double> mVA;
    @FXML
    private TableColumn<Bestilling, Double> tPris;
    @FXML
    private Button btnDelete;




    //btnlabls
    @FXML
    private Button btnSave;
    @FXML
    private Button btnReset;
    @FXML
    private void btnExit(){main.terminate();};
    @FXML
    private void btnCalculate() throws Exception {
        validationForm();
        getCompnentsPriser();
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

    //Bil Type table view.
    public void populateBestillingTable() throws IOException, ClassNotFoundException {
        bestillingDato.setCellValueFactory(new PropertyValueFactory<Bestilling, Date>("bestillingDato"));
        kPris.setCellValueFactory(new PropertyValueFactory<Bestilling, Double>("kPris"));
        mVA.setCellValueFactory(new PropertyValueFactory<Bestilling, Double>("mVA"));
        tPris.setCellValueFactory(new PropertyValueFactory<Bestilling, Double>("tPris"));
        bistilling_Table.getItems().setAll();
    }
    @FXML
    private void btnSave()
    {
        validationForm();

        BilInfo bilInfo = new BilInfo();
        bilInfo.setRegDato(main.getCurrentDate());
        bilInfo.setBil_type(bil_type.getValue().toLowerCase());
        bilInfo.setHestkrefter(Double.parseDouble(hestkrefter.getValue()));
        bilInfo.setFelg(felg.getValue());
        bilInfo.setSettetrekk(settetrekk.getValue());
        bilInfo.setRatt_type(ratt_type.getValue());
        bilInfo.setSpoiler(spoiler.getValue());
        bilInfo.setFarge(farge.getValue());
        bilInfo.setIntegratedGPS(integratedGPS.isSelected());
        bilInfo.setSoltak(soltak.isSelected());
        bilInfo.setHegefester(hegefester.isSelected());

        Bestilling bestilling= new Bestilling();
        bestilling.setBestillingDato(main.getCurrentDate());
        bestilling.setBilInfo(bilInfo);
        bestilling.setkPris(komponenterPris);
        bestilling.setmVA(MVA);
        bestilling.settPris(totalPris);
        repo.lagreBestilling(bestilling);

        //getCompnentsPriser(bilInfo);

        //saving
        //System.out.println(bilInfo.toString());
        repo.saveToObject(bilInfo);
        //main.loadObject();

        //message to the user.
        //lbl_status.setText("Billen er registered!");
        //ready to register a new contact person.
        btnReset();
        alert.setContentText("Bestilling er registered!");
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

    public void fillpriser() {
        ArrayList<Bil_type> bil_types = new ArrayList<>();
        bil_types = (ArrayList<Bil_type>) repo.load_Bil_Type_List();
        loadBilTypeData(bil_types);

        ArrayList<Hestkrefter> hestkrefters = new ArrayList<>();
        hestkrefters = (ArrayList<Hestkrefter>) repo.load_Hestkrefter_List();
        loadHestkrefterData(hestkrefters);

        ArrayList<Felg> felgs = new ArrayList<>();
        felgs = (ArrayList<Felg>) repo.load_Felg_List();
        loadFelgData(felgs);

        ArrayList<Settetrekk> settetrekks = new ArrayList<>();
        settetrekks = (ArrayList<Settetrekk>) repo.load_Settetrekk_List();
        loadSettetrekkData(settetrekks);

        ArrayList<Ratt_type> ratt_types = new ArrayList<>();
        ratt_types = (ArrayList<Ratt_type>) repo.load_Ratt_type_List();
        loadRattTypeData(ratt_types);

        ArrayList<Spoiler> spoilers = new ArrayList<>();
        spoilers = (ArrayList<Spoiler>) repo.load_Spoiler_List();
        loadSpoilerData(spoilers);

        ArrayList<Farge> farges = new ArrayList<>();
        farges = (ArrayList<Farge>) repo.load_Farge_List();
        loadFargeData(farges);

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

        lblNok1.setVisible(false);
        lblNok2.setVisible(false);
        lblNok3.setVisible(false);

        lblTotal.setVisible(false);
        lbMVA.setVisible(false);
        lblMåBetales.setVisible(false);

        lblPrs_koponents.setVisible(false);
        lblMVA.setVisible(false);
        lblPrs_totalPris.setVisible(false);

        btnSave.setVisible(false);
    }
    //find bil type price
    public void getBilTypePris(){
        try {
            bil_typePris =(repo.getBilTypePris(bil_type.getValue().toLowerCase().trim()));
            //show the price in the form
            lblPrs_bil_type.setText(String.valueOf(bil_typePris));
            lblPrs_bil_type.setVisible(true);
            //add it to the components price
            komponenterPris=komponenterPris+bil_typePris;
        }
        catch (NullPointerException e){}

    }

    //find farge price
    public void getFargePris(){
        try {
            fargePris =(repo.getFargePris(farge.getValue().toLowerCase().trim()));
            //show the price in the form
            lblPrs_farge.setText(String.valueOf(fargePris));
            lblPrs_farge.setVisible(true);

            //add it to the components price
            komponenterPris=komponenterPris+fargePris;
        } catch (NullPointerException e){}

    }
    //find felg price
    public void getFelgPris(){
        try {
            felgPris =(repo.getFelgPris(felg.getValue().toLowerCase().trim()));
            //show the price in the form
            lblPrs_felg.setText(String.valueOf(felgPris));
            lblPrs_felg.setVisible(true);

            //add it to the components price
            komponenterPris=komponenterPris+felgPris;
        }catch (NullPointerException e){}

    }
    //find Hestekrefter price
    public void getHestekrefterPris(){
        try {
            hestekreftPris =(repo.getHestkrefterPris(hestkrefter.getValue().toLowerCase().trim()));
            //show the price in the form
            lblPrs_hestkrefter.setText(String.valueOf(hestekreftPris));
            lblPrs_hestkrefter.setVisible(true);

            //add it to the components price
            komponenterPris=komponenterPris+hestekreftPris;
        }
        catch (NullPointerException e){}

    }
    //find ratt type price
    public void getRattTypePris(){
        try {
            ratt_typePris =(repo.getRatt_typePris(ratt_type.getValue().toLowerCase().trim()));
            //show the price in the form
            lblPrs_ratt_type.setText(String.valueOf(ratt_typePris));
            lblPrs_ratt_type.setVisible(true);

            //add it to the components price
            komponenterPris=komponenterPris+ratt_typePris;
        }catch (NullPointerException e){}

    }
    //find settetrekk price
    public void getSettetrekkPris(){
        try {
            settetrekkPris =(repo.getSettetrekkPris(settetrekk.getValue().toLowerCase().trim()));
            //show the price in the form
            lblPrs_settetrekk.setText(String.valueOf(settetrekkPris));
            lblPrs_settetrekk.setVisible(true);

            //add it to the components price
            komponenterPris=komponenterPris+settetrekkPris;
        }catch (NullPointerException e){}

    }
    //find Spoiler price
    public void getSpoilerPris(){
        try {
            spilerPris =(repo.getSpoilerPris(spoiler.getValue().toLowerCase().trim()));
            //show the price in the form
            lblPrs_spoiler.setText(String.valueOf(spilerPris));
            lblPrs_spoiler.setVisible(true);

            //add it to the components price
            komponenterPris=komponenterPris+spilerPris;
        }catch (NullPointerException e){}

    }
    //find IntegrateGPS price
    public void getIntegrateGPSPris(){
        if (integratedGPS.isSelected())
        {
            repo.loadIntegratedGPS();
            integrateGPSPris=repo.loadIntegratedGPS();
            lblPrs_integratedGPS.setText(String.valueOf(integrateGPSPris));
            lblPrs_integratedGPS.setVisible(true);
            //add it to the components price
            komponenterPris=komponenterPris+integrateGPSPris;

        }
    }
    //find Soltak price
    public void getSoltakSPris(){
        if (soltak.isSelected()) {
            repo.loadSoltak();
            soltakPris = repo.loadSoltak();
            lblPrs_soltak.setText(String.valueOf(soltakPris));
            lblPrs_soltak.setVisible(true);
            //add it to the components price
            komponenterPris = komponenterPris + soltakPris;
        }
    }

    //find Hengerfeste price
    public void getHengerfestePris(){
        if (hegefester.isSelected()) {
            repo.loadHegefester();
            hengefestPris = repo.loadHegefester();
            lblPrs_hegefester.setText(String.valueOf(hengefestPris));
            lblPrs_hegefester.setVisible(true);
            //add it to the components price
            komponenterPris = komponenterPris + hengefestPris;
        }
    }



    private void getCompnentsPriser() throws Exception{

        //set the komponenterPris equal null
        komponenterPris=0.00;
        //calcuating the total pice, and show it in th form.
        getBilTypePris();
        getFargePris();
        getFelgPris();
        getHestekrefterPris();
        getRattTypePris();
        getSettetrekkPris();
        getSpoilerPris();
        getIntegrateGPSPris();
        getSoltakSPris();
        getHengerfestePris();

        //calc MVA
        MVA=komponenterPris* 0.15;
        //get total with MVA
        totalPris=komponenterPris+MVA;

        //sitt the results in the form
        lblPrs_koponents.setText(String.valueOf(komponenterPris));
        lblMVA.setText(String.valueOf(MVA));
        lblPrs_totalPris.setText(String.valueOf(totalPris));

        lblPrs_koponents.setVisible(true);
        lblMVA.setVisible(true);
        lblPrs_totalPris.setVisible(true);

        //show the currency type in the form
        lblNok1.setVisible(true);
        lblNok2.setVisible(true);
        lblNok3.setVisible(true);

        lblTotal.setVisible(true);
        lbMVA.setVisible(true);
        lblMåBetales.setVisible(true);

        //show save button after calculating
        btnSave.setVisible(true);
    }

}

