package bilInfo;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import komponentPriser.*;
import service.Repo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        primaryStage.setTitle("Bil Register Form");
        primaryStage.setScene(new Scene(root, 750, 700));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    //This method used to exit the Form.
    public static void terminate() {

        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }


    //This method to return the current date on format "yyyy.MM.dd".
    public static java.sql.Date getCurrentDate() {
        Date date3 = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");

        java.sql.Date date = null;

        try {
            date = new java.sql.Date(df.parse(df.format(date3)).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //System.out.println(date);
        return date;
    }

}
