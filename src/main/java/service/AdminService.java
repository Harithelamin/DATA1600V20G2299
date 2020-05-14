package service;


import bilInfo.BilInfo;
import komponentPriser.*;

import java.io.IOException;
import java.util.List;

public interface AdminService {
    public void saveComponentsPrices(KomponentsPriser komponentsPriser) throws IOException, ClassNotFoundException;
    public List<KomponentsPriser> loadPriser();
    public List<Bil_type> load_Bil_Type_List();
    public List<Hestkrefter> load_Hestkrefter_List();
    public List<Felg> load_Felg_List();
    public List<Settetrekk> load_Settetrekk_List();
    public List<Ratt_type> load_Ratt_type_List();
    public List<Spoiler> load_Spoiler_List();
    public List<Farge> load_Farge_List();
    public double loadIntegratedGPS();
    public double loadSoltak();
    public double loadHegefester();
    public double getBilTypePris(String navn);
    public double getFargePris(String navn);
    public double getFelgPris(String navn);
    public double getHestkrefterPris(String navn);
    public double getRatt_typePris(String navn);
    public double getSettetrekkPris(String navn);
    public double getSpoilerPris(String navn);
}
