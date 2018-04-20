package com.zsh.thread;

import org.junit.Test;

import java.security.spec.ECField;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by zsh7040 on 2018-4-19.
 */
public class CatchThreadException {

    @Test
    public void noCatch(){
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(new ExceptionThread());
    }

    /**
     * 任务中的异常是不能简单catch的
     */
    @Test
    public void simpleCatch(){
        try {
            Executor executor = Executors.newCachedThreadPool();
            executor.execute(new ExceptionThread());
        } catch (Exception e) {
            System.out.println("Exception has be catched");
        }
    }

    @Test
    public void catchExceptionHandler(){
        try {
            Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            Executor executor = Executors.newCachedThreadPool();
            executor.execute(new ExceptionThread());
        } catch (Exception e) {
            System.out.println("Exception has be catched");
        }
    }
}
