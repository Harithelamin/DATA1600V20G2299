package admin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import komponentPriser.*;
import service.AdminService;
import service.AdminServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private AdminService adminService= new AdminServiceImpl();
    public ArrayList<Bil_type> bil_types= (ArrayList<Bil_type>) adminService.load_Bil_Type_List();
    public ArrayList<Hestkrefter>hestkrefters= (ArrayList<Hestkrefter>) adminService.load_Hestkrefter_List();
    public ArrayList<Felg>felgs= (ArrayList<Felg>) adminService.load_Felg_List();
    public ArrayList<Settetrekk> settetrekks= (ArrayList<Settetrekk>) adminService.load_Settetrekk_List();
    public ArrayList<Ratt_type>ratt_types= (ArrayList<Ratt_type>) adminService.load_Ratt_type_List();
    public ArrayList<Spoiler> spoilers= (ArrayList<Spoiler>) adminService.load_Spoiler_List();
    public ArrayList<Farge>farges= (ArrayList<Farge>) adminService.load_Farge_List();
    public double integratedGPS=adminService.loadIntegratedGPS();
    public double soltak=adminService.loadSoltak();
    public double hegefester=adminService.loadHegefester();
    public void updateKomponentsPriser() throws IOException, ClassNotFoundException {
        KomponentsPriser komponentsPriser= new KomponentsPriser();
        for (int i = 0; i<bil_types.size();i++)
            System.out.println(bil_types.get(i));
        komponentsPriser.setBil_type(bil_types);
        komponentsPriser.setHestkrefter(hestkrefters);
        komponentsPriser.setFelg(felgs);
        komponentsPriser.setSettetrekk(settetrekks);
        komponentsPriser.setRatt_type(ratt_types);
        komponentsPriser.setSpoiler(spoilers);
        komponentsPriser.setFarge(farges);
        komponentsPriser.setIntegratedGPS(integratedGPS);
        komponentsPriser.setSoltak(soltak);
        komponentsPriser.setHegefester(hegefester);

        adminService.saveComponentsPrices(komponentsPriser);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("admin/admin.fxml"));
        primaryStage.setTitle("Admin Page");
        primaryStage.setScene(new Scene(root, 1200, 750));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
    //This method used to exit the Contact person Form.
    public static void terminate() {

        System.exit(0);
    }



}
