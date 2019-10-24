package Form.Model;

public class Victim {

        private int id;
        private String name,location,contactno,region;
        boolean completed;
        public Victim() {}
        public Victim(String name, String location, String contactno, boolean completed, String region) {
            this.name = name;
            this.location = location;
            this.contactno = contactno;
            this.completed = completed;
            this.region = region;
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
        public String getRegion() {
            return region;
        }
        public void setRegion(String location) {
            this.region = region;
        }
}
