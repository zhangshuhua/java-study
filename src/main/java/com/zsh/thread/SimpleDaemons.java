package com.zsh.thread;

/**
 * Created by zsh7040 on 2018-4-17.
 * 后台进程又称守护进程
 * 只要有任何非守护进程存在就不接受进程，一个都没有的话，守护进程自动消亡
 */
public class SimpleDaemons implements Runnable {
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
        try {
            while (true){
                Thread.sleep(101);
                System.out.println(Thread.currentThread()+"-"+this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10 ; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("daemons 结束");
        Thread.sleep(100);
    }
}
