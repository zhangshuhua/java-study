package com.zsh.thread.share;

/**
 * Created by zsh7040 on 2018-4-19.
 */
public class EventGenerator extends IntGenerator {

    private int currentEvenvalue = 0;

    @Override
    public int next() {
        currentEvenvalue ++;
        Thread.yield();
        currentEvenvalue ++;
        return currentEvenvalue;
    }

    public static void main(String[] args) {
        EventChecker.test(new EventGenerator());
    }

}
