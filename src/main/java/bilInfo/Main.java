package bilInfo;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    public static String jobjSource = "src///resources///contactPerson.jobj";


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        primaryStage.setTitle("Bil Register Form");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    //This method used to exit the Contact person Form.
    public static void terminate() {

        System.exit(0);
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void saveToObject(BilInfo bilInfo) {
        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt").getAbsoluteFile(),true);
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(bilInfo);

            o.close();
            f.close();

            FileInputStream fi = new FileInputStream(new File("myObjects.txt").getAbsoluteFile());
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            BilInfo bilInfo1 = (BilInfo) oi.readObject();

            //System.out.println(bilInfo.toString());

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public List<BilInfo> loadObject() {
        ArrayList<BilInfo> bilInfos = new ArrayList<>();
        try{
            FileInputStream is = new FileInputStream("myObjects.txt");
            ObjectInputStream ois = new ObjectInputStream(is);
            Object obj;
            while ((obj=ois.readObject())!=null){
                bilInfos.add((BilInfo) obj);
            }
        }catch (IOException | ClassNotFoundException e){
            e.getStackTrace();
        }


        for(int i = 0; i < bilInfos.size(); i++) {
            System.out.println(bilInfos.get(i).getFarge());
        }


        //System.out.println(bilInfos.toString());
        return bilInfos;

    }
    //This method to return the current date on format "yyyy.MM.dd".
    public static java.sql.Date getCurrentDate(){
        Date date3 = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");

        java.sql.Date date = null;

        try {
            date =new java.sql.Date(df.parse(df.format(date3)).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //System.out.println(date);
        return date;
    }

}
