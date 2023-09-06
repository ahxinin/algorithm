package com.ahxinin.dynamicprogramming;

/**
 * @description: 爬楼梯最小代价，动态规划
 * @date : 2023-09-06
 */
public class MinCostClimbingStairsDP {

    int minCostClimbingStairsDP(int[] cost){
        int n = cost.length - 1;
        if (n==1 || n==2){
            return cost[n];
        }
        //初始化dp表，存储子问题的解
        int[] dp = new int[n+1];
        //初始状态
        dp[1] = 1;
        dp[2] = 2;
        //状态转移
        for (int i=3; i<=n; i++){
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        return dp[n];
    }
}
