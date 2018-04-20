package com.zsh.thread.share;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zsh7040 on 2018-4-19.
 */
public class EventChecker implements Runnable {

    private final IntGenerator generator;

    private final int id;

    public EventChecker(IntGenerator g, int id) {
        this.generator = g;
        this.id = id;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        // int i = 0;
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + "不是偶数");
                generator.cancel();
            }
            // System.out.println(++i);
        }

    }

    public static void test(IntGenerator gp, int count) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executor.execute(new EventChecker(gp, i));
        }
        executor.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }

}
