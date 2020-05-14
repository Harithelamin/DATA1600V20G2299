package komponentPriser;

import java.io.Serializable;
import java.util.Set;

public class Settetrekk implements Serializable {
    public String navn;
    public double pris;

    public Settetrekk(){this.navn=""; this.pris=0.00;}
    public Settetrekk(String navn, double pris) {
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
        return "Settetrekk{" +
                "navn='" + navn + '\'' +
                ", pris=" + pris +
                '}';
    }
}
