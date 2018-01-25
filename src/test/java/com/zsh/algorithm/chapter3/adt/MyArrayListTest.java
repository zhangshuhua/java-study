package com.zsh.algorithm.chapter3.adt;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by zsh7040 on 2018-1-24.
 */
public class MyArrayListTest {

    @Test
    public void test(){
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 0; i <20 ; i++) {
            myArrayList.add(i*2);
        }
        Assert.assertTrue(myArrayList.get(0)==0);
        Assert.assertTrue(myArrayList.get(2)==4);
        Assert.assertTrue(myArrayList.get(19)==38);

        myArrayList.remove(3);
        Assert.assertTrue(myArrayList.get(3)==8);
        Assert.assertTrue(myArrayList.get(18)==38);

        Assert.assertTrue(myArrayList.size()==19);

        myArrayList.set(5,-23);
        Assert.assertTrue(myArrayList.get(5)==-23);

        myArrayList.clear();
        Assert.assertTrue(myArrayList.size()==0);
        Assert.assertTrue(myArrayList.isEmpty());
    }

    @Test
    public void testIterator(){
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 0; i <20 ; i++) {
            myArrayList.add(i*2);
        }

        Iterator<Integer> iterator = myArrayList.iterator();

        while (iterator.hasNext()){
            if(iterator.next()%3==0){
                iterator.remove();
            }
        }

        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }

    }
}
