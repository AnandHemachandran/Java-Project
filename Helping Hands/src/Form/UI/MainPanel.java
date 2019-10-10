package Form.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JFrame {

    public MainPanel(String s)
    {
        super(s);
        init();
    }
    public void init()
    {
        JButton b1 = new JButton("Register");
        JButton b2 = new JButton("Inquiry");


        b1.setBounds(120,100,200,80);
        b2.setBounds(120,200,200,80);

        b1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                RegisterationFrom l = new RegisterationFrom("Register");
            }
        });

        b2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Inquiry I = new Inquiry("Get Info");
            }
        });

        add(b1);
        add(b2);
        setSize(450,480);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
