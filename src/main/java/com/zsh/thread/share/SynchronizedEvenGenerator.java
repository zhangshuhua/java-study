package com.zsh.thread.share;

/**
 * Created by zsh7040 on 2018-4-20.
 */
public class SynchronizedEvenGenerator extends IntGenerator {

    private int currentEvenvalue = 0;

    @Override
    public synchronized int next() {
        currentEvenvalue ++;
        Thread.yield();
        currentEvenvalue ++;
        return currentEvenvalue;
    }

    public static void main(String[] args) {
        EventChecker.test(new SynchronizedEvenGenerator());
    }
}
