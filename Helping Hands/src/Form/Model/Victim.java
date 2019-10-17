package Form.Model;

public class Victim {

        private int id;
        private String name,location,email,contactno;
        public Victim() {}
        public Victim(String name, String location, String email, String contactno) {
            this.name = name;
            this.location = location;
            this.email = email;
            this.contactno = contactno;
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
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getContactno() {
            return contactno;
        }
        public void setContactno(String contactno) {
            this.contactno = contactno;
        }
}
