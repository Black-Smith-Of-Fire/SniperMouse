package org.blacksmith;
//TODO: Use timer instead of thread

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


public class TransparentWindow extends JFrame implements Runnable, KeyListener {
    Thread t;
    int x = 0;
    int y = 0;
    int originX = 0;
    int originY = 0;
    boolean vim = true;

    public TransparentWindow() {

        // Set frame properties
        setTitle("Animated JFrame");
        setSize(100,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);

        // Setting the shape of the frame to circle
        setShape(new Ellipse2D.Double(0,0,50,50));

        // Set background for the frame's content pane
        getContentPane().setBackground(Color.white);

        // Set opacity, don't make it opaque, that's my wish!
        setOpacity(0.5f);

        JPanel p = new JPanel() {
            // paint the panel
            public void paintComponent(Graphics g) {

                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;

                g2.setColor(new Color(0,0,0));

                g2.drawOval(10, 10,30,30);
                g2.drawLine(25, 0, 25,50); // vertical line
                g2.drawLine(0, 25, 50,25); // horizontal line

            }
        };

        add(p);

        setVisible(true);

        // Create a new thread, run() is written in this class (Runnable implemented)
        t=new Thread(this);

        // Start the thread
        t.start();
        addKeyListener(this);
    }

    public void moveFrame(){
        originX = originX + x;
        originY = originY + y;
        setLocation(originX, originY);
    }

    public void run() {
        try {

//            int width=Toolkit.getDefaultToolkit().getScreenSize().width;

            while (vim) {
                moveFrame();
                Thread.sleep(1);
            }

        }catch(Exception e){}

    }

    public void doubleClick(int x, int y) throws AWTException, InterruptedException {
        Robot bot = new Robot();
        bot.keyPress(KeyEvent.VK_ALT);
        bot.keyPress(KeyEvent.VK_TAB);
        bot.keyRelease(KeyEvent.VK_ALT);
        bot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(10);
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void click(int x, int y) throws AWTException, InterruptedException {
        Robot bot = new Robot();
        bot.keyPress(KeyEvent.VK_ALT);
        bot.keyPress(KeyEvent.VK_TAB);
        bot.keyRelease(KeyEvent.VK_ALT);
        bot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(10);
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_F) {
            try {
                click(originX + 25, originY + 25);
            } catch (AWTException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (key == KeyEvent.VK_D) {
            try {
                doubleClick(originX + 25, originY + 25);
            } catch (AWTException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (key == KeyEvent.VK_L) {
            x = 1;
        }
        if (key == KeyEvent.VK_H) {
            x = -1;
        }
        if (key == KeyEvent.VK_J) {
            y = 1;
        }
        if (key == KeyEvent.VK_K) {
            y = -1;
        }
        if (key == KeyEvent.VK_I) {
            vim = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_L) {
            x = 0;
        }
        if (key == KeyEvent.VK_H) {
            x = 0;
        }
        if (key == KeyEvent.VK_J) {
            y = 0;
        }
        if (key == KeyEvent.VK_K) {
            y = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    public static void main(String[] args) {
        new TransparentWindow();
    }
}