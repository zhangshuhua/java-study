package com.zsh.initOrder;

/**
 * @author zhangshuhua@cetiti.com
 * @date 2018-6-29
 */
public class IntRange {

    int low = 1;
    int high = 11;

    public IntRange(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public IntRange(){}

    boolean include(int arg){
        return arg>=getLow()&&arg<=high;
    }

    int getLow() {
        return this.low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }
}
