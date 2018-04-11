package com.zsh.algorithm.chapter7;

import org.junit.Test;

/**
 * Created by zsh7040 on 2018-2-27.
 */
public class SortTests {

    private void printArray(int[] nums){
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }
    }

    @Test
    public void testInsertSort(){
        int[] a = {34,8,64,51,32,21};

        Sort.insertSort(a);
        printArray(a);
    }
}
