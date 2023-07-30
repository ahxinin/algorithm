package com.ahxinin.sort;

/**
 * @description: 冒泡排序
 * @date : 2023-07-30
 */
public class BubbleSort {

    void bubbleSort(int[] nums){
        //外循环：未排序区间为[0,i]
        for (int i=nums.length-1; i>0; i--){
            //内循环：将未排序区间中的最大元素交换到该区间的最右端
            for (int j=0; j<i; j++){
                if (nums[j] > nums[j+1]){
                    //交换nums[j]与nums[j+1]
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }
}
