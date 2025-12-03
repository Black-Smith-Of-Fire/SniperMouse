package org.blacksmith;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


public class TransparentWindow {

    public static void click(int x, int y) throws AWTException{
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setOpacity(0.1f);
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        System.out.println(bounds.width);

        JPanel p = new JPanel() {
            // paint the panel
            public void paintComponent(Graphics g) {
               /*
                                     0
                                     |  +
                                     |  +
              ++++++++ width/2 ++++++|  height/2
                                     |  +
                                     |  +
             0 ______________________|________________________
                                     |
                                     |
                                     |
                                     |
                                     |
                                     |
               */
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g2.setColor(Color.RED);
                //                  start_X,  start|Y, end_X, end|Y
                // level 1
//                g2.drawLine(bounds.width/2,0,bounds.width/2,bounds.height); // vertical long line
//                g2.drawLine(0,bounds.height/2,bounds.width,bounds.height/2);// horizontal long line
//
//                // level 2
//                g2.setColor(new Color(0,100,0));
//                g2.drawLine(bounds.width/4,0,bounds.width/4,bounds.height/2); // vertical sub line
//                g2.drawLine(0,bounds.height/4,bounds.width/2,bounds.height/4);// horizontal sub line
//
//                // level 3
                g2.setColor(new Color(0,0,0));
//                g2.drawLine(bounds.width/8,0,bounds.width/8,bounds.height/4); // vertical sub line
//                g2.drawLine(0,bounds.height/12,bounds.width/4,bounds.height/12);// horizontal sub line
//                g2.drawLine(bounds.width/16,0,bounds.width/16,bounds.height/4); // vertical sub line
//                g2.drawLine(0,2 * bounds.height/12,bounds.width/4,2 * bounds.height/12);// horizontal sub line
//                g2.drawLine(3 * bounds.width/16,0,3* bounds.width/16,bounds.height/4); // vertical sub line
//                g2.drawLine(bounds.width/12,0,bounds.width/12,bounds.height/4); // vertical sub line

                g2.drawOval(bounds.width/2,bounds.height/2, 100,100);
                g2.drawOval(bounds.width/2 + 10,bounds.height/2 + 10, 80,80);
                g2.drawLine(bounds.width/2 + 50,bounds.height/2 + 10, bounds.width/2 + 50,bounds.height/2 + 90); // vertical sub line
                g2.drawLine(bounds.width/2 + 10,bounds.height/2 + 50, bounds.width/2 + 90,bounds.height/2 + 50); // vertical sub line

            }
        };

        frame.add(p);
        frame.setVisible(true);

        // clicking the button


    }
}