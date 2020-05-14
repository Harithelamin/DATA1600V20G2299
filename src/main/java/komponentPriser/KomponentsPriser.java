package komponentPriser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class KomponentsPriser implements Serializable {

    //default serialVersion id
    private static final long serialVersionUID = 1L;

    private Date priserDato;

    private ArrayList<Bil_type> bil_type;
    private ArrayList<Hestkrefter> hestkrefter;
    private ArrayList<Felg> felg;
    private ArrayList<Settetrekk> settetrekk;
    private ArrayList<Ratt_type> ratt_type;
    private ArrayList<Spoiler> spoiler;

    private ArrayList<Farge> farge;
    private double integratedGPS;
    private double soltak;
    private double hegefester;

    public KomponentsPriser() {
    }

    public KomponentsPriser(Date priserDato, ArrayList<Bil_type> bil_type, ArrayList<Hestkrefter> hestkrefter, ArrayList<Felg> felg, ArrayList<Settetrekk> settetrekk, ArrayList<Ratt_type> ratt_type, ArrayList<Spoiler> spoiler, ArrayList<Farge> farge, double integratedGPS, double soltak, double hegefester) {
        this.priserDato = priserDato;
        this.bil_type = bil_type;
        this.hestkrefter = hestkrefter;
        this.felg = felg;
        this.settetrekk = settetrekk;
        this.ratt_type = ratt_type;
        this.spoiler = spoiler;
        this.farge = farge;
        this.integratedGPS = integratedGPS;
        this.soltak = soltak;
        this.hegefester = hegefester;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getPriserDato() {
        return priserDato;
    }

    public void setPriserDato(Date priserDato) {
        this.priserDato = priserDato;
    }

    public ArrayList<Bil_type> getBil_type() {
        return bil_type;
    }

    public void setBil_type(ArrayList<Bil_type> bil_type) {
        this.bil_type = bil_type;
    }

    public ArrayList<Hestkrefter> getHestkrefter() {
        return hestkrefter;
    }

    public void setHestkrefter(ArrayList<Hestkrefter> hestkrefter) {
        this.hestkrefter = hestkrefter;
    }

    public ArrayList<Felg> getFelg() {
        return felg;
    }

    public void setFelg(ArrayList<Felg> felg) {
        this.felg = felg;
    }

    public ArrayList<Settetrekk> getSettetrekk() {
        return settetrekk;
    }

    public void setSettetrekk(ArrayList<Settetrekk> settetrekk) {
        this.settetrekk = settetrekk;
    }

    public ArrayList<Ratt_type> getRatt_type() {
        return ratt_type;
    }

    public void setRatt_type(ArrayList<Ratt_type> ratt_type) {
        this.ratt_type = ratt_type;
    }

    public ArrayList<Spoiler> getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(ArrayList<Spoiler> spoiler) {
        this.spoiler = spoiler;
    }

    public ArrayList<Farge> getFarge() {
        return farge;
    }

    public void setFarge(ArrayList<Farge> farge) {
        this.farge = farge;
    }

    public double getIntegratedGPS() {
        return integratedGPS;
    }

    public void setIntegratedGPS(double integratedGPS) {
        this.integratedGPS = integratedGPS;
    }

    public double getSoltak() {
        return soltak;
    }

    public void setSoltak(double soltak) {
        this.soltak = soltak;
    }

    public double getHegefester() {
        return hegefester;
    }

    public void setHegefester(double hegefester) {
        this.hegefester = hegefester;
    }

    @Override
    public String toString() {
        return "KomponentsPriser{" +
                "priserDato=" + priserDato +
                ", bil_type=" + bil_type +
                ", hestkrefter=" + hestkrefter +
                ", felg=" + felg +
                ", settetrekk=" + settetrekk +
                ", ratt_type=" + ratt_type +
                ", spoiler=" + spoiler +
                ", farge=" + farge +
                ", integratedGPS=" + integratedGPS +
                ", soltak=" + soltak +
                ", hegefester=" + hegefester +
                '}';
    }
}
