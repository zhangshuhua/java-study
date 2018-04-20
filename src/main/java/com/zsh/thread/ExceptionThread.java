package com.zsh.thread;

/**
 * Created by zsh7040 on 2018-4-19.
 */
public class ExceptionThread implements Runnable {


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
            throw new RuntimeException("run线程异常");
        } catch (RuntimeException e) {
            System.out.println("run方法中自身catch");
        }
    }

}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    /**
     * Method invoked when the given thread terminates due to the
     * given uncaught exception.
     * <p>Any exception thrown by this method will be ignored by the
     * Java Virtual Machine.
     *
     * @param t the thread
     * @param e the exception
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("catch "+e.getMessage());
    }
}
