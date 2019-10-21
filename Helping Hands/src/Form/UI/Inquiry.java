package Form.UI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class Inquiry extends JFrame
    {

    public Inquiry(String s)

    {
        super(s);
        init();
    }

    public void init()

    {
        JTable jt = new JTable();
        JScrollPane scrollPane = new JScrollPane(jt);

        JLabel l1 = new JLabel("Input Region");
        JButton b1 = new JButton("Victim");
        JButton b2 = new JButton("Rescuer");
        JButton b3 = new JButton("Assign");
        String list[] = {"Select","TVM","PTA"};
        JComboBox<String> cb = new JComboBox(list);
        String[] columnNames = { "Name", "Age", "Location","Phone No." };

        l1.setBounds(20,50,150,20);
        cb.setBounds(150,50,150,20);
        b1.setBounds(20,140,200,40);
        b2.setBounds(20,190,200,40);
        b3.setBounds(20,240,200,40);
        scrollPane.setBounds(240, 140, 200, 300);
        jt.setBorder(new LineBorder(null));
        DefaultTableModel model = new DefaultTableModel();
        jt.setModel(model);
        model.addColumn("Name");
        model.addColumn("Contact Info.");
        model.addColumn("Address");
        model.addColumn("Check");
        Object[] newRowData = {5,5,5,5};



        model.addRow(newRowData);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/victims", "root", "root"); //Connecting MySQL to java via JDBC API.
            Statement stmt = con.createStatement();
        }
        catch(Exception e1){
            System.out.println(e1);
        }

        add(l1);
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
}
