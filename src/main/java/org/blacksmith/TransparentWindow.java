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


    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
//            click();
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setOpacity(0.1f);
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();

        JPanel p = new JPanel() {
            // paint the panel
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g2.setColor(Color.RED);
                g2.drawLine(bounds.width/2,0,bounds.width/2,bounds.height);
                g2.drawLine(0,bounds.height/2,bounds.width,bounds.height/2);
            }
        };

        frame.add(p);
        frame.setVisible(true);

        // clicking the button


    }
}