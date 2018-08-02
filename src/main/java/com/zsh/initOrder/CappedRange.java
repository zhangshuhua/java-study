package com.zsh.initOrder;

/**
 * @author zhangshuhua@cetiti.com
 * @date 2018-6-29
 */
public class CappedRange extends IntRange {

    private int cap;

    {
        low = 5;
    }

    @Override
    public int getLow() {
        return low;
    }

}
