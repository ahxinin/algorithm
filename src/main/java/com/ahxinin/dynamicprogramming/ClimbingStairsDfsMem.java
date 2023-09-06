package com.ahxinin.dynamicprogramming;

import java.util.Arrays;

/**
 * @description: 爬楼梯问题
 * 给定一个共有n阶的楼梯，你每步可以上1阶或者2阶，请问有多少种方案可以爬到楼顶
 * @date : 2023-09-06
 */
public class ClimbingStairsDfsMem {

    /**
     * 记忆化搜索
     */
    int dfs(int i, int[] mem){
        //已知结果
        if (i==1 || i==2){
            return i;
        }
        //已存在记录
        if (mem[i] != -1){
            return mem[i];
        }
        //dp[i] = dp[i-1] + dp[i-2]
        int count = dfs(i-1, mem) + dfs(i-2, mem);
        //记录dp[i]
        mem[i] = count;
        return count;
    }

    /**
     * 爬楼梯，记忆搜索法
     */
    int climbingStairsDFSMem(int n){
        int[] mem = new int[n+1];
        Arrays.fill(mem, -1);
        return dfs(n, mem);
    }
}