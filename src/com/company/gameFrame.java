package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

public class gameFrame extends JPanel {

    Timer time;
    int frame = 0;
    Color red = new Color(155, 0, 0);
    Color blue = new Color(0, 0, 155);
    Color green = new Color(0, 155, 0);
    Color yellow = new Color(155, 155, 0);
    Color redLit = new Color(255, 0, 0);
    Color blueLit = new Color(0, 0, 255);
    Color greenLit = new Color(0, 255, 0);
    Color yellowLit = new Color(255, 255, 0);
    Rectangle rectangle1 = new Rectangle(365, 85, 250, 250);
    Rectangle rectangle2 = new Rectangle(665, 85, 250, 250);
    Rectangle rectangle3 = new Rectangle(365, 385, 250, 250);
    Rectangle rectangle4 = new Rectangle(665, 385, 250, 250);
    ArrayList<Integer> isLit = new ArrayList<Integer>(0);
    boolean isGreenLit, isRedLit, isYellowLit, isBlueLit = false;


    public gameFrame() {
        time = new Timer(16, e -> {
            // TODO Auto-generated method stub
            update();
        });
        time.start();
        addToArray();
        checkArray();
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 1280, 720);
        if (isGreenLit)
            g.setColor(greenLit);
        else
            g.setColor(green);
        g.fillRect(365, 85, 250, 250);
        if (isRedLit)
            g.setColor(redLit);
        else
            g.setColor(red);
        g.fillRect(665, 85, 250, 250);
        if (isYellowLit)
            g.setColor(yellowLit);
        else
            g.setColor(yellow);
        g.fillRect(365, 385, 250, 250);
        if (isBlueLit)
            g.setColor(blueLit);
        else
            g.setColor(blue);
        g.fillRect(665, 385, 250, 250);
    }

    public void update() {
        if (frame <= 0) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        frame++;
//        System.out.println(frame);
        repaint();
    }

    public void addToArray() {
        isLit.add(ThreadLocalRandom.current().nextInt(1, 5));
    }

    public void checkArray() {
        for (int i = 0; i < isLit.size(); i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isLit.get(i) == 1) {
                isGreenLit = true;
                isRedLit = false;
                isYellowLit = false;
                isBlueLit = false;
            } else if (isLit.get(i) == 2) {
                isRedLit = true;
                isGreenLit = false;
                isYellowLit = false;
                isBlueLit = false;
            } else if (isLit.get(i) == 3) {
                isYellowLit = true;
                isGreenLit = false;
                isRedLit = false;
                isBlueLit = false;
            } else if (isLit.get(i) == 4) {
                isBlueLit = true;
                isGreenLit = false;
                isRedLit = false;
                isYellowLit = false;
            } else {
                isGreenLit = false;
                isRedLit = false;
                isYellowLit = false;
                isBlueLit = false;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            isGreenLit = false;
            isRedLit = false;
            isYellowLit = false;
            isBlueLit = false;
        }
        //why?
        addToArray();
    }
}
