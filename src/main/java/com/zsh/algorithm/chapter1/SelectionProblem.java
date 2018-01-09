package com.zsh.algorithm.chapter1;

/**
 * Created by zsh7040 on 2018-1-9.
 * 选择性问题，即选择第k个最大值
 * 印象是堆排序的效率比较高，但是不会写
 */

public class SelectionProblem {

    //冒泡排序来选择
    static int sortForK(int[] nums,int k){

        int length = nums.length;

        for (int i=0;i<length;i++){
            for (int j = 0; j <length-i-1 ; j++) {
                if(nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        return nums[length-k];
    }

    //类型选择排序类存储前k个值，这个比冒泡排序效率高
    static int arrayK(int[] nums,int k){

        int[] sortArray = new int[k];
        int length = nums.length;

        for (int i = 0; i <k ; i++) {
            sortArray[i] = nums[i];
        }
        sort(sortArray);

        for (int i = k; i <length ; i++) {
            insertSort(sortArray,nums[i]);
        }
        return sortArray[k-1];
    }

    static void insertSort(int[] nums,int insertNum){
        int length = nums.length;
        for (int i = 0; i <length ; i++) {
            if(insertNum>nums[i]){
                for (int j = length-1; j >i ; j--) {
                    nums[j] = nums[j-1];
                }
                nums[i] = insertNum;
                break;
            }
        }
    }


    //冒泡排序
    static void sort(int[] nums){

        int length = nums.length;

        for (int i=0;i<length;i++){
            for (int j = 0; j <length-i-1 ; j++) {
                if(nums[j]<nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

}
