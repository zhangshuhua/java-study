package com.zsh.thread.share;

/**
 * Created by zsh7040 on 2018-5-18.
 * 没有进行任何控制的程序，出现错误
 */
public class NotSafeGenerator extends IntGenerator {
    private int currentEvenvalue = 0;

    @Override
    public int next() {
        currentEvenvalue ++;
        Thread.yield();
        currentEvenvalue ++;
        return currentEvenvalue;
    }

    public static void main(String[] args) {
        EventChecker.test(new NotSafeGenerator());
    }
}
