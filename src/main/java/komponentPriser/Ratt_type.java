package komponentPriser;

import java.io.Serializable;

public class Ratt_type implements Serializable {
    public String navn;
    public double pris;

    public Ratt_type(){this.navn=""; this.pris=0.00;}

    public Ratt_type(String navn, double pris) {
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
        return "Ratt_type{" +
                "navn='" + navn + '\'' +
                ", pris=" + pris +
                '}';
    }
}
