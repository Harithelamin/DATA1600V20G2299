package bilInfo;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;
import komponentPriser.*;
import service.AdminService;
import service.AdminServiceImpl;
import service.ProduktService;
import service.ProduktServiceImpl;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class Controller implements Initializable {
    Main main= new Main();
    private AdminService adminService=new AdminServiceImpl();
    private ProduktService productService= new ProduktServiceImpl();
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    //price lists
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

    boolean validated= false;

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
    private TableView<Produkt> produktr_Table= new TableView<>();
    @FXML
    private TableColumn<Produkt, Date> c1;
    @FXML
    private TableColumn<Produkt, String> c3;
    @FXML
    private TableColumn c2,c4;
    @FXML
    private Button btnDelete;

    //btnlabls
    @FXML
    private Button btnSave;
    @FXML
    private Button btnReset;
    @FXML
    private void btnExit(ActionEvent event){
        //main.terminate();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("menue/menue.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Produkter Form");
            stage.setScene(new Scene(root, 750, 500));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    };
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
    public void populateProduktTable() throws IOException, ClassNotFoundException {
        c1.setCellValueFactory(new PropertyValueFactory<>("registreringDato"));
        //c2.setCellValueFactory(new PropertyValueFactory<>("kPris"));
        c3.setCellValueFactory(new PropertyValueFactory<Produkt, String>("kPris"));
        //produktr_Table.getItems().setAll(main.produkts);
    }


    @FXML
    private void btnSave() throws Exception {
        if (!validated)
        {
            alert.setContentText("Alle felt må fylles ut !");
            alert.showAndWait();
            getCompnentsPriser();
        }
        else {
            try {
                //Bill info object
                BilInfo bilInfo = new BilInfo();
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

                //product object
                Produkt produkt = new Produkt();
                produkt.setRegistreringDato(main.getCurrentDate());
                produkt.setkPris(komponenterPris);
                produkt.setmVA(MVA);
                produkt.settPris(totalPris);
                produkt.setBilInfo(bilInfo);
                System.out.println("++++++++++++++++++++++++");
                System.out.println(produkt.toString());
                main.produkts.add(produkt);
                //produktr_Table.getItems().add(produkt);
                //produktr_Table.refresh();
                //populateProduktTable();

                System.out.println("=======================");
                System.out.println(main.produkts.toString());




            } catch (NullPointerException e) {
            }
        }

    }

    private void validationForm() {
        validated=false;
        if ((bil_type.getSelectionModel().isEmpty())) {
            alert.setContentText("Biltypen er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            validated=false;
            return;
        }
        if ((hestkrefter.getSelectionModel().isEmpty())) {
            alert.setContentText("Hestkreften er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            validated=false;
            return;
        }
        if (felg.getSelectionModel().isEmpty()){
            alert.setContentText("Felgen er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            validated=false;
            return;
        }
        if (settetrekk.getSelectionModel().isEmpty()){
            alert.setContentText("Settetrekken er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            validated=false;
            return;
        }
        if ((ratt_type.getSelectionModel().isEmpty())) {
            alert.setContentText("Ratten er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            validated=false;
            return;
        }
        if (spoiler.getSelectionModel().isEmpty()){
            alert.setContentText("spoilen er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            validated=false;
            return;
        }
        if ((farge.getSelectionModel().isEmpty())) {
            alert.setContentText("Farget er påkrevd!");
            alert.showAndWait();
            bil_type.getStyleClass().add("custom");
            validated=false;
            return;
        }
        else {validated=true;}
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
        bil_types = (ArrayList<Bil_type>) adminService.load_Bil_Type_List();
        loadBilTypeData(bil_types);

        ArrayList<Hestkrefter> hestkrefters = new ArrayList<>();
        hestkrefters = (ArrayList<Hestkrefter>) adminService.load_Hestkrefter_List();
        loadHestkrefterData(hestkrefters);

        ArrayList<Felg> felgs = new ArrayList<>();
        felgs = (ArrayList<Felg>) adminService.load_Felg_List();
        loadFelgData(felgs);

        ArrayList<Settetrekk> settetrekks = new ArrayList<>();
        settetrekks = (ArrayList<Settetrekk>) adminService.load_Settetrekk_List();
        loadSettetrekkData(settetrekks);

        ArrayList<Ratt_type> ratt_types = new ArrayList<>();
        ratt_types = (ArrayList<Ratt_type>) adminService.load_Ratt_type_List();
        loadRattTypeData(ratt_types);

        ArrayList<Spoiler> spoilers = new ArrayList<>();
        spoilers = (ArrayList<Spoiler>) adminService.load_Spoiler_List();
        loadSpoilerData(spoilers);

        ArrayList<Farge> farges = new ArrayList<>();
        farges = (ArrayList<Farge>) adminService.load_Farge_List();
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
            bil_typePris =(adminService.getBilTypePris(bil_type.getValue().toLowerCase().trim()));
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
            fargePris =(adminService.getFargePris(farge.getValue().toLowerCase().trim()));
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
            felgPris =(adminService.getFelgPris(felg.getValue().toLowerCase().trim()));
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
            hestekreftPris =(adminService.getHestkrefterPris(hestkrefter.getValue().toLowerCase().trim()));
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
            ratt_typePris =(adminService.getRatt_typePris(ratt_type.getValue().toLowerCase().trim()));
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
            settetrekkPris =(adminService.getSettetrekkPris(settetrekk.getValue().toLowerCase().trim()));
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
            spilerPris =(adminService.getSpoilerPris(spoiler.getValue().toLowerCase().trim()));
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
            adminService.loadIntegratedGPS();
            integrateGPSPris=adminService.loadIntegratedGPS();
            lblPrs_integratedGPS.setText(String.valueOf(integrateGPSPris));
            lblPrs_integratedGPS.setVisible(true);
            //add it to the components price
            komponenterPris=komponenterPris+integrateGPSPris;

        }
    }
    //find Soltak price
    public void getSoltakSPris(){
        if (soltak.isSelected()) {
            adminService.loadSoltak();
            soltakPris = adminService.loadSoltak();
            lblPrs_soltak.setText(String.valueOf(soltakPris));
            lblPrs_soltak.setVisible(true);
            //add it to the components price
            komponenterPris = komponenterPris + soltakPris;
        }
    }

    //find Hengerfeste price
    public void getHengerfestePris(){
        if (hegefester.isSelected()) {
            adminService.loadHegefester();
            hengefestPris = adminService.loadHegefester();
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

    public void btnDelete(ActionEvent actionEvent) throws NoSuchElementException{


    }

}

