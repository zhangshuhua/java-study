package com.zsh.thread.share;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zsh7040 on 2018-5-18.
 * 使用原子操作的多线程示例
 */
public class AtomEvenGenerator extends IntGenerator {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public int next() {
        return atomicInteger.addAndGet(2);
    }

    public static void main(String[] args) {
        EventChecker.test(new AtomEvenGenerator());
    }
}
