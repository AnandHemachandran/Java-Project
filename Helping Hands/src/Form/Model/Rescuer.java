package Form.Model;

public class Rescuer {

    private int id;
    private String name,location,contactno;
    boolean completed;
    public Rescuer() {}
    public Rescuer(String name, String location, String contactno, boolean completed) {
        this.name = name;
        this.location = location;
        this.contactno = contactno;
        this.completed = completed;
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
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getContactno() {
        return contactno;
    }
    public void setContactno(String contactno) {
        this.contactno = contactno;
    }
    public boolean getCheck() {
        return completed;
    }
    public void setCheck(boolean com) {
        this.completed  = com;
    }
}
