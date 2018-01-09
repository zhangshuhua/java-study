package com.zsh.reflection.ClassLoadOrdel;

import com.sun.org.apache.xpath.internal.SourceTree;
import sun.applet.Main;

/**
 * Created by zsh7040 on 2017-11-6.
 */
public class ClassInitOrder {

    static final double pi = 3.1415926;

    static double r;

    double s;

    static {
        System.out.println("static块");
    }

    {
        System.out.println("{}块");
    }

    static void setR(double R){
        r=R;
        System.out.println("setR");
    }

    double Squart(){
        System.out.println("Squart");
        return pi*r*r;
    }

    public static void main(String[] args) {

    }
}
