package com.ahxinin.timecomplexity;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 时间复杂度计算：外层循环执行n-1次，内存循环执行n-1,n-2,...,2,1次，平均为n/2次
     * 因此 O((n-1) * n/2) = O(n^2), 时间复杂度为平方阶
     */
    int bubbleSort(int[] nums){
        //计数器
        int count = 0;

        //外循环：为排序区间为[0,i]
        for (int i= nums.length-1; i>0; i--){
            //内循环：将未排序区间[0,i]中最大元素交换至该区间的最右端
            for (int j=0; j<i; j++){
                if (nums[j] > nums[j+1]){
                    //交换 nums[j] 与 nums[j+1}
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    // 元素交换包含3个单元操作
                    count += 3;
                }
            }
        }
        return count;
    }
}
