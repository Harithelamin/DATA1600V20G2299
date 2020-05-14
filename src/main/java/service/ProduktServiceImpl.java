package service;

import bilInfo.Main;
import bilInfo.Produkt;
import javafx.scene.control.TableView;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.util.*;


public class ProduktServiceImpl implements ProduktService {
    public void lagereProdukt(Produkt produkt) throws IOException, ClassNotFoundException {
        //Blank work book
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Blan sheet
        XSSFSheet sheet = workbook.createSheet("Produkter Data");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Dato");
        header.createCell(1).setCellValue("Bil Type");
        header.createCell(2).setCellValue("pris");
        header.createCell(3).setCellValue("MVA");
        header.createCell(3).setCellValue("Total pris");

        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue(produkt.getRegistreringDato());
        dataRow.createCell(1).setCellValue(produkt.getBilInfo().getBil_type());
        dataRow.createCell(2).setCellValue(produkt.gettPris());
        dataRow.createCell(3).setCellFormula(String.valueOf(produkt.getmVA()));
        dataRow.createCell(3).setCellFormula(String.valueOf(produkt.gettPris()));

        try {
            FileOutputStream out =  new FileOutputStream(new File("xx.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Excel with foumula cells written successfully");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void lagereProdukt(List<Produkt> produkter) throws IOException, ClassNotFoundException {
        //Blank work book
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Blan sheet
        XSSFSheet sheet = workbook.createSheet("Produkter Data");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Dato");
        header.createCell(1).setCellValue("Bil Type");
        header.createCell(2).setCellValue("pris");
        header.createCell(3).setCellValue("MVA");
        header.createCell(3).setCellValue("Total pris");

        for (int i = 0; i<produkter.size(); i++)
        {
            Row dataRow = sheet.createRow(1);
            dataRow.createCell(0).setCellValue(produkter.get(i).getRegistreringDato());
            dataRow.createCell(1).setCellValue(produkter.get(i).getBilInfo().getBil_type());
            dataRow.createCell(2).setCellValue(produkter.get(i).gettPris());
            dataRow.createCell(3).setCellFormula(String.valueOf(produkter.get(i).getmVA()));
            dataRow.createCell(3).setCellFormula(String.valueOf(produkter.get(i).gettPris()));

        }



        try {
            FileOutputStream out =  new FileOutputStream(new File("xx.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Excel with foumula cells written successfully");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Produkt> Produkt() {
        List<Produkt> x=new ArrayList<>();
        Produkt produkt2=new Produkt();
        produkt2.setkPris(45.3);
        produkt2.setmVA(4.8);
        produkt2.setkPris(5.22);
        x.add(produkt2);
        return x;

    }

}
