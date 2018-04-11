package com.zsh.algorithm.chapter3.adt;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zsh7040 on 2018-1-25.
 */
public class SimpleCalculateTest {

    @Test
    public void testConverse(){
        String expression = "a+b*c+(d*e+f)*g";
        SimpleCalculate sc = new SimpleCalculate() ;
        sc.convertSuffixPattern(expression);
        StringBuilder sb = new StringBuilder();
        for(Character c :sc.suffixList){
            sb.append(c);
        }
        Assert.assertEquals("abc*+de*f+g*+",sb.toString());
    }

    @Test
    public void testConverse1(){
        String expression = "a+b*(c-d)-e/f";
        SimpleCalculate sc = new SimpleCalculate();
        sc.convertSuffixPattern(expression);
        StringBuilder sb = new StringBuilder();
        for(Character c :sc.suffixList){
            sb.append(c);
        }
        Assert.assertEquals("abcd-*+ef/-",sb.toString());
    }

    @Test
    public void testConverse2(){
        String expression = "(a+b)*c*(d-e/f)";
        SimpleCalculate sc = new SimpleCalculate();
        sc.convertSuffixPattern(expression);
        StringBuilder sb = new StringBuilder();
        for(Character c :sc.suffixList){
            sb.append(c);
        }
        Assert.assertEquals("ab+c*def/-*",sb.toString());
    }
}
