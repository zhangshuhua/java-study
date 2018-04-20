package com.zsh.thread;

import org.junit.Test;

/**
 * Created by zsh7040 on 2018-4-17.
 */
public class LiftOffTests {

    @Test
    public void test(){
        LiftOff liftOff = new LiftOff();
        liftOff.run();
        System.out.println("结束");
    }

    @Test
    public void testThread(){
        LiftOff liftOff = new LiftOff();
        Thread thread = new Thread(liftOff);
        thread.start();
        System.out.println("结束");
    }

    @Test
    public void testMultiThread(){
        for (int i = 0; i <5 ; i++) {
            new Thread(new LiftOff()).start();
        }
    }
}
