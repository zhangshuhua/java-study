package com.zsh.algorithm.chapter4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zsh7040 on 2018-1-29.
 */
public class BinarySearchTreeTest {

    @Test
    public void testEmpty(){
        BinarySearchTree bst = new BinarySearchTree();
        Assert.assertTrue(bst.isEmpty());
    }

    @Test
    public void testInsert(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(3);
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);
        bst.insert(0);
        Assert.assertTrue(bst.getRoot()==3);
    }

    @Test
    public void testContain(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(3);
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);
        bst.insert(0);
        Assert.assertTrue(bst.contain(3));
        Assert.assertTrue(bst.contain(2));
        Assert.assertTrue(bst.contain(0));
        Assert.assertTrue(bst.contain(4));
        Assert.assertFalse(bst.contain(5));
    }

    @Test
    public void testFind(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(3);
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);
        bst.insert(0);

        Assert.assertTrue(bst.findMin()==0);
        Assert.assertTrue(bst.findMax()==4);

        bst.insert(100);
        bst.insert(-2);

        Assert.assertTrue(bst.findMin()==-2);
        Assert.assertTrue(bst.findMax()==100);

    }

}
