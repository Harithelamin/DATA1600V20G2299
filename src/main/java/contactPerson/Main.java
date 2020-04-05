package contactPerson;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Path;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("contactPerson/contactPerson.fxml"));
        //Scene scene= new Scene(root,600, 400);
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Contact Person Form");
        primaryStage.setScene(new Scene(root, 650, 580));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    //This method used to exit the Contact person Form.
    public static void terminate() {

        System.exit(0);
    }


    //This methode is the main methode on Contact person
    public static void main(String[] args) {
        launch(args);
    }

    //Define the source path file for the Contact Person.
    //public static String sourcePathe = "src///resources///contactPerson."+ fileType;
    public static String csvSource = "src///resources///contactPerson.csv";

    //This methode is to save a new contact person in the file.
    public static void saveToCsv(ContactPerson contactPerson) throws ClassNotFoundException {

        //Delimiter used in CSV file
        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvSource, true));
            writer.append(String.valueOf(contactPerson.getPersonId()));
            writer.append(COMMA_DELIMITER);
            writer.append(String.valueOf(contactPerson.getCreatedOn()));
            writer.append(COMMA_DELIMITER);
            writer.append(contactPerson.getFullName());
            writer.append(COMMA_DELIMITER);
            writer.append(contactPerson.getMobileNo());
            writer.append(COMMA_DELIMITER);
            writer.append(String.valueOf(contactPerson.getEmail()));
            writer.append(COMMA_DELIMITER);
            writer.append(contactPerson.getMobileNo());
            writer.append(COMMA_DELIMITER);
            writer.append(contactPerson.getAddress());
            writer.append(COMMA_DELIMITER);
            writer.append(contactPerson.getWebsite());
            writer.append(COMMA_DELIMITER);
            writer.append(contactPerson.getAffiliation());
            writer.append(COMMA_DELIMITER);
            writer.append(contactPerson.getOtherInfo());
            writer.append(NEW_LINE_SEPARATOR);

            writer.close();



        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }



    //This method to create new code to the new Contact Person, will be 4 digits.
    //The Contact person code should be unique.
    public static int getCode() {
        Random random = new Random();
        String code = String.format("%04d", random.nextInt(10000));
        return Integer.parseInt(code);
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
        System.out.println(date);
        return date;
    }

    //This method to check if the Contact Person Id is unique, yes, or No.
    public boolean isContactPersonIdUnique(Integer id) throws Exception {
        ContactPerson contactPerson = findByContactPersonId(id);
        return (contactPerson == null || ((id != null) && (contactPerson.getPersonId() == id)));
    }

    //This method is to get the new line number
    public static int
    GetNewId() {
        LineNumberReader lnr;
        int lineNumber = 0;
        try {
            File file = new File(csvSource);
            lnr = new LineNumberReader(new FileReader(file));
            lnr.skip(Long.MAX_VALUE);
            lineNumber = lnr.getLineNumber();
            lineNumber++;
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            System.out.println(lineNumber);

        } catch (Exception ex) {
            // handle it
        }
        return lineNumber;
    }

//
public static List<ContactPerson> findAllContactPerson() throws IOException, ClassNotFoundException {



    //define a new list
    List<ContactPerson> contactPersons = new ArrayList<ContactPerson>();
    try {
        File file = new File(csvSource);

        //check if the file exists
        if (!file.exists()) {
            throw new FileNotFoundException("file not exits");
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentline = "";
        while ((currentline = reader.readLine()) != null) {

            String[] linearray = currentline.split("\n");
            for (int i = 0; i < linearray.length; i++) {
                String record = linearray[i];
                String[] r1 = record.split(",");
                ContactPerson contactPerson = new ContactPerson();
                contactPerson.setPersonId(Integer.parseInt((r1[0])));
                contactPerson.setCreatedOn(java.sql.Date.valueOf(r1[1]));
                contactPerson.setFullName(( r1[2]));
                contactPerson.setMobileNo(r1[3]);
                contactPerson.setEmail(r1[4]);
                contactPerson.setAddress(r1[5]);
                contactPerson.setWebsite(r1[6]);
                contactPerson.setAffiliation(r1[7]);
                contactPerson.setOtherInfo(r1[8]);
                contactPersons.add(contactPerson);
            }

        }

        System.out.println(contactPersons);
        reader.close();


    } catch (Exception e) {
        e.printStackTrace();
    }

    return contactPersons;
}
    //this method is to find the contact person by contact person id, and return contact person on list
    public static ContactPerson findByContactPersonId(int contactPersonId) throws IOException, ClassNotFoundException {
        List<ContactPerson> contactPersons = findAllContactPerson();

        Iterator<ContactPerson> iterator = contactPersons.iterator();
        while (iterator.hasNext())
        {
            ContactPerson contactPerson = iterator.next();

            // Checking using try catch.
            try {
                if (contactPerson.getPersonId() == (contactPersonId)) {
                    return contactPerson;
                    //System.out.println(contactPerson.getFullName());
                }
            } catch (Exception  e) {
                System.out.print("Caught NullPointerException");
            }
            finally {

            }

        }  return null;
    }


    //this methode is to update any change on the contact person
    public void updateByid(ContactPerson contactPerson) throws IOException {

        //Delimiter used in CSV file
        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";

        String id = String.valueOf(contactPerson.getPersonId());
        try {
            BufferedReader file = new BufferedReader(new FileReader(csvSource));
            String line;
            String input = "";
            while ((line = file.readLine()) != null) {
                if (line.contains(id)) {
                    line = contactPerson.getPersonId() +
                            COMMA_DELIMITER + contactPerson.getFullName() +
                            COMMA_DELIMITER + contactPerson.getMobileNo() +
                            COMMA_DELIMITER + contactPerson.getEmail() +
                            COMMA_DELIMITER + contactPerson.getAddress() +
                            COMMA_DELIMITER + contactPerson.getWebsite() +
                            COMMA_DELIMITER + contactPerson.getAffiliation() +
                            COMMA_DELIMITER + contactPerson.getOtherInfo() +
                            NEW_LINE_SEPARATOR;

                    System.out.println("Line updated.");
                }
                input += line + '\n';
            }
            //Rewrite the record with the changes.
            FileOutputStream File = new FileOutputStream(csvSource);
            File.write(input.getBytes());
            file.close();
            File.close();



        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }

    //this methode is to delete contact person by contact person id.
    public void deleteContactPerson(String contactPersonId) throws IOException, ClassNotFoundException {
        try {
            File inputFile = new File(csvSource);
            if (!inputFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }
            //define a new file that will later be renamed to the original filename.
            File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(csvSource));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;

            //read from the original file and write to the new
            while ((line = br.readLine()) != null) {
                //if (!line.trim().contains(contactPerson.getFullName()) && (!line.trim().contains(contactPerson.getMobileNo()))) {
                if (!line.trim().contains(contactPersonId)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inputFile.delete()) {
                System.out.println("Could not delete file");
                return;

            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inputFile))
                System.out.println("Could not rename file");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }



    }

    public void export(FileChooser fileChooser) throws IOException {
        String original="DATA1600V20G2299\\src\\resources\\contactPerson";
        System.out.println("start");
        if (fileChooser != null) {
            try
            {
                String fileName = fileChooser.getInitialFileName();
                Path target = (Path) Paths.get(original, fileName);
                Files.copy((InputStream) fileChooser.getExtensionFilters(), (java.nio.file.Path) target);
                System.out.println("done");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
