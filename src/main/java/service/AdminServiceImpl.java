package service;


import bilInfo.BilInfo;
import bilInfo.Produkt;
import komponentPriser.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class AdminServiceImpl implements AdminService{
    //Insert data to price object
    public void saveComponentsPrices(KomponentsPriser komponentsPriser) throws IOException, ClassNotFoundException {
        try {
            FileOutputStream fileOut = new FileOutputStream("ObjPris.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(komponentsPriser);
            objectOut.close();
            System.out.println("Ok, prisene er laget opp!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }


    //Read data from Price Object.
    public List<KomponentsPriser> loadPriser() {
        ArrayList<KomponentsPriser> komponentsPrisers = new ArrayList<>();
        try{
            FileInputStream is = new FileInputStream("ObjPris.bin");
            ObjectInputStream ois = new ObjectInputStream(is);
            Object obj;
            while ((obj=ois.readObject())!=null){
                komponentsPrisers.add((KomponentsPriser) obj);
            }
        }catch (IOException | ClassNotFoundException e){
            e.getStackTrace();
        }


        for(int i = 0; i < komponentsPrisers.size(); i++) {
            System.out.println(komponentsPrisers.get(i).getFarge());
        }


        //System.out.println(bilInfos.toString());
        return komponentsPrisers;
    }
    //load Bil_Type_data
    public List<Bil_type> load_Bil_Type_List() throws NullPointerException{
        List<KomponentsPriser> komponentsPrisers = loadPriser();
        List<Bil_type> bil_types = new ArrayList<>();
        Iterator<KomponentsPriser> i = komponentsPrisers.iterator();
        while (i.hasNext()) {
           try {
               KomponentsPriser f = i.next();
               if (f.getBil_type()==null){return bil_types;}
               Iterator<Bil_type> ci = f.getBil_type().iterator();
               while (ci.hasNext()) {
                   Bil_type c = ci.next();
                   bil_types.add(c);
               }
           } catch (NoSuchElementException e){}
        }
        return bil_types;
    }
    //load Hestkrefter_data
    public List<Hestkrefter> load_Hestkrefter_List() {
        List<KomponentsPriser> komponentsPrisers = loadPriser();
        List<Hestkrefter> hestkrefters = new ArrayList<>();
        Iterator<KomponentsPriser> i = komponentsPrisers.iterator();
        while (i.hasNext()) {
            KomponentsPriser f = i.next();
            System.out.println("KomponentsPriser: " + f.getHestkrefter());
            System.out.println("Hestkrefter:");
            if (f.getHestkrefter()==null){return hestkrefters;}
            Iterator<Hestkrefter> ci = f.getHestkrefter().iterator();
            while (ci.hasNext()) {
                Hestkrefter c = ci.next();
                hestkrefters.add(c);
                System.out.println(c.getNavn());
                System.out.println(c.getPris());
            }
        }
        return hestkrefters;
    }
    //load Felg_data
    public List<Felg> load_Felg_List() {
        List<KomponentsPriser> komponentsPrisers = loadPriser();
        List<Felg> felgs = new ArrayList<>();
        Iterator<KomponentsPriser> i = komponentsPrisers.iterator();
        while (i.hasNext()) {
            KomponentsPriser f = i.next();
            System.out.println("KomponentsPriser: " + f.getFelg());
            System.out.println("Felg:");
            if (f.getFelg()==null){return felgs;}
            Iterator<Felg> ci = f.getFelg().iterator();
            while (ci.hasNext()) {
                Felg c = ci.next();
                felgs.add(c);
                System.out.println(c.getNavn());
                System.out.println(c.getPris());
            }
        }
        return felgs;
    }
    //load Settetrekk_data
    public List<Settetrekk> load_Settetrekk_List() {
        List<KomponentsPriser> komponentsPrisers = loadPriser();
        List<Settetrekk> settetrekks = new ArrayList<>();
        Iterator<KomponentsPriser> i = komponentsPrisers.iterator();
        while (i.hasNext()) {
            KomponentsPriser f = i.next();
            System.out.println("KomponentsPriser: " + f.getSettetrekk());
            System.out.println("Settetrekk:");
            if (f.getSettetrekk()==null){return settetrekks;}
            Iterator<Settetrekk> ci = f.getSettetrekk().iterator();
            while (ci.hasNext()) {
                Settetrekk c = ci.next();
                settetrekks.add(c);
                System.out.println(c.getNavn());
                System.out.println(c.getPris());
            }
        }
        return settetrekks;
    }
    //load Ratt_type_data
    public List<Ratt_type> load_Ratt_type_List() {
        List<KomponentsPriser> komponentsPrisers = loadPriser();
        List<Ratt_type> ratt_types = new ArrayList<>();
        Iterator<KomponentsPriser> i = komponentsPrisers.iterator();
        while (i.hasNext()) {
            KomponentsPriser f = i.next();
            System.out.println("KomponentsPriser: " + f.getRatt_type());
            System.out.println("Ratt_type:");
            if (f.getRatt_type()==null){return ratt_types;}
            Iterator<Ratt_type> ci = f.getRatt_type().iterator();
            while (ci.hasNext()) {
                Ratt_type c = ci.next();
                ratt_types.add(c);
                System.out.println(c.getNavn());
                System.out.println(c.getPris());
            }
        }
        return ratt_types;
    }

    //load Spoiler_data
    public List<Spoiler> load_Spoiler_List() {
        List<KomponentsPriser> komponentsPrisers = loadPriser();
        List<Spoiler> spoilers = new ArrayList<>();
        Iterator<KomponentsPriser> i = komponentsPrisers.iterator();
        while (i.hasNext()) {
            KomponentsPriser f = i.next();
            System.out.println("KomponentsPriser: " + f.getSpoiler());
            System.out.println("Spoiler:");
            if (f.getSpoiler()==null){return spoilers;}
            Iterator<Spoiler> ci = f.getSpoiler().iterator();
            while (ci.hasNext()) {
                Spoiler c = ci.next();
                spoilers.add(c);
                System.out.println(c.getNavn());
                System.out.println(c.getPris());
            }
        }
        return spoilers;
    }

    //load Farge_data
    public List<Farge> load_Farge_List() {
        List<KomponentsPriser> komponentsPrisers = loadPriser();
        List<Farge> farges = new ArrayList<>();
        Iterator<KomponentsPriser> i = komponentsPrisers.iterator();
        while (i.hasNext()) {
            KomponentsPriser f = i.next();
            System.out.println("KomponentsPriser: " + f.getSpoiler());
            System.out.println("Farge:");
            if (f.getFarge()==null){return farges;}
            Iterator<Farge> ci = f.getFarge().iterator();
            while (ci.hasNext()) {
                Farge c = ci.next();
                farges.add(c);
                System.out.println(c.getNavn());
                System.out.println(c.getPris());
            }
        }
        return farges;
    }
    public double loadIntegratedGPS(){
        try {
             double integratedGPS=loadPriser().iterator().next().getIntegratedGPS();
             return integratedGPS;
        } catch (NoSuchElementException e){}
        return (double) Double.parseDouble(String.valueOf(0));
    }
    public double loadSoltak(){
        try {
            double soltak=loadPriser().iterator().next().getSoltak();
            return soltak;
        }catch (NoSuchElementException e){}
        return Double.parseDouble(String.valueOf(0));
    }
    public double loadHegefester(){
        try {
            double hegefester=loadPriser().iterator().next().getHegefester();
            return hegefester;
        }catch (NoSuchElementException e){}
        return Double.parseDouble(String.valueOf(0));
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

    //get Bil Type Pris
    public double getBilTypePris(String navn){
         List<Bil_type>bil_types=load_Bil_Type_List();
         for (int i = 0; i<bil_types.size(); i++)
         {
             if (bil_types.get(i).getNavn().matches(navn))
             {
              return bil_types.get(i).getPris();
             }
         }
         return 0;
    }
    //get Farge Pris
    public double getFargePris(String navn){
        List<Farge>farges=load_Farge_List();
        for (int i = 0; i<farges.size(); i++)
        {
            if (farges.get(i).getNavn().matches(navn))
            {
                return farges.get(i).getPris();
            }
        }
        return 0;
    }
    //get Felg Pris
    public double getFelgPris(String navn){
        List<Felg>felgs=load_Felg_List();
        for (int i = 0; i<felgs.size(); i++)
        {
            if (felgs.get(i).getNavn().matches(navn))
            {
                return felgs.get(i).getPris();
            }
        }
        return 0;
    }
    //get Hestkrefter Pris
    public double getHestkrefterPris(String navn){
        List<Hestkrefter>hestkrefters=load_Hestkrefter_List();
        for (int i = 0; i<hestkrefters.size(); i++)
        {
            if (hestkrefters.get(i).getNavn().matches(navn))
            {
                return hestkrefters.get(i).getPris();
            }
        }
        return 0;
    }
    //get Ratt_type Pris
    public double getRatt_typePris(String navn){
        List<Ratt_type>ratt_types=load_Ratt_type_List();
        for (int i = 0; i<ratt_types.size(); i++)
        {
            if (ratt_types.get(i).getNavn().matches(navn))
            {
                return ratt_types.get(i).getPris();
            }
        }
        return 0;
    }
    //get Settetrekk Pris
    public double getSettetrekkPris(String navn){
        List<Settetrekk>settetrekks=load_Settetrekk_List();
        for (int i = 0; i<settetrekks.size(); i++)
        {
            if (settetrekks.get(i).getNavn().matches(navn))
            {
                return settetrekks.get(i).getPris();
            }
        }
        return 0;
    }
    //get Spoiler Pris
    public double getSpoilerPris(String navn){
        List<Spoiler>spoilers=load_Spoiler_List();
        for (int i = 0; i<spoilers.size(); i++)
        {
            if (spoilers.get(i).getNavn().matches(navn))
            {
                return spoilers.get(i).getPris();
            }
        }
        return 0;
    }

    public void lagreProdukt(Produkt produkt) {
    }
}




