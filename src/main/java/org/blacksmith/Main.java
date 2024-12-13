package org.blacksmith;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Main {
//    private static Robot robot = null;
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(25,240);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
    }

}