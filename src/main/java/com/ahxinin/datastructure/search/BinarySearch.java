package com.ahxinin.datastructure.search;

/**
 * 二分查找
 */
public class BinarySearch {

    int binarySearch(int[] nums, int target){
        //初始化双闭区间
        int i=0, j=nums.length-1;
        //循环，当搜索空间为空时跳出
        while (i <= j){
            int m = i + (j-1)/2;    //计算中点索引m
            if(nums[m] < target){
                i = m + 1;
            }else if (nums[m] > target){
                j = m - 1;
            }else {
                return m;
            }
        }
        //未找到元素
        return -1;
    }
}
