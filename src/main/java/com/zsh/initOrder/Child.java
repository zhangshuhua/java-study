package com.zsh.initOrder;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

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

    @Override
    public void method(){
        System.out.println("子类method");
        super.method();//可以放在任意位置，只是调用一下而已
    }

}
