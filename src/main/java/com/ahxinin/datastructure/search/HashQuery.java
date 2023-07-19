package com.ahxinin.datastructure.search;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希查找
 * 给定一个整数数组 nums 和一个目标元素 target ，请在数组中搜索“和”为 target 的两个元素，并返回它们的数组索引。返回任意一个解即可。
 */
public class HashQuery {

    int[] twoSumHashTable(int[] nums, int target){
        int size = nums.length;
        //辅助哈希表，空间复杂度 O(n)
        Map<Integer, Integer> dic = new HashMap<>();
        //单层循环，时间复杂度 O(n)
        for (int i=0; i<size; i++){
            if (dic.containsKey(target - nums[i])){
                return new int[]{dic.get(target - nums[i]), i};
            }
            dic.put(nums[i], i);
        }
        return new int[0];
    }
}
