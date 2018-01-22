package com.zsh.algorithm.chapter2;

/**
 * Created by zsh7040 on 2018-1-10.
 */
public class MaxSub {

    static final int[] values= {-2,5,-6,11,-4,13,1,-1,2,-5,-2};

    static int max = 0;

    /**
     * 最大子序列O(n<sup>2</sup>)
     * @return
     */
    public static int maxsub1(){

        for (int i = 0; i <values.length ; i++) {

            int thisSum = 0;
            for (int j = i; j <values.length; j++) {
                thisSum += values[j];
                if(thisSum>max){
                    max = thisSum;
                }
            }
        }
        return max;
    }




    public static void main(String[] args) {
        System.out.print(MaxSub.maxsub1());
    }

}
