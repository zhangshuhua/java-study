package com.zsh.thread;

/**
 * Created by zsh7040 on 2018-4-18.
 */
class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name,int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run(){
        try {
            sleep(duration);
        }catch (InterruptedException e){
            System.out.println(getName() + "- was interrupt" + "isInterrupted :" + isInterrupted() );
            return;
        }
        System.out.println(getName()+"has awakened");
    }

}


class Joiner extends Thread{
    private Sleeper sleeper;

    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper  = sleeper;
        start();
    }

    public void run(){
        try {
            sleeper.join();
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println(getName()+"join completed");

    }
}

public class Joining{
    public static void main(String[] args) {
        Sleeper sleeper1 = new Sleeper("Sleep1",1500);
        Sleeper sleeper2 = new Sleeper("Sleep2",1500);
        Joiner joiner1 = new Joiner("Joiner1",sleeper1);
        Joiner joiner2 = new Joiner("Joiner2",sleeper2);
        sleeper2.interrupt();
    }
}