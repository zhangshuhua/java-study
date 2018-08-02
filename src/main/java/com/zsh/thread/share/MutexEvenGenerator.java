package com.zsh.thread.share;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zsh7040 on 2018-4-20.
 * 使用Lock对象控制的多线程示例
 * 一般情况，用synchronized就可以了，特殊问题用到Lock对象
 */
public class MutexEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            currentEvenValue++;
            Thread.yield();
            currentEvenValue++;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EventChecker.test(new MutexEvenGenerator());
    }
}
