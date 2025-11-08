package org.blacksmith;

// Java Program to implement the shaped window
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class TransparentWindow extends JFrame {

    // main class
    public static void main(String[] args)
    {
        // try block
        try {

            // create a window
            JWindow w = new JWindow();

            // set a transparent  background of the window
            w.setBackground(Color.BLACK);

            // read the image
            BufferedImage i = ImageIO.read(new File("/home/blacksmithoffire/coding/MouseLess/MouseLess/src/main/resources/Signature.jpeg"));

            // create a panel
            JPanel p = new JPanel() {

                // paint the panel
                public void paintComponent(Graphics g)
                {
                    g.setColor(Color.RED);
                    g.drawLine(100,10,100,1000);
                }
            };

            // add panel
            w.add(p);

            // set the location
            w.setEx
            w.setLocation(0, 0);

            // set the size of the window
            w.setSize(900, 900);

            // set the visibility of the window
            w.setVisible(true);
        }
        // catch any exception
        catch (Exception e) {

            // show the error
            System.err.println(e.getMessage());
        }
    }
}
