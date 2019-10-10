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
            JLabel l1 = new JLabel("Name");
            JLabel l2 = new JLabel("Location");
            JLabel l3 = new JLabel("Phone Number");
            JLabel l4 = new JLabel("Needs");
            JLabel l5 = new JLabel("Gender");
            JLabel l7 = new JLabel("");
            String country[] = {""};
            JComboBox<String> cb = new JComboBox(country);
            JRadioButton r1 = new JRadioButton("A. Male");
            JRadioButton r2 = new JRadioButton("B. Female");
            ButtonGroup bG = new ButtonGroup();
            bG.add(r1);
            bG.add(r2);
            JButton b = new JButton("Select");
            JButton b1 = new JButton("Cancel");


            l1.setBounds(20,50,150,20);
            l2.setBounds(20,80,150,20);
            l3.setBounds(20,110,150,20);
            l4.setBounds(20,140,150,20);
            l5.setBounds(20,170,150,20);
            tf.setBounds(150,50,150,20);
            pw.setBounds(150,80,150,20);
            pwc.setBounds(150,110,150,20);
            cb.setBounds(150,140,150,20);
            r1.setBounds(150,170,110,20);
            r2.setBounds(260,170,110,20);
            b.setBounds(20,260,120,20);
            b1.setBounds(150,260,120,20);
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

