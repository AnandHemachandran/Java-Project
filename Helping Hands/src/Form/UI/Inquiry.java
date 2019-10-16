package Form.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Inquiry extends JFrame
    {
        JFrame f;
        JTable j;
        boolean flag = true;
        String error = "";
        int input =0;

    public Inquiry(String s)

    {
        super(s);
        init();
    }

    public void init()

    {
        JLabel l1 = new JLabel("Input Region");
        JButton b1 = new JButton("Victim");
        JButton b2 = new JButton("Rescuer");
        JButton b3 = new JButton("Assign");
        String list[] = {"Select","TVM","PTA"};
        JComboBox<String> cb = new JComboBox(list);
        String[] columnNames = { "Name", "Age", "Location","phone No" };
        j=new JTable(21,4);
        JScrollPane sp = new JScrollPane(j);


        l1.setBounds(20,50,150,20);
        cb.setBounds(150,50,150,20);
        b1.setBounds(20,140,200,40);
        b2.setBounds(20,190,200,40);
        b3.setBounds(20,240,200,40);
        j.setBounds(240, 140, 200, 300);


        add(l1);
        add(cb);
        add(b1);
        add(b2);
        add(b3);
        add(j);



        setLocationRelativeTo(null);
        setSize(400,500);
        setLayout(null);
        setVisible(true);


    }
}
