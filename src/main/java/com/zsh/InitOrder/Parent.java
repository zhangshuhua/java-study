package com.zsh.InitOrder;

/**
 * Created by zsh7040 on 2017-12-28.
 */
public class Parent {

    private static int parentStaticNoInit;

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
    }

}
