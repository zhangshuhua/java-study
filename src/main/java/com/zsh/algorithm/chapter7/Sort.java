package com.zsh.algorithm.chapter7;

/**
 * Created by zsh7040 on 2018-2-27.
 */
public class Sort {

    /**
     * 如果预先有序，在复杂度是O <sub>(n)</sub>
     * 希尔排序与插入排序很像，其实就是多次插入排序
     * @param nums
     */
    public static void insertSort(int[] nums){

        int length = nums.length;
        int j;

        for (int i = 1; i <length ; i++) {
            int temp = nums[i];
            //只有当nums[j-1]>temp时，才进行j--操作
            for (j = i; j >0&&nums[j-1]>temp ; j--) {
                nums[j] = nums[j-1];
            }
            nums[j] = temp;
        }

    }
}
