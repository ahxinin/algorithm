package com.ahxinin.sort;

/**
 * @description: 插入排序
 * @date : 2023-07-30
 */
public class InsertionSort {

    void insertionSort(int[] nums){
        //外循环：已排序元素
        for (int i=0; i<nums.length; i++){
            int base = nums[i], j = i-1;
            //内循环：将base插入到已排序部分的正确位置
            while (j>=0 && nums[j]>base){
                nums[j+1] = nums[j];
                j--;
            }
        }
    }
}
