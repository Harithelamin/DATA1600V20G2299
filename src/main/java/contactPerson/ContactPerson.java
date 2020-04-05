package contactPerson;

import java.io.Serializable;
import java.sql.Date;


public class ContactPerson implements Serializable {

    //default serialVersion id
    private static final long serialVersionUID = 1;

    private int personId;
    private Date createdOn;
    private String fullName;
    private String mobileNo;
    private String email;
    private String address;
    private String website;
    private String affiliation;
    private String otherInfo;

    public ContactPerson() {
    }

    public ContactPerson(int personId, Date createdOn, String fullName, String mobileNo, String email, String address, String website, String affiliation, String otherInfo) {
        this.personId = personId;
        this.createdOn = createdOn;
        this.fullName = fullName;
        this.mobileNo = mobileNo;
        this.email = email;
        this.address = address;
        this.website = website;
        this.affiliation = affiliation;
        this.otherInfo = otherInfo;
    }

    public ContactPerson(ContactPerson contactPerson) {
        super();
    }


    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "ContactPerson{" +
                "personId=" + personId +
                ", createdOn=" + createdOn +
                ", fullName='" + fullName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", website='" + website + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", otherInfo='" + otherInfo + '\'' +
                '}';
    }
}
