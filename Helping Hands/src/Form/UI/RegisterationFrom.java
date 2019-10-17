package Form.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            JTextField tf = new JTextField();
            JTextField pw = new JTextField();
            JTextField pwc = new JTextField();
            JTextField ag = new JTextField();

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

            String list[] = {"Select","Victim","Rescurer"};
            JComboBox<String> cb = new JComboBox(list);
            JRadioButton r1 = new JRadioButton("A. Male");
            r1.setFont(new java.awt.Font("Work Sans", 2, 15));

            JRadioButton r2 = new JRadioButton("B. Female");
            r2.setFont(new java.awt.Font("Work Sans", 2, 15));

            ButtonGroup bG = new ButtonGroup();
            bG.add(r1);
            bG.add(r2);

            JButton b = new JButton("Select");
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
            tf.setBounds(150,50,150,20);
            pw.setBounds(150,80,150,20);
            pwc.setBounds(150,110,150,20);
            ag.setBounds(150,140,150,20);
            cb.setBounds(150,170,150,20);
            r1.setBounds(150,200,110,20);
            r2.setBounds(260,200,110,20);


            b.setBounds(20,260,160,30);
            b1.setBounds(200,260,160,30);
            l7.setBounds(10,290,450,20);
            b.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(tf.getText().isBlank()) {
                        error=error+" Username Empty ";
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
                    tf.setText("");
                    pw.setText("");
                    pwc.setText("");
                    cb.setSelectedIndex(0);

                    l7.setText("");
                }
            });

            add(tf);
            add(l1);
            add(l2);
            add(pw);
            add(l3);
            add(pwc);
            add(l4);
            add(cb);
            add(l5);
            add(l6);
            add(ag);
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

