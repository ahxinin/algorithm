package com.ahxinin.sort;

/**
 * @description: 选择排序
 * @date : 2023-07-30
 */
public class SelecttionSort {

    void selectionSort(int[] nums){
        int n = nums.length;
        //外循环：未排序区间 [i, n-1]
        for(int i=0; i<n-1; i++){
            //内循环：找到最小元素
            int k = i;
            for (int j=i+1; j<n; j++){
                if (nums[j] < nums[k]){
                    //记录最小元素的索引
                    k = j;
                }
                //将该最小元素与未排序区间的首个元素交换
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }
    }

}
