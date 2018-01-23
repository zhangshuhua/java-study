package com.zsh.algorithm.chapter3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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

        arraylist = new ArrayList<>(40);
        linkedlist = new LinkedList<>();

        for (int i = 0; i <40 ; i++) {
            int thisnum = random.nextInt();
            arraylist.add(thisnum);
            linkedlist.add(thisnum);
        }
    }

    @Test
    public void testEvensVar1(){
        List<Integer> list1 = (List)((ArrayList)arraylist).clone();
        List<Integer> list2 = (List)((LinkedList)linkedlist).clone();
        long before = System.currentTimeMillis();
        RemoveList.removeEvensVar1(list1);
        long after = System.currentTimeMillis();
        System.out.println(after-before);

        before = System.currentTimeMillis();
        RemoveList.removeEvensVar1(list2);
        after = System.currentTimeMillis();
        System.out.println(after-before);
    }

    @Test
    public void testEvensVar2(){

    }

    @Test
    public void testEvensVar3(){

    }

    @Test
    public void testEvensVar4(){

    }

}
