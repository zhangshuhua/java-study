package com.zsh.algorithm.chapter3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by zsh7040 on 2018-1-23.
 * 列表删除测试
 */
public class RemoveListTests {

    private List<Integer> arraylist;

    private List<Integer> linkedlist;

    Random random = new Random();

    @Before
    public void setUp() {

        arraylist = new ArrayList<>();
        linkedlist = new LinkedList<>();

        for (int i = 0; i <800000 ; i++) {
            int thisnum = random.nextInt();
            arraylist.add(thisnum);
            linkedlist.add(thisnum);
        }
    }


    /**
     * 利用下标remove的方式绝对不可取，两种都很慢
     * linkedList比arrayList还要慢，因为每次通过下标找很慢
     */
    @Test
    public void testEvensVar1(){
        long before = System.currentTimeMillis();
        RemoveList.removeEvensVar11(arraylist);
        long after = System.currentTimeMillis();
        System.out.println(after-before);

        //这种情况linkedList反倒更慢，因为每次都会找下标
        before = System.currentTimeMillis();
        RemoveList.removeEvensVar11(linkedlist);
        after = System.currentTimeMillis();
        System.out.println(after-before);
    }

    /**
     * 优化的for循环，其实内部是调用了iterator函数，所以也会有ConcurrentModificationException异常
     */
    @Test(expected = ConcurrentModificationException.class)
    public void testEvensVar2(){
        long before = System.currentTimeMillis();
        RemoveList.removeEvensVar2(arraylist);
        long after = System.currentTimeMillis();
        System.out.println(after-before);

        before = System.currentTimeMillis();
        RemoveList.removeEvensVar2(linkedlist);
        after = System.currentTimeMillis();
        System.out.println(after-before);

    }

    /**
     * 利用iterator原生函数的remove方法要快很多
     * linkedList比arrayList快很多，其中的linkedList基本等同于java8的方式
     */
    @Test
    public void testEvensVar3(){

        long before = System.currentTimeMillis();
        RemoveList.removeEvensVar3(arraylist);
        long after = System.currentTimeMillis();
        System.out.println(after-before);

        before = System.currentTimeMillis();
        RemoveList.removeEvensVar3(linkedlist);
        after = System.currentTimeMillis();
        System.out.println(after-before);

    }

    /**
     * java8优化的果然厉害
     */
    @Test
    public void testEvensVar4(){
        long before = System.currentTimeMillis();
        RemoveList.removeEvensVar4(arraylist);
        long after = System.currentTimeMillis();
        System.out.println(after-before);

        before = System.currentTimeMillis();
        RemoveList.removeEvensVar4(linkedlist);
        after = System.currentTimeMillis();
        System.out.println(after-before);
    }

}
