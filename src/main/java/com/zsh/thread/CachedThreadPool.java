package com.zsh.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zsh7040 on 2018-4-17.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1000000000);
        for (int i = 0; i < 500000; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}



