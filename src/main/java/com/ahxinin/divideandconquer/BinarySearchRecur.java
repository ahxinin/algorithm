package com.ahxinin.divideandconquer;

/**
 * @description: 分治搜索
 * @date : 2023-09-06
 */
public class BinarySearchRecur {

    /**
     * 二分查找，问题(i,j)
     */
    int dfs(int[] nums, int target, int i, int j){
        //区间为空，无目标元素
        if (i > j){
            return -1;
        }
        //计算中间结点
        int m = (i+j) / 2;
        if (nums[m] < target){
            //递归子问题 f(m+1,j)
            return dfs(nums, target,m+1, j);
        }else if (nums[m] > target){
            //递归子问题 f(i, m-1)
            return dfs(nums, target, i, m-1);
        }else {
            return m;
        }
    }

    /**
     * 二分查找
     */
    int binarySearch(int[] nums, int target){
        int n = nums.length;
        return dfs(nums, target, 0, n-1);
    }
}
