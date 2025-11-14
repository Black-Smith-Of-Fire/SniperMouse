package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class TransparentWindow extends JFrame {

    public static void main(String[] args) {
        GraphicsEnvironment graphics =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
//         try block
        try {

            // create a window
            JWindow w = new JWindow();

            // set a transparent  background of the window
            w.setBackground(new Color(0,0,0,0));

            // create a panel
            JPanel p = new JPanel() {

                // paint the panel
                public void paintComponent(Graphics g) {
                    g.setColor(Color.RED);
                    g.drawLine(100,10,100,1000);
                }
            };

            // add panel
            w.add(p);

            // set the location

            w.setLocation(0, 0);

            // set the size of the window
            w.setSize(900, 900);

            // set the visibility of the window
            w.setVisible(true);


            device.setFullScreenWindow(w);
        }
        // catch any exception
        catch (Exception e) {

            // show the error
            System.err.println(e.getMessage());
        }
    }
}