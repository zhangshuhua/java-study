package com.zsh.algorithm.chapter2.prime;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zsh7040 on 2018-1-22.
 */
public class PrimeNumberTest {

    @Test
    public void valiatePrimeNumber(){
        Assert.assertTrue(PrimeNumber.isPrimeNuber(2));
        Assert.assertTrue(PrimeNumber.isPrimeNuber(5));
        Assert.assertTrue(PrimeNumber.isPrimeNuber(17));
        Assert.assertTrue(PrimeNumber.isPrimeNuber(97));
        Assert.assertTrue(PrimeNumber.isPrimeNuber(997));
        Assert.assertFalse(PrimeNumber.isPrimeNuber(4));
        Assert.assertFalse(PrimeNumber.isPrimeNuber(188));
        Assert.assertFalse(PrimeNumber.isPrimeNuber(81));
    }
}
