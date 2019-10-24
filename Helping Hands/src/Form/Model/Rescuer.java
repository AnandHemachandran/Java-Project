package Form.Model;

public class Rescuer {

    private int id;
    private String name,region,contactno;
    boolean active;
    public Rescuer() {}
    public Rescuer(String name, String region, String contactno, boolean active) {
        this.name = name;
        this.region = region;
        this.contactno = contactno;
        this.active = active;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String location) {
        this.region = location;
    }
    public String getContactno() {
        return contactno;
    }
    public void setContactno(String contactno) {
        this.contactno = contactno;
    }
    public boolean getCheck() {
        return active;
    }
    public void setCheck(boolean com) {
        this.active = com;
    }
}
