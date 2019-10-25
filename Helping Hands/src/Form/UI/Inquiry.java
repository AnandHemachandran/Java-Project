package Form.UI;

import Form.Model.Rescuer;
import Form.Model.Victim;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
        JComboBox<String> cb;
        JComboBox<String> cb2;
        DefaultTableModel model = new DefaultTableModel();;
        DefaultTableModel rmodel = new DefaultTableModel();;

        public Inquiry(String s)

    {
        super(s);
        init();
    }

    public void init()

    {

        JScrollPane scrollPane = new JScrollPane(jt);


        JButton b3 = new JButton("Filter");
        String list[] = {"Input Region","Trivandrum","Kollam","Alappuzha","Pathanamthitta","Kottayam","Idukki","Ernakulam","Thrissur","Palakkad","Malappuram","Kozhikode","Wayanadu","Kannur","Kasaragod"};
        cb = new JComboBox(list);
        String list2[] = {"Category","Victim","Rescuer"};
        cb2 = new JComboBox(list2);
        String[] columnNames = { "Name", "Age", "Location","Phone No." };

        cb2.setBounds(20,140,200,30);
        cb.setBounds(20,50,200,30);
        b3.setBounds(20,340,200,40);
        scrollPane.setBounds(300, 50, 550, 500);
        jt.setBorder(new LineBorder(null));

        model.addColumn("Name");
        model.addColumn("Address");
        model.addColumn("Contact No.");
        model.addColumn("Check");
        model.addColumn("Region");

        rmodel.addColumn("Name");
        rmodel.addColumn("Contact No.");
        rmodel.addColumn("Region");
        rmodel.addColumn("Active");

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cb2.getSelectedItem() == "Victim") {
                    jt.setModel(model);
                    showVicitm();

                }else if(cb2.getSelectedItem() == "Rescuer"){

                    jt.setModel(rmodel);
                    showRescuer();
                }
            }
        });

        model.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                remodel(e);
            }
        });

//        if (jt.getCellEditor() != null) {
//            jt.getCellEditor().stopCellEditing();
//
//        }

        add(cb2);
        add(cb);
        add(b3);
        getContentPane().add(scrollPane);
        setSize(950,600);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }

        public ArrayList<Victim> victimList(){
            ArrayList<Victim> victims = new ArrayList<>();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/victim", "root", "root"); //Connecting MySQL to java via JDBC API.
                String query = "";
                ResultSet rs;
                String reg = (String)cb.getSelectedItem();

                if(cb.getSelectedItem() == "Input Region") {
                    query = "SELECT * FROM Victims";
                    Statement st = con.createStatement();
                    rs = st.executeQuery(query);
                }
                else {
                    query = "SELECT * FROM Victims WHERE region like ? ";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1, reg+"");
                    System.out.println(preparedStmt);
                    rs = preparedStmt.executeQuery();
                }

                Victim victim;
                while(rs.next()){
                    victim =new Victim(rs.getString("name"),rs.getString("mobile"),rs.getString("address"),rs.getBoolean("completed"),rs.getString("region"));
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
            model.setRowCount(0);
            Object[] row = new Object[5];
            for(int i=0;i<list.size();i++){
                row[0]=list.get(i).getName();
                row[1]=list.get(i).getContactno();
                row[2]=list.get(i).getLocation();
                row[3]=list.get(i).getCheck();
                row[4]=list.get(i).getRegion();
                model.addRow(row);
            }

        }


        public ArrayList<Rescuer> rescuerList(){
            ArrayList<Rescuer> rescuers = new ArrayList<>();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rescuer", "root", "root"); //Connecting MySQL to java via JDBC API.

                String query = "";
                ResultSet rs1;
                String reg = (String)cb.getSelectedItem();

                if(cb.getSelectedItem() == "Input Region") {
                    query = "SELECT * FROM Rescuer";
                    Statement st = con.createStatement();
                    rs1 = st.executeQuery(query);
                }
                else {
                    query = "SELECT * FROM Rescuer WHERE region like ? ";
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1, reg+"");
                    System.out.println(preparedStmt);
                    rs1 = preparedStmt.executeQuery();
                }

                Rescuer rescuer;
                while(rs1.next()){
                    rescuer =new Rescuer(rs1.getString("name"),rs1.getString("region"),rs1.getString("phone"),rs1.getBoolean("active"));
                    rescuers.add(rescuer);
                }
            }
            catch(Exception e1){
                System.out.println(e1);
            }
            return rescuers;
        }

        public void showRescuer(){
            ArrayList<Rescuer> list = rescuerList();
            DefaultTableModel rmodel = (DefaultTableModel)jt.getModel();
            rmodel.setRowCount(0);
            Object[] row = new Object[5];
            for(int i=0;i<list.size();i++){
                row[0]=list.get(i).getName();
                row[1]=list.get(i).getContactno();
                row[2]=list.get(i).getRegion();
                row[3]=list.get(i).getCheck();
                rmodel.addRow(row);
            }

        }

        protected void remodel(TableModelEvent e){
            if (e.getType() == TableModelEvent.UPDATE) {
                model = (DefaultTableModel)e.getSource();
                int r = e.getFirstRow();
                int c = e.getColumn();
            }
            System.out.println("Table Changes");

            //Work in Progress
            //Implements the code to get the change in the Jtable model to directly change the data in the SQL,
            //which can later affect the model using the victimList() or the rescuerList() correspondingly.
        }




    }

