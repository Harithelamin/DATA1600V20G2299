package admin;

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
import javafx.stage.Stage;
import komponentPriser.*;
import menue.User;


import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Main main=new Main();

    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    //Bil Type
    @FXML
    private TableView<Bil_type> bil_Type_Table= new TableView();
    @FXML
    private TableColumn<Bil_type, String> navn;
    @FXML
    private TableColumn<Bil_type, Double> pris;
    @FXML
    private TextField txtnavn;
    @FXML
    private TextField txtpris;
    @FXML
    private Button btnAdd ;
    @FXML
    private Button btnDelete;
    @FXML
    private void btnExit(ActionEvent event){
        //main.terminate();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("menue/menue.fxml"));
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
    };
    //users
    @FXML
    private TableView<User> userTable = new TableView<>();
    @FXML
    private TableColumn<User, String> userName;
    @FXML
    private TableColumn<User, String>pass;

    //Hestkrefter
    @FXML
    private TableView<Hestkrefter> hestkrefterTable= new TableView();
    @FXML
    private TableColumn<Hestkrefter, String> hesekrefteNavn;
    @FXML
    private TableColumn<Hestkrefter, Double> hesekreftepris;
    @FXML
    private TextField txtHestkrefterNavn;
    @FXML
    private TextField txtHestkrefterPris;
    @FXML
    private Button btnAddHestkrefter;
    @FXML
    private Button getBtnDeleteHestkrefter;

    //Felg
    @FXML
    private TableView<Felg> felgTable= new TableView();
    @FXML
    private TableColumn<Felg, String> felgNavn;
    @FXML
    private TableColumn<Felg, Double> felgpris;
    @FXML
    private TextField txtFelgNavn;
    @FXML
    private TextField txtFelgPris;
    @FXML
    private Button btnAddFelg;
    @FXML
    private Button btnDeleteFelg;

    //Bil Settetrekk
    @FXML
    private TableView<Settetrekk> Settetrekk_Table= new TableView();
    @FXML
    private TableColumn<Settetrekk, String> settetrekkNavn;
    @FXML
    private TableColumn<Settetrekk, Double> settetrekkPris;
    @FXML
    private TextField txtSettetrekkNavn;
    @FXML
    private TextField txtSettetrekkPris;
    @FXML
    private Button btnAddSettetrekk ;
    @FXML
    private Button btnDeleteSettetrekk;

    //Ratt_type
    @FXML
    private TableView<Ratt_type> Ratt_typeTable= new TableView();
    @FXML
    private TableColumn<Ratt_type, String> ratt_typeNavn;
    @FXML
    private TableColumn<Ratt_type, Double> ratt_typepris;
    @FXML
    private TextField txtRatt_typeNavn;
    @FXML
    private TextField txtRatt_typePris;
    @FXML
    private Button btnAddRatt_type;
    @FXML
    private Button btnDeleteRatt_type;

    //Spoiler
    @FXML
    private TableView<Spoiler> SpoilerTable= new TableView();
    @FXML
    private TableColumn<Spoiler, String> spoilerNavn;
    @FXML
    private TableColumn<Spoiler, Double> spoilerPris;
    @FXML
    private TextField txtSpoilerNavn;
    @FXML
    private TextField txtSpoilerPris;
    @FXML
    private Button btnAddSpoiler;
    @FXML
    private Button btnDeleteSpoiler;

    //Farge
    @FXML
    private TableView<Farge> FargeTable= new TableView();
    @FXML
    private TableColumn<Farge, String> fargeNavn;
    @FXML
    private TableColumn<Spoiler, Double> fargePris;
    @FXML
    private TextField txtFargeNavn;
    @FXML
    private TextField txtFargePris;
    @FXML
    private Button btnAddFarge;
    @FXML
    private Button btnDeleteFarge;

    // update IntegratedGPSPris, Soltak, og Hengefest pris
    @FXML
    private TextField txtIntegratedGPSPris;
    @FXML
    private TextField txtSoltakPris;
    @FXML
    private TextField txtHegefesterPris;
    @FXML
    private Button btnUpdateIntegratedGPSPris;
    @FXML
    private Button btnUpdateSoltakPris;
    @FXML
    private Button btnUpdateHegefesterPris;

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
    //Users tableview
    //Felg table view.
    public void populateUsersTable() throws IOException, ClassNotFoundException {
        userName.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
        pass.setCellValueFactory(new PropertyValueFactory<User, String>("Pass"));
        //userTable.getItems().setAll(main.felgs);
    }


    //Bil Type table view.
    public void populateMyTable() throws IOException, ClassNotFoundException {
        navn.setCellValueFactory(new PropertyValueFactory<Bil_type, String>("navn"));
        pris.setCellValueFactory(new PropertyValueFactory<Bil_type, Double>("pris"));
        bil_Type_Table.getItems().setAll(main.bil_types);
        //set tabe editable
        //bil_Type_Table.setEditable(true);
        //navn.setCellFactory(TextFieldTableCell.forTableColumn());
    }
    //Hestkrefter Type table view.
    public void populateHestkrefterTable() throws IOException, ClassNotFoundException {
        hesekrefteNavn.setCellValueFactory(new PropertyValueFactory<Hestkrefter, String>("navn"));
        hesekreftepris.setCellValueFactory(new PropertyValueFactory<Hestkrefter, Double>("pris"));
        hestkrefterTable.getItems().setAll(main.hestkrefters);
    }

    //Felg table view.
    public void populateFelgTable() throws IOException, ClassNotFoundException {
        felgNavn.setCellValueFactory(new PropertyValueFactory<Felg, String>("navn"));
        felgpris.setCellValueFactory(new PropertyValueFactory<Felg, Double>("pris"));
        felgTable.getItems().setAll(main.felgs);
    }

    //Settetrekk table view.
    public void populateSettetrekkTable() throws IOException, ClassNotFoundException {
        settetrekkNavn.setCellValueFactory(new PropertyValueFactory<Settetrekk, String>("navn"));
        settetrekkPris.setCellValueFactory(new PropertyValueFactory<Settetrekk, Double>("pris"));
        Settetrekk_Table.getItems().setAll(main.settetrekks);
    }

    //Ratt_type table view.
    public void populateRatt_typeTable() throws IOException, ClassNotFoundException {
        ratt_typeNavn.setCellValueFactory(new PropertyValueFactory<Ratt_type, String>("navn"));
        ratt_typepris.setCellValueFactory(new PropertyValueFactory<Ratt_type, Double>("pris"));
        Ratt_typeTable.getItems().setAll(main.ratt_types);
    }

    //Spoiler table view.
    public void populateSpoilerTable() throws IOException, ClassNotFoundException {
        spoilerNavn.setCellValueFactory(new PropertyValueFactory<Spoiler, String>("navn"));
        spoilerPris.setCellValueFactory(new PropertyValueFactory<Spoiler, Double>("pris"));
        SpoilerTable.getItems().setAll(main.spoilers);
    }

    //Farge table view.
    public void populateFargeTable() throws IOException, ClassNotFoundException {
        fargeNavn.setCellValueFactory(new PropertyValueFactory<Farge, String>("navn"));
        fargePris.setCellValueFactory(new PropertyValueFactory<Spoiler, Double>("pris"));
        FargeTable.getItems().setAll(main.farges);
    }

    public  void load_Data() {
        // load_Bill_Type_Table();
        try {
            populateMyTable();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            populateHestkrefterTable();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            populateFelgTable();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            populateSettetrekkTable();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            populateRatt_typeTable();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            populateSpoilerTable();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            populateFargeTable();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        txtIntegratedGPSPris.setText(String.valueOf(main.integratedGPS));
        txtSoltakPris.setText(String.valueOf(main.soltak));
        txtHegefesterPris.setText(String.valueOf(main.hegefester));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        load_Data();

    }

    public void btnAdd(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        if ((txtnavn.getText().isEmpty())) {
            alert.setContentText("navn er påkrevd!");
            alert.showAndWait();
            txtnavn.getStyleClass().add("custom");
            return;
        }

        if (!txtnavn.getText().matches("[aA-zZ ]+$")) {
            alert.setContentText("navn ikke godkjent!");
            alert.showAndWait();
            txtnavn.getStyleClass().add("custom");
            return;
        }
        if ((txtpris.getText().isEmpty())) {
            alert.setContentText("pris er påkrevd!");
            alert.showAndWait();
            txtpris.getStyleClass().add("custom");
            return;
        }
        if(!txtpris.getText().matches("[0-9 ]+$")) {
            alert.setContentText("pris må være number");
            alert.showAndWait();
            txtpris.getStyleClass().add("custom");
            return;
        }

        Bil_type bil_type=new Bil_type();
        bil_type.setNavn(txtnavn.getText().toLowerCase());
        bil_type.setPris(Double.parseDouble(txtpris.getText()));
        //main.bil_types.add(bil_type);
        bil_Type_Table.getItems().add(bil_type);

        txtnavn.clear();
        txtpris.clear();

        main.bil_types.clear();
        for (int i = 0; i< bil_Type_Table.getItems().size(); i ++){
            Bil_type bil_type1= bil_Type_Table.getItems().get(i);
            main.bil_types.add(bil_type1);
        }


        main.updateKomponentsPriser();
        alert.setContentText("Ok. Oppdater!");
        alert.showAndWait();

        //navn.setSortType(bil_Type_Table.S.ASCENDING);
    }



    public void btnDelete(ActionEvent actionEvent) throws NoSuchElementException{
       try {
           ObservableList<Bil_type>bil_types_Selected, all_Bil_Type;
           all_Bil_Type= bil_Type_Table.getItems();
           bil_types_Selected=bil_Type_Table.getSelectionModel().getSelectedItems();
           bil_types_Selected.forEach(all_Bil_Type::remove);


           main.bil_types.clear();
           for (int i = 0; i< bil_Type_Table.getItems().size(); i ++){
               Bil_type bil_type1= bil_Type_Table.getItems().get(i);
               main.bil_types.add(bil_type1);
           }
           try {
               main.updateKomponentsPriser();
               alert.setContentText("Ok. Oppdater!");
               alert.showAndWait();
           } catch (IOException e) {
               e.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
       }
       catch (NoSuchElementException e){};

    }
    private void validationForm() {

    }

    public void btnAddHestkrefter(ActionEvent actionEvent) {
        if ((txtHestkrefterNavn.getText().isEmpty())) {
            alert.setContentText("navn er påkrevd!");
            alert.showAndWait();
            txtHestkrefterNavn.getStyleClass().add("custom");
            return;
        }

        if ((txtHestkrefterPris.getText().isEmpty())) {
            alert.setContentText("pris er påkrevd!");
            alert.showAndWait();
            txtHestkrefterPris.getStyleClass().add("custom");
            return;
        }
        if(!txtHestkrefterPris.getText().matches("[0-9 ]+$")) {
            alert.setContentText("pris må være number");
            alert.showAndWait();
            txtHestkrefterPris.getStyleClass().add("custom");
            return;
        }

        Hestkrefter hestkrefter=new Hestkrefter();
        hestkrefter.setNavn(txtHestkrefterNavn.getText().toLowerCase());
        hestkrefter.setPris(Double.parseDouble(txtHestkrefterPris.getText()));
        //main.bil_types.add(bil_type);
        hestkrefterTable.getItems().add(hestkrefter);

        txtHestkrefterNavn.clear();
        txtHestkrefterPris.clear();

        main.hestkrefters.clear();

        for (int i = 0; i< hestkrefterTable.getItems().size(); i ++){
            Hestkrefter hestkrefter1= hestkrefterTable.getItems().get(i);
            main.hestkrefters.add(hestkrefter1);
        }
        try {
            main.updateKomponentsPriser();
            alert.setContentText("Ok. Oppdater!");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteHestkrefter(ActionEvent actionEvent) throws NoSuchElementException {
        try {
            ObservableList<Hestkrefter>hestkrefter_Selected, all_Hestkrefter;
            all_Hestkrefter= hestkrefterTable.getItems();
            hestkrefter_Selected=hestkrefterTable.getSelectionModel().getSelectedItems();
            hestkrefter_Selected.forEach(all_Hestkrefter::remove);

            main.hestkrefters.clear();
            for (int i = 0; i< hestkrefterTable.getItems().size(); i ++){
                Hestkrefter hestkrefter1= hestkrefterTable.getItems().get(i);
                main.hestkrefters.add(hestkrefter1);
            }
            try {
                main.updateKomponentsPriser();
                alert.setContentText("Ok. Oppdater!");
                alert.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        catch (NoSuchElementException e){};

    }

    public void btnAddFelg(ActionEvent actionEvent) {
        if ((txtFelgNavn.getText().isEmpty())) {
            alert.setContentText("navn er påkrevd!");
            alert.showAndWait();
            txtFelgNavn.getStyleClass().add("custom");
            return;
        }
        if (!txtFelgNavn.getText().matches("[aA-zZ ]+$")) {
            alert.setContentText("navn ikke godkjent!");
            alert.showAndWait();
            txtFelgNavn.getStyleClass().add("custom");
            return;
        }



        if ((txtFelgPris.getText().isEmpty())) {
            alert.setContentText("pris er påkrevd!");
            alert.showAndWait();
            txtFelgPris.getStyleClass().add("custom");
            return;
        }
        if(!txtFelgPris.getText().matches("[0-9 ]+$")) {
            alert.setContentText("pris må være number");
            alert.showAndWait();
            txtFelgPris.getStyleClass().add("custom");
            return;
        }

        Felg felg=new Felg();
        felg.setNavn(txtFelgNavn.getText().toLowerCase());
        felg.setPris(Double.parseDouble(txtFelgPris.getText()));
        //main.bil_types.add(bil_type);
        felgTable.getItems().add(felg);

        txtFelgNavn.clear();
        txtFelgPris.clear();

        main.felgs.clear();

        for (int i = 0; i< felgTable.getItems().size(); i ++){
            Felg felg1= felgTable.getItems().get(i);
            main.felgs.add(felg1);
        }
        try {
            main.updateKomponentsPriser();
            alert.setContentText("Ok. Oppdater!");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteFelg(ActionEvent actionEvent) throws NoSuchElementException{
        try {
            ObservableList<Felg>felg_Selected, all_Felg;
            all_Felg= felgTable.getItems();
            felg_Selected=felgTable.getSelectionModel().getSelectedItems();
            felg_Selected.forEach(all_Felg::remove);

            main.felgs.clear();
            for (int i = 0; i< felgTable.getItems().size(); i ++){
                Felg felg1= felgTable.getItems().get(i);
                main.felgs.add(felg1);
            }
            try {
                main.updateKomponentsPriser();
                alert.setContentText("Ok. Oppdater!");
                alert.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        catch (NoSuchElementException e){};
    }

    public void btnAddSettetrekk(ActionEvent actionEvent) {
        if ((txtSettetrekkNavn.getText().isEmpty())) {
            alert.setContentText("navn er påkrevd!");
            alert.showAndWait();
            txtSettetrekkNavn.getStyleClass().add("custom");
            return;
        }

        if (!txtSettetrekkNavn.getText().matches("[aA-zZ ]+$")) {
            alert.setContentText("navn ikke godkjent!");
            alert.showAndWait();
            txtSettetrekkNavn.getStyleClass().add("custom");
            return;
        }
        if ((txtSettetrekkPris.getText().isEmpty())) {
            alert.setContentText("pris er påkrevd!");
            alert.showAndWait();
            txtSettetrekkPris.getStyleClass().add("custom");
            return;
        }
        if(!txtSettetrekkPris.getText().matches("[0-9 ]+$")) {
            alert.setContentText("pris må være number");
            alert.showAndWait();
            txtSettetrekkPris.getStyleClass().add("custom");
            return;
        }

        Settetrekk settetrekk=new Settetrekk();
        settetrekk.setNavn(txtSettetrekkNavn.getText().toLowerCase());
        settetrekk.setPris(Double.parseDouble(txtSettetrekkPris.getText()));
        //main.bil_types.add(bil_type);
        Settetrekk_Table.getItems().add(settetrekk);

        txtSettetrekkNavn.clear();
        txtSettetrekkPris.clear();

        main.settetrekks.clear();
        for (int i = 0; i< Settetrekk_Table.getItems().size(); i ++){
            Settetrekk settetrekk1= Settetrekk_Table.getItems().get(i);
            main.settetrekks.add(settetrekk1);
        }
        try {
            main.updateKomponentsPriser();
            alert.setContentText("Ok. Oppdater!");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteSettetrekk(ActionEvent actionEvent) throws NoSuchElementException{
        try {
            ObservableList<Settetrekk>settetrekk_Selected, all_Settetrekk;
            all_Settetrekk= Settetrekk_Table.getItems();
            settetrekk_Selected=Settetrekk_Table.getSelectionModel().getSelectedItems();
            settetrekk_Selected.forEach(all_Settetrekk::remove);

            main.settetrekks.clear();
            for (int i = 0; i< Settetrekk_Table.getItems().size(); i ++){
                Settetrekk settetrekk1= Settetrekk_Table.getItems().get(i);
                main.settetrekks.add(settetrekk1);
            }
            try {
                main.updateKomponentsPriser();
                alert.setContentText("Ok. Oppdater!");
                alert.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        catch (NoSuchElementException e){};
    }

    public void btnAddRatt_type(ActionEvent actionEvent) {
        if ((txtRatt_typeNavn.getText().isEmpty())) {
            alert.setContentText("navn er påkrevd!");
            alert.showAndWait();
            txtRatt_typeNavn.getStyleClass().add("custom");
            return;
        }

        if (!txtRatt_typeNavn.getText().matches("[aA-zZ ]+$")) {
            alert.setContentText("navn ikke godkjent!");
            alert.showAndWait();
            txtRatt_typeNavn.getStyleClass().add("custom");
            return;
        }
        if ((txtRatt_typePris.getText().isEmpty())) {
            alert.setContentText("pris er påkrevd!");
            alert.showAndWait();
            txtRatt_typePris.getStyleClass().add("custom");
            return;
        }
        if(!txtRatt_typePris.getText().matches("[0-9 ]+$")) {
            alert.setContentText("pris må være number");
            alert.showAndWait();
            txtRatt_typePris.getStyleClass().add("custom");
            return;
        }

        Ratt_type ratt_type=new Ratt_type();
        ratt_type.setNavn(txtRatt_typeNavn.getText().toLowerCase());
        ratt_type.setPris(Double.parseDouble(txtRatt_typePris.getText()));
        //main.bil_types.add(bil_type);
        Ratt_typeTable.getItems().add(ratt_type);

        txtRatt_typeNavn.clear();
        txtRatt_typePris.clear();

        main.ratt_types.clear();
        for (int i = 0; i< Ratt_typeTable.getItems().size(); i ++){
            Ratt_type ratt_type1= Ratt_typeTable.getItems().get(i);
            main.ratt_types.add(ratt_type1);
        }
        try {
            main.updateKomponentsPriser();
            alert.setContentText("Ok. Oppdater!");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteRatt_type(ActionEvent actionEvent) throws NoSuchElementException{
        try {
            ObservableList<Ratt_type>ratt_type_Selected, all_Ratt_type;
            all_Ratt_type= Ratt_typeTable.getItems();
            ratt_type_Selected=Ratt_typeTable.getSelectionModel().getSelectedItems();
            ratt_type_Selected.forEach(all_Ratt_type::remove);

            main.ratt_types.clear();
            for (int i = 0; i< Ratt_typeTable.getItems().size(); i ++){
                Ratt_type ratt_type1= Ratt_typeTable.getItems().get(i);
                main.ratt_types.add(ratt_type1);
            }
            try {
                main.updateKomponentsPriser();
                alert.setContentText("Ok. Oppdater!");
                alert.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        catch (NoSuchElementException e){};
    }

    public void btnAddSpoiler(ActionEvent actionEvent) {
        if ((txtSpoilerNavn.getText().isEmpty())) {
            alert.setContentText("navn er påkrevd!");
            alert.showAndWait();
            txtSpoilerNavn.getStyleClass().add("custom");
            return;
        }

        if (!txtSpoilerNavn.getText().matches("[aA-zZ ]+$")) {
            alert.setContentText("navn ikke godkjent!");
            alert.showAndWait();
            txtSpoilerNavn.getStyleClass().add("custom");
            return;
        }
        if ((txtSpoilerPris.getText().isEmpty())) {
            alert.setContentText("pris er påkrevd!");
            alert.showAndWait();
            txtSpoilerPris.getStyleClass().add("custom");
            return;
        }
        if(!txtSpoilerPris.getText().matches("[0-9 ]+$")) {
            alert.setContentText("pris må være number");
            alert.showAndWait();
            txtpris.getStyleClass().add("custom");
            return;
        }

        Spoiler spoiler = new Spoiler();
        spoiler.setNavn(txtSpoilerNavn.getText().toLowerCase());
        spoiler.setPris(Double.parseDouble(txtSpoilerPris.getText()));
        //main.bil_types.add(bil_type);
        SpoilerTable.getItems().add(spoiler);

        txtSpoilerNavn.clear();
        txtSpoilerPris.clear();

        main.spoilers.clear();

        for (int i = 0; i< SpoilerTable.getItems().size(); i ++){
            Spoiler spoiler1= SpoilerTable.getItems().get(i);
            main.spoilers.add(spoiler1);
        }
        try {
            main.updateKomponentsPriser();
            alert.setContentText("Ok. Oppdater!");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteSpoiler(ActionEvent actionEvent) throws NoSuchElementException {
        try {
            ObservableList<Spoiler>spoiler_Selected, all_Spoiler;
            all_Spoiler= SpoilerTable.getItems();
            spoiler_Selected=SpoilerTable.getSelectionModel().getSelectedItems();
            spoiler_Selected.forEach(all_Spoiler::remove);

            main.spoilers.clear();
            for (int i = 0; i< SpoilerTable.getItems().size(); i ++){
                Spoiler spoiler1= SpoilerTable.getItems().get(i);
                main.spoilers.add(spoiler1);
            }
            try {
                main.updateKomponentsPriser();
                alert.setContentText("Ok. Oppdater!");
                alert.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        catch (NoSuchElementException e){};
    }

    public void btnAddFarge(ActionEvent actionEvent) {
        if ((txtFargeNavn.getText().isEmpty())) {
            alert.setContentText("navn er påkrevd!");
            alert.showAndWait();
            txtFargeNavn.getStyleClass().add("custom");
            return;
        }

        if (!txtFargeNavn.getText().matches("[aA-zZ ]+$")) {
            alert.setContentText("navn ikke godkjent!");
            alert.showAndWait();
            txtFargeNavn.getStyleClass().add("custom");
            return;
        }
        if ((txtFargePris.getText().isEmpty())) {
            alert.setContentText("pris er påkrevd!");
            alert.showAndWait();
            txtFargePris.getStyleClass().add("custom");
            return;
        }
        if(!txtFargePris.getText().matches("[0-9 ]+$")) {
            alert.setContentText("pris må være number");
            alert.showAndWait();
            txtFargePris.getStyleClass().add("custom");
            return;
        }

        Farge farge=new Farge();
        farge.setNavn(txtFargeNavn.getText().toLowerCase());
        farge.setPris(Double.parseDouble(txtFargePris.getText()));
        //main.bil_types.add(bil_type);
        FargeTable.getItems().add(farge);

        txtFargeNavn.clear();
        txtFargePris.clear();
        main.farges.clear();

        for (int i = 0; i< FargeTable.getItems().size(); i ++){
            Farge farge1= FargeTable.getItems().get(i);
            main.farges.add(farge1);
        }
        try {
            main.updateKomponentsPriser();
            alert.setContentText("Ok. Oppdater!");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteFarge(ActionEvent actionEvent) {
        ObservableList<Farge>farge_Selected, all_Farger;
        all_Farger= FargeTable.getItems();
        farge_Selected=FargeTable.getSelectionModel().getSelectedItems();
        farge_Selected.forEach(all_Farger::remove);

        main.farges.clear();
        for (int i = 0; i< FargeTable.getItems().size(); i ++){
            Farge farge1= FargeTable.getItems().get(i);
            main.farges.add(farge1);
        }
        try {
            main.updateKomponentsPriser();
            alert.setContentText("Ok. Oppdater!");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateIntegratedGPSPris(ActionEvent actionEvent) {
        if(!txtIntegratedGPSPris.getText().matches("[0-9 ]+$")) {
            alert.setContentText("pris må være number");
            alert.showAndWait();
            txtIntegratedGPSPris.getStyleClass().add("custom");
            return;
        }
        main.integratedGPS= Double.parseDouble(txtIntegratedGPSPris.getText());
        try {
            main.updateKomponentsPriser();
            alert.setContentText("Ok. Oppdater!");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateSoltakPris(ActionEvent actionEvent) {
        if(!txtSoltakPris.getText().matches("[0-9 ]+$")) {
            alert.setContentText("pris må være number");
            alert.showAndWait();
            txtSoltakPris.getStyleClass().add("custom");
            return;
        }
        main.soltak=Double.parseDouble(txtSoltakPris.getText());
        try {
            main.updateKomponentsPriser();
            alert.setContentText("Ok. Oppdater!");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateHegefesterPris(ActionEvent actionEvent) {
        if(!txtHegefesterPris.getText().matches("[0-9 ]+$")) {
            alert.setContentText("pris må være number");
            alert.showAndWait();
            txtHegefesterPris.getStyleClass().add("custom");
            return;
        }
        main.hegefester=Double.parseDouble(txtHegefesterPris.getText());
        try {
            main.updateKomponentsPriser();
            alert.setContentText("Ok. Oppdater!");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
