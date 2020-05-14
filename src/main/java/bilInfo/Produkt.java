package bilInfo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.Date;

public class Produkt implements Serializable {
    public Date registreringDato;
    public double kPris;
    public double mVA;
    public double tPris;
    public BilInfo bilInfo;

    public Produkt() {
    }

    public Produkt(Date registreringDato, double kPris, double mVA, double tPris, BilInfo bilInfo) {
        this.registreringDato = registreringDato;
        this.kPris = kPris;
        this.mVA = mVA;
        this.tPris = tPris;
        this.bilInfo = bilInfo;
    }

    public Date getRegistreringDato() {
        return registreringDato;
    }

    public void setRegistreringDato(Date registreringDato) {
        this.registreringDato = registreringDato;
    }

    public double getkPris() {
        return kPris;
    }

    public void setkPris(double kPris) {
        this.kPris = kPris;
    }

    public double getmVA() {
        return mVA;
    }

    public void setmVA(double mVA) {
        this.mVA = mVA;
    }

    public double gettPris() {
        return tPris;
    }

    public void settPris(double tPris) {
        this.tPris = tPris;
    }

    public BilInfo getBilInfo() {
        return bilInfo;
    }

    public void setBilInfo(BilInfo bilInfo) {
        this.bilInfo = bilInfo;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "registreringDato=" + registreringDato +
                ", kPris=" + kPris +
                ", mVA=" + mVA +
                ", tPris=" + tPris +
                ", bilInfo=" + bilInfo +
                '}';
    }
}
