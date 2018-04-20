package com.zsh.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zsh7040 on 2018-4-20.
 */
public class AttemptLock {

    private Lock lock = new ReentrantLock();

    public void untimed(){
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock - " + captured);
        }finally {
            if(captured){
                lock.unlock();
            }
        }
    }

    public void timed(){
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException("获取锁失败",e);
        }

        try {
            System.out.println("try lock 2s - " + captured);
        }finally {
            if(captured){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final AttemptLock attemptLock = new AttemptLock();
        attemptLock.timed();
        attemptLock.untimed();

        new Thread(){
            {setDaemon(true);}
            public void run(){
                attemptLock.lock.lock();
                System.out.println("新线程锁定");
            }
        }.start();
        Thread.sleep(1000);
        attemptLock.untimed();
        attemptLock.timed();
    }
}
