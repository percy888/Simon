package com.company;

import javax.swing.*;

public class Main extends JFrame{

    public static void main(String[] args) {
        new Main();

    }

    public Main(){
        setTitle("Simon Says");
        setResizable(false);
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new gameFrame());
        setVisible(true);

    }
}
