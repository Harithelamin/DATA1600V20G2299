package bilInfo;

import java.io.Serializable;
import java.util.Date;

public class Bestilling implements Serializable {
    private Date bestillingDato;
    private BilInfo bilInfo;
    private double kPris;
    private double mVA;
    private double tPris;

    public Bestilling() {}

    public Bestilling(Date bestillingDato, BilInfo bilInfo, double kPris, double mVA, double tPris) {
        this.bestillingDato = bestillingDato;
        this.bilInfo = bilInfo;
        this.kPris = kPris;
        this.mVA = mVA;
        this.tPris = tPris;
    }

    public Date getBestillingDato() {
        return bestillingDato;
    }

    public void setBestillingDato(Date bestillingDato) {
        this.bestillingDato = bestillingDato;
    }

    public BilInfo getBilInfo() {
        return bilInfo;
    }

    public void setBilInfo(BilInfo bilInfo) {
        this.bilInfo = bilInfo;
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
}
