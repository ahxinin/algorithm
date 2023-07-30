package com.ahxinin.sort;

/**
 * @description: 快速排序
 * @date : 2023-07-30
 */
public class QuickSort {

    /**
     * 元素交换
     */
    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 哨兵划分
     */
    int partition(int[] nums, int left, int right){
        //以nums[left]作为基准数
        int i=left, j=right;
        while (i < j){
            while (i<j && nums[j]>=nums[left]){
                j--;
            }
            while (i<j && nums[i]<=nums[left]){
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, i, left);
        return i;
    }

    void quickSort(int[] nums, int left, int right){
        //子数组长度为1时终止递归
        if (left >= right){
            return;
        }
        //哨兵划分
        int pivot = partition(nums, left, right);
        //递归左子数组、右子数组
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }
}
