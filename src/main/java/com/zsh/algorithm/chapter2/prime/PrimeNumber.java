package com.zsh.algorithm.chapter2.prime;

/**
 * Created by zsh7040 on 2018-1-22.
 * 求一个数是否是素数
 */
public class PrimeNumber {

    static boolean isPrimeNuber(long value){
        if(value<=0){
            throw new IllegalArgumentException("必须是正整数");
        }
        if(value==2){
            return true;
        }
        if(value%2==0){
            return false;
        }
        int rootValue = (int)Math.sqrt(value);
        for(int i = 3;i<=rootValue;i+=2){
            if(value%i==0){
                return false;
            }
        }
        return true;

    }
}
