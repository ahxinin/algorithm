package com.ahxinin.timecomplexity;

import java.util.Arrays;
import java.util.Collections;

/**
 * 最差最佳时间复杂度
 */
public class WorstBestTimeComplexity {

    /**
     * 生成一个数组，元素为{1,2,3,...,n}，顺序随机打乱
     * @param n 数组大小
     * @return 随机元素数组
     */
    int[] randomNumbers(int n) {
        Integer[] nums = new Integer[n];
        //生成数组 nums = {1,2,3,...,n}
        for (int i=0; i<n; i++){
            nums[i] = i + 1;
        }

        //随机打乱数组元素
        Collections.shuffle(Arrays.asList(nums));

        //Integer[] -> int[]
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            res[i] = nums[i];
        }
        return res;
    }

    /**
     * 查找数组 nums 中数字1所在索引
     * @param nums 输入数组
     * @return 所在索引
     */
    int findOne(int[] nums){
        for (int i=0; i<nums.length; i++){
            //当元素1在数组头部时，达到最佳时间复杂度 O(1)
            //当元素1在数组尾部时，达到最差时间复杂度 O(n)
            if (nums[i] == 1){
                return i;
            }
        }
        return -1;
    }
}
