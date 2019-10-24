package Form.UI;

import Form.Model.Victim;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.State;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;


public class Inquiry extends JFrame
    {
        JTable jt = new JTable();
    public Inquiry(String s)

    {
        super(s);
        init();
    }

    public void init()

    {

        JScrollPane scrollPane = new JScrollPane(jt);

        JButton b1 = new JButton("Victim");
        JButton b2 = new JButton("Rescuer");
        JButton b3 = new JButton("Assign");
        String list[] = {"Input Region","Thiruvananthapuram","Kollam","Alappuzha","Pathanamthitta","Kottayam","Idukki","Ernakulam","Thrissur","Palakkad","Malappuram","Kozhikode","Wayanadu","Kannur","Kasaragod"};
        JComboBox<String> cb = new JComboBox(list);
        String list2[] = {"Category","Victim","Rescurer"};
        JComboBox<String> cb2 = new JComboBox(list2);
        String[] columnNames = { "Name", "Age", "Location","Phone No." };

        cb2.setBounds(20,140,200,30);
        cb.setBounds(20,50,200,30);
        b1.setBounds(20,240,200,40);
        b2.setBounds(20,290,200,40);
        b3.setBounds(20,340,200,40);
        scrollPane.setBounds(240, 140, 200, 300);
        jt.setBorder(new LineBorder(null));
        DefaultTableModel model = new DefaultTableModel();
        jt.setModel(model);
        model.addColumn("Name");
        model.addColumn("Contact Info.");
        model.addColumn("Address");
        model.addColumn("Check");
        showVicitm();

        add(cb2);
        add(cb);
        add(b1);
        add(b2);
        add(b3);

        getContentPane().add(scrollPane);
        setLocationRelativeTo(null);
        setSize(700,500);
        setLayout(null);
        setVisible(true);

    }

        public ArrayList<Victim> victimList(){
            ArrayList<Victim> victims = new ArrayList<>();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/victim", "root", "root"); //Connecting MySQL to java via JDBC API.
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM Victims";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                Victim victim;
                while(rs.next()){
                    victim =new Victim(rs.getString("name"),rs.getString("mobile"),rs.getString("address"),rs.getBoolean("completed"));
                    victims.add(victim);
                }
            }
            catch(Exception e1){
                    System.out.println(e1);
                }
            return victims;
        }

        public void showVicitm(){
            ArrayList<Victim> list = victimList();
            DefaultTableModel model = (DefaultTableModel)jt.getModel();
            Object[] row = new Object[4];
            for(int i=0;i<list.size();i++){
                row[0]=list.get(i).getName();
                row[1]=list.get(i).getContactno();
                row[2]=list.get(i).getLocation();
                row[3]=list.get(i).getCheck();
                model.addRow(row);
            }

        }
}
