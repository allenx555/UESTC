package com.allenx555.helloworldapp;

import java.applet.Applet;
import java.awt.Graphics;

public class HelloWorld extends Applet{
    public void paint(Graphics g) {
        g.drawString("Hello,Java Applet World!",100,100);
    }
}

