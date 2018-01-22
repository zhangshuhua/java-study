package com.zsh.algorithm.chapter2;

import org.junit.Test;

/**
 * Created by zsh7040 on 2018-1-22.
 */
public class RandArrayTests {

    @Test
    public void testNoExcludeArray(){
        long before = System.currentTimeMillis();
        RandArray ra = new RandArray();
        int[] a = ra.generateRandArray(50000);
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+"-");
        }
        long after = System.currentTimeMillis();
        System.out.println(after-before);

    }

    @Test
    public void testCacheArray(){
        long before = System.currentTimeMillis();
        RandArray ra = new RandArray(50000);
        int[] a = ra.generateRandArrayUseCache(50000);
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+"-");
        }
        long after = System.currentTimeMillis();
        System.out.println(after-before);
    }
}
