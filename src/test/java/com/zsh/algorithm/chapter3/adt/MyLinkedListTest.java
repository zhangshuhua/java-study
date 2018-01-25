package com.zsh.algorithm.chapter3.adt;

import com.zsh.algorithm.chapter3.adt.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zsh7040 on 2018-1-25.
 */
public class MyLinkedListTest {

    @Test
    public void test(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i <20 ; i++) {
            myLinkedList.add(i*2);
        }
        Assert.assertTrue(myLinkedList.get(0)==0);
        Assert.assertTrue(myLinkedList.get(2)==4);
        Assert.assertTrue(myLinkedList.get(19)==38);

        myLinkedList.remove(3);
        Assert.assertTrue(myLinkedList.get(3)==8);
        Assert.assertTrue(myLinkedList.get(18)==38);

        Assert.assertTrue(myLinkedList.size()==19);

        myLinkedList.set(5,-23);
        Assert.assertTrue(myLinkedList.get(5)==-23);
        Assert.assertTrue(myLinkedList.get(6)==14);

        myLinkedList.clear();
        Assert.assertTrue(myLinkedList.size()==0);
        Assert.assertTrue(myLinkedList.isEmpty());
    }
}
