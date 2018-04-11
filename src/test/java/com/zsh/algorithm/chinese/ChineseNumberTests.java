package com.zsh.algorithm.chinese;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by zsh7040 on 2018-3-26.
 */
public class ChineseNumberTests {

    @Test
    public void test1(){
        ChineseNumber c = new ChineseNumber("0101");
        System.out.println(c);
    }

    @Test
    public void test3(){
        ChineseNumber c = new ChineseNumber(01010);
        System.out.println(c);
    }

    @Test
    public void test2(){
        ChineseNumber c = new ChineseNumber(11010);
        String[] b = c.generateList();
        for (int i = 0; i <b.length ; i++) {
            System.out.println(b[i]);
        }
    }
    @Test
    public void testClass(){
        ChineseNumber c = new ChineseNumber(11010);
        System.out.println(c.getClass());
        for(Field f:c.getClass().getFields()){
            System.out.println(f);
        }
        for(Method m:c.getClass().getMethods()){
            System.out.println(m);
        }

    }
    @Test
    public void testGenericClass(){
        ChineseNumber c = new ChineseNumber(11010);
        System.out.println(c.getClass().toGenericString());
        for(Field f:c.getClass().getDeclaredFields()){
            System.out.println(f);
        }
        for(Method m:c.getClass().getDeclaredMethods()){
            System.out.println(m);
        }

    }
}
