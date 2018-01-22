package com.zsh.algorithm.chapter2;

import java.util.Random;

/**
 * Created by zsh7040 on 2018-1-22.
 * 课后题2.8-随机产生不重复数组
 */
public class RandArray {

    //空间换时间
    private boolean[] usedArray;

    public RandArray(){}

    public RandArray(int range){
        usedArray = new boolean[range];
    }

    int[] generateRandArray(int n){
        int[] a = new int[n];
        for (int i = 0; i <n ; i++) {
            int thisInt = new Random().nextInt(n);
            while (isContain(a,i,thisInt)){
                thisInt = new Random().nextInt(n);
            }
            a[i]= thisInt;
        }
        return a;
    }

    int[] generateRandArrayUseCache(int n){
        int[] a = new int[n];
        for (int i = 0; i <n ; i++) {
            int thisInt = new Random().nextInt(n);
            while (isContain(thisInt)){
                thisInt = new Random().nextInt(n);
            }
            a[i]= thisInt;
            usedArray[thisInt] = true;
        }
        return a;
    }

    private boolean isContain(int[] a,int high,int value){
        for (int i = 0; i <high ; i++) {
            if(a[i]==value){
                return true;
            }
        }
        return false;
    }

    private boolean isContain(int index){
        return usedArray[index];
    }

}
