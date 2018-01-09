package com.zsh.algorithm.chapter1;

import org.junit.Test;

import java.util.Random;

import static com.zsh.algorithm.chapter1.SelectionProblem.*;
import static org.junit.Assert.*;

/**
 * Created by zsh7040 on 2018-1-9.
 */
public class SelectionProblemTest {

    @Test
    public void testValidity(){
        int[] nums = randomArray(50);

        assertTrue(arrayK(nums,1)==sortForK(nums,1));
        assertTrue(arrayK(nums,3)==sortForK(nums,3));
        assertTrue(arrayK(nums,5)==sortForK(nums,5));
        assertTrue(arrayK(nums,8)==sortForK(nums,8));
        assertTrue(arrayK(nums,10)==sortForK(nums,10));
        assertTrue(arrayK(nums,25)==sortForK(nums,25));
    }

    @Test
    public void testUseTime(){
        for (int i = 10; i <100000 ; i*=2) {
            showTime(i);
        }
    }

    public void showTime(int length){
        System.out.println(length);

        int[] array = randomArray(length);
        long arrayKstartTime = System.currentTimeMillis();
        System.out.print(arrayK(array,length/2)+"----------");
        long arrayKendTime = System.currentTimeMillis();
        System.out.println(arrayKendTime-arrayKstartTime);

        int[] array1 = randomArray(length);
        long sortForKstartTime = System.currentTimeMillis();
        System.out.print(sortForK(array1,length/2)+"----------");
        long sortForKendTime = System.currentTimeMillis();
        System.out.println(sortForKendTime-sortForKstartTime);
        System.out.println("--------------------------");
    }


    private int[] randomArray(int length){
        int[] array = new int[length];
        Random random = new Random();

        for (int i = 0; i <length ; i++) {
            int number = random.nextInt();
            array[i] = number;
        }
        return array;
    }
}
