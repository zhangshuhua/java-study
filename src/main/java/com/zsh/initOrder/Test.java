package com.zsh.initOrder;

/**
 * @author zhangshuhua@cetiti.com
 * @date 2018-6-29
 */
public class Test {
    public static void main(String[] args) {
        IntRange intRange = new CappedRange();
        System.out.println(intRange.include(3));

    }
}
