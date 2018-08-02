package com.zsh.thread;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zsh7040 on 2018-5-18.
 */
public class SerialNumberChecker {
    private static final int SIZE = 10;

    private static CirularSet serials = new CirularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable{

        @Override
        public void run() {
            while (true){
                int serial = SerialNumberGenerator.nextSerialNumber();
                if(serials.contains(serial)){
                    System.out.println("出现重复数："+serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE ; i++) {
            exec.execute(new SerialChecker());
        }
    }
}

class CirularSet{
    private int[] array;
    private int len;
    private int index = 0;
    public CirularSet(int size){
        array = new int[size];
        len = size;
        for (int i = 0; i < size ; i++) {
            array[i] = -1;
        }
    }
    public synchronized void add (int i){
        array[index] = i;
        index = ++index%len;
    }

    public synchronized boolean contains(int val){
        for (int i = 0; i < len ; i++) {
            if(array[i] == val){
                return true;
            }
        }
        return false;
    }
}

class SerialNumberGenerator{
    private static volatile int serialNumber = 0;

    /**
     * 虽然是volatile但是还是要通过synchronized来控制同步
     * @return
     */
    public static int nextSerialNumber(){
        return serialNumber++;
    }
}