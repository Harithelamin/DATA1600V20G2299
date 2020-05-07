package bilInfo;

import java.util.Date;

public class Quotation {
    //default serialVersion id
    private static final long serialVersionUID = 1L;

    private Date RegDato;
    private int quotationId;

    private double bil_type;

    private double hestkrefter;
    private double felg;
    private double settetrekk;
    private double ratt_type;
    private double spoiler;

    private double farge;
    private double integratedGPS;
    private double soltak;
    private double hegefester;

    private double mos;
    private double komponentsPris;
    private double totalPris;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getRegDato() {
        return RegDato;
    }

    public void setRegDato(Date regDato) {
        RegDato = regDato;
    }


    public int getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(int quotationId) {
        this.quotationId = quotationId;
    }

    public double getBil_type() {
        return bil_type;
    }

    public void setBil_type(double bil_type) {
        this.bil_type = bil_type;
    }

    public double getHestkrefter() {
        return hestkrefter;
    }

    public void setHestkrefter(double hestkrefter) {
        this.hestkrefter = hestkrefter;
    }

    public double getFelg() {
        return felg;
    }

    public void setFelg(double felg) {
        this.felg = felg;
    }

    public double getSettetrekk() {
        return settetrekk;
    }

    public void setSettetrekk(double settetrekk) {
        this.settetrekk = settetrekk;
    }

    public double getRatt_type() {
        return ratt_type;
    }

    public void setRatt_type(double ratt_type) {
        this.ratt_type = ratt_type;
    }

    public double getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(double spoiler) {
        this.spoiler = spoiler;
    }

    public double getFarge() {
        return farge;
    }

    public void setFarge(double farge) {
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

    public double getMos() {
        return mos;
    }

    public void setMos(double mos) {
        this.mos = mos;
    }

    public double getKomponentsPris() {
        return komponentsPris;
    }

    public void setKomponentsPris(double komponentsPris) {
        this.komponentsPris = komponentsPris;
    }

    public double getTotalPris() {
        return totalPris;
    }

    public void setTotalPris(double totalPris) {
        this.totalPris = totalPris;
    }
}
