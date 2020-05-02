package bilInfo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class BilInfo implements Serializable {

    //default serialVersion id
    private static final long serialVersionUID = 1L;

    private Date RegDato;
    private int bilId;
    private String bil_type;

    private double hestkrefter;
    private String felg;
    private String settetrekk;
    private String ratt_type;
    private String spoiler;

    private String farge;
    private boolean integratedGPS;
    private boolean soltak;
    private boolean hegefester;

    public BilInfo(){}

    public BilInfo(Date regDato, int bilId, String bil_type, double hestkrefter, String felg, String settetrekk, String ratt_type, String spoiler, String farge, boolean integratedGPS, boolean soltak, boolean hegefester) {
        RegDato = regDato;
        this.bilId = bilId;
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

    public Date getRegDato() {
        return RegDato;
    }

    public void setRegDato(Date regDato) {
        RegDato = regDato;
    }

    public int getBilId() {
        return bilId;
    }

    public void setBilId(int bilId) {
        this.bilId = bilId;
    }

    public String getBil_type() {
        return bil_type;
    }

    public void setBil_type(String bil_type) {
        this.bil_type = bil_type;
    }

    public double getHestkrefter() {
        return hestkrefter;
    }

    public void setHestkrefter(double hestkrefter) {
        this.hestkrefter = hestkrefter;
    }

    public String getFelg() {
        return felg;
    }

    public void setFelg(String felg) {
        this.felg = felg;
    }

    public String getSettetrekk() {
        return settetrekk;
    }

    public void setSettetrekk(String settetrekk) {
        this.settetrekk = settetrekk;
    }

    public String getRatt_type() {
        return ratt_type;
    }

    public void setRatt_type(String ratt_type) {
        this.ratt_type = ratt_type;
    }

    public String getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(String spoiler) {
        this.spoiler = spoiler;
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }

    public boolean isIntegratedGPS() {
        return integratedGPS;
    }

    public void setIntegratedGPS(boolean integratedGPS) {
        this.integratedGPS = integratedGPS;
    }

    public boolean isSoltak() {
        return soltak;
    }

    public void setSoltak(boolean soltak) {
        this.soltak = soltak;
    }

    public boolean isHegefester() {
        return hegefester;
    }

    public void setHegefester(boolean hegefester) {
        this.hegefester = hegefester;
    }


    @Override
    public String toString() {
        return "BilInfo{" +
                "RegDato=" + RegDato +
                ", bilId=" + bilId +
                ", bil_type='" + bil_type + '\'' +
                ", hestkrefter=" + hestkrefter +
                ", felg='" + felg + '\'' +
                ", settetrekk='" + settetrekk + '\'' +
                ", ratt_type='" + ratt_type + '\'' +
                ", spoiler='" + spoiler + '\'' +
                ", farge='" + farge + '\'' +
                ", integratedGPS=" + integratedGPS +
                ", soltak=" + soltak +
                ", hegefester=" + hegefester +
                '}';
    }
}
