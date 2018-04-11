package com.zsh.initOrder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zsh7040 on 2017-12-28.
 */
public class Parent {

    private static int parentStaticNoInit;

    private static Map hashMap = new HashMap();

    private static int parentStaticVariableInit = 1;

    private static int parentStaticRegion;

    private int parentNoInit;

    private int parentConstrucor;

    private int parentVariableInit = 1;

    private int parentNonStaticRegion;


    static {
        parentStaticRegion = 2;
    }

    {
        parentNonStaticRegion = 3;
    }

    public Parent(){
        this.parentConstrucor = 4;
        System.out.println(parentStaticNoInit);
        System.out.println(parentStaticVariableInit);
        System.out.println(parentStaticRegion);
        System.out.println(hashMap);
    }

    public void method(){
        System.out.println("父类method");
    }

}
