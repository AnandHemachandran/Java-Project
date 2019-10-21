package Form.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class RegisterationFrom extends JFrame {
        JFrame f;
        boolean flag = true;
        String error = "";
        int input =0;

        public RegisterationFrom(String s){
            super(s);
            init();
        }
        public void init() {
            JTextField name = new JTextField();
            JTextField location = new JTextField();
            JTextField phone = new JTextField();
            JTextField age = new JTextField();

            JLabel l1 = new JLabel("Name");
            l1.setFont(new java.awt.Font("Work Sans", 3, 15));

            JLabel l2 = new JLabel("Location");
            l2.setFont(new java.awt.Font("Work Sans", 3, 15));

            JLabel l3 = new JLabel("Phone Number");
            l3.setFont(new java.awt.Font("Work Sans", 3, 15));

            JLabel l4 = new JLabel("Category");
            l4.setFont(new java.awt.Font("Work Sans", 3, 15));

            JLabel l5 = new JLabel("Gender");
            l5.setFont(new java.awt.Font("Work Sans", 3, 15));

            JLabel l6 = new JLabel("Age");
            l6.setFont(new java.awt.Font("Work Sans", 3, 15));

            JLabel l7 = new JLabel("");
            l7.setFont(new java.awt.Font("Work Sans", 3, 15));

            String list[] = {"Select","Victim","Rescuer"};
            JComboBox<String> cb = new JComboBox(list);
            JRadioButton r1 = new JRadioButton("A. Male");
            r1.setFont(new java.awt.Font("Work Sans", 2, 15));

            JRadioButton r2 = new JRadioButton("B. Female");
            r2.setFont(new java.awt.Font("Work Sans", 2, 15));

            ButtonGroup bG = new ButtonGroup();
            bG.add(r1);
            bG.add(r2);

            JButton b = new JButton("Register");
            b.setFont(new java.awt.Font("Work Sans", 1, 18));
            b.setBorder(new RoundedBorder(10));


            JButton b1 = new JButton("Cancel");
            b1.setFont(new java.awt.Font("Work Sans", 1, 18));
            b1.setBorder(new RoundedBorder(10));


            l1.setBounds(20,50,150,20);
            l2.setBounds(20,80,150,20);
            l3.setBounds(20,110,150,20);
            l4.setBounds(20,170,150,20);
            l5.setBounds(20,200,150,20);
            l6.setBounds(20,140,150,20);
            name.setBounds(150,50,150,20);
            location.setBounds(150,80,150,20);
            phone.setBounds(150,110,150,20);
            age.setBounds(150,140,150,20);
            cb.setBounds(150,170,150,20);
            r1.setBounds(150,200,110,20);
            r2.setBounds(260,200,110,20);


            b.setBounds(20,260,160,30);
            b1.setBounds(200,260,160,30);
            l7.setBounds(10,290,450,20);
            b.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(name.getText().isBlank()) {
                        error=error+" Name Empty ";
                        flag=false;
                    }
                    else {
                        flag = true;
                    }
                    if(flag) {
                        JOptionPane.showMessageDialog(f,"Successfully Updated.");
                    }
                    else {
                        l7.setText(error);
                    }

                }
            });

            b1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    name.setText("");
                    location.setText("");
                    phone.setText("");
                    cb.setSelectedIndex(0);

                    l7.setText("");
                }
            });

            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String n = name.getText();
                    String loc = location.getText();
                    String phoneno = phone.getText();
                    String category = (String)(cb.getSelectedItem());
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/victim", "root", "root");
                        Statement statement = con.createStatement();

                        String query ="";
                        if(category == "Victim"){
                            query = "INSERT INTO Victims VALUES ( ? , ? , ? , 1 );";
                        }
                        PreparedStatement preparedStmt;
                        if(query != "") {
                            preparedStmt = con.prepareStatement(query);
                            preparedStmt.setString (1,n);
                            preparedStmt.setString (2,phoneno);
                            preparedStmt.setString (3,loc);

                            preparedStmt.executeUpdate();

                        }


                    }
                    catch(Exception e1){
                        System.out.println(e1);
                    }
                }
            });




            add(name);
            add(l1);
            add(l2);
            add(location);
            add(l3);
            add(phone);
            add(l4);
            add(cb);
            add(l5);
            add(l6);
            add(age);
            add(r1);
            add(r2);
            add(b);
            add(b1);
            add(l7);
            setSize(400,500);
            setLocationRelativeTo(null);
            setLayout(null);
            setVisible(true);

        }

    }

