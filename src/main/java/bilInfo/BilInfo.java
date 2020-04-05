package bilInfo;


import java.io.Serializable;
import java.sql.Date;

public class BilInfo implements Serializable {

    //default serialVersion id
    private static final long serialVersionUID = 1;
    private int bilId;
    private Date lageti;   //2006/2015/2020
    private String bilName;
    private String bilMarka;


    private String bilFarge;
    private String bilEnergi;   //bensin/diesel/el
    private float bilPrise;

    public BilInfo(int bilId, Date lageti, String bilName, String bilMarka, String bilFarge, String bilEnergi, float bilPrise) {
        this.bilId = bilId;
        this.lageti = lageti;
        this.bilName = bilName;
        this.bilMarka = bilMarka;
        this.bilFarge = bilFarge;
        this.bilEnergi = bilEnergi;
        this.bilPrise = bilPrise;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getBilId() {
        return bilId;
    }

    public void setBilId(int bilId) {
        this.bilId = bilId;
    }

    public Date getLageti() {
        return lageti;
    }

    public void setLageti(Date lageti) {
        this.lageti = lageti;
    }

    public String getBilName() {
        return bilName;
    }

    public void setBilName(String bilName) {
        this.bilName = bilName;
    }

    public String getBilMarka() {
        return bilMarka;
    }

    public void setBilMarka(String bilMarka) {
        this.bilMarka = bilMarka;
    }

    public String getBilFarge() {
        return bilFarge;
    }

    public void setBilFarge(String bilFarge) {
        this.bilFarge = bilFarge;
    }

    public String getBilEnergi() {
        return bilEnergi;
    }

    public void setBilEnergi(String bilEnergi) {
        this.bilEnergi = bilEnergi;
    }

    public float getBilPrise() {
        return bilPrise;
    }

    public void setBilPrise(float bilPrise) {
        this.bilPrise = bilPrise;
    }

    @Override
    public String toString() {
        return "BilInfo{" +
                "bilId=" + bilId +
                ", lageti=" + lageti +
                ", bilName='" + bilName + '\'' +
                ", bilMarka='" + bilMarka + '\'' +
                ", bilFarge='" + bilFarge + '\'' +
                ", bilEnergi='" + bilEnergi + '\'' +
                ", bilPrise=" + bilPrise +
                '}';
    }
}

