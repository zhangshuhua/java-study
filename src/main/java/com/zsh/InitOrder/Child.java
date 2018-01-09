package com.zsh.InitOrder;

/**
 * Created by zsh7040 on 2017-12-28.
 */
public class Child extends Parent {

    private static int childStaticNoInit;

    private static int childStaticVariableInit = 1;

    private static int childStaticRegion;

    private int childNoInit;

    private int childConstrucor;

    private int childVariableInit = 1;

    private int childNonStaticRegion;



    static {
        childStaticRegion = 2;
    }

    {
        childNonStaticRegion = 3;
    }

    public Child(){
        this.childConstrucor = 4;
    }

}
