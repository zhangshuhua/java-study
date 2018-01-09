package com.zsh.algorithm.chapter1;

/**
 * Created by zsh7040 on 2018-1-9.
 */
public class PrintDouble {

    double value;

    final char dot = '.';

    final double ZERO = 0.0;

    final int[] digit = {10, 100, 1000, 1000, 10000, 100000, 1000000, 10000000};

    public PrintDouble(double value) {
        this.value = value;
    }

    public void print() {
        int dotDigit = 0;
        int intValue = 0;
        for (int i = 0; i <digit.length ; i++) {

            if((value*digit[i])%1==ZERO){
                intValue =(int)(value*digit[i]);
                dotDigit = i+1;
                break;
            }
        }
        // int intValue =
    }

    private static void printInt(int value,int dotDigit){
        if(value<10){
            System.out.print(value);
        }
        printInt(value/10,dotDigit);
        // if(value>=10){
        //     printInt(value/10,dotDigit);
        // }
        // System.out.print(value%10);
    }


    public static void main(String[] args) {
        //通过对1取模==0
        printInt(234534,2);
    }
}
