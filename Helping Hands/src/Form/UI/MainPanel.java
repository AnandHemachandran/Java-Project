package Form.UI;

import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainPanel extends JFrame {

    public MainPanel(String s)
    {
        super(s);
        init();
    }
    public void init()
    {
        JPanel panel = new JPanel();
        panel.setBounds(50,75,450,350);
        panel.setLayout(null);

        JButton b1 = new JButton("Register");
        b1.setBorder(new RoundedBorder(20));
        b1.setBackground(new Color(0x2dce98));
        b1.setFont(new java.awt.Font("Product Sans", 2, 28));
        b1.setBounds(120,80,200,80);


        JButton b2 = new JButton("Inquiry");
        b2.setBorder(new RoundedBorder(20));
        b2.setBackground(new Color(0x1976d2));
        b2.setFont(new java.awt.Font("Product Sans", 2, 28));
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


        panel.add(b1);
        panel.add(b2);
        BufferedImage image;
        try {
            image = ImageIO.read(new File("./src/Form/UI/Logo.jpeg"));
        }
        catch (IOException ex) {
            image = null;
            System.out.println("You did't get the image");
        }


        JLabel label = new JLabel(new ImageIcon(image));
        label.setBounds(550,60,400,400);
        add(label);
        add(panel);


        setSize(1000,540);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x313131));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
