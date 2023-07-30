package com.ahxinin.sort;

import java.util.Arrays;

/**
 * @description: 合并排序
 * @date : 2023-07-30
 */
public class MergeSort {

    void merge(int[] nums, int left, int mid, int right){
        //初始化辅助数组
        int[] tmp = Arrays.copyOfRange(nums, left, right+1);
        int leftStart = 0, leftEnd = mid - left;
        int rightStart = mid + 1 - left, rightEnd = right - left;
        //i,j分别指向左子数组、右子数组的首元素
        int i = leftStart, j = rightStart;
        //通过覆盖原数组nums来合并
        for(int k = left; k < right; k++){
            if (i > leftEnd){
                nums[k] = tmp[j++];
            }else if (j > rightEnd || tmp[i] <= tmp[j]){
                nums[k] = tmp[i++];
            }else {
                nums[k] = tmp[j++];
            }
        }
    }

    void mergeSort(int[] nums, int left, int right){
        //终止条件
        if (left >= right){
            return;
        }
        //划分阶段
        int mid = (left + right) / 2;
        //递归子数组
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        //合并阶段
        merge(nums, left, mid, right);
    }
    
}
