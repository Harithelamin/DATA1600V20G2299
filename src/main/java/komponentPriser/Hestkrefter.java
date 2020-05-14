package komponentPriser;

import java.io.Serializable;

public class Hestkrefter implements Serializable {
    public String navn;
    public double pris;
    public Hestkrefter(){this.navn=""; this.pris=0.00;}

    public Hestkrefter(String navn, double pris) {
        this.navn=navn;
        this.pris=pris;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return "Hestkrefter{" +
                "navn='" + navn + '\'' +
                ", pris=" + pris +
                '}';
    }
}
