package Model;

/**
 * Agency class represents an adoption agency entity in the system.
 */
public class Agency {
    private int agencyno;
    private String agencyName;
    private String emailId;
    private int numAdoptedKids;
    private int numInhouseKids;
    private String ph;
    private String location;
    private String address;

    public int getAgencyNo() {
        return agencyno;
    }

    public void setAgencyNo(int agencyno) {
        this.agencyno = agencyno;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getNumAdoptedKids() {
        return numAdoptedKids;
    }

    public void setNumAdoptedKids(int numAdoptedKids) {
        this.numAdoptedKids = numAdoptedKids;
    }

    public int getNumInhouseKids() {
        return numInhouseKids;
    }

    public void setNumInhouseKids(int numInhouseKids) {
        this.numInhouseKids = numInhouseKids;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
