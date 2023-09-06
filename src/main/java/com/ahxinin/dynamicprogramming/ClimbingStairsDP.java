package com.ahxinin.dynamicprogramming;

/**
 * @description: 爬楼梯，动态规划
 * @date : 2023-09-06
 */
public class ClimbingStairsDP {

    /**
     * 爬楼梯，动态规划
     */
    int climbingStairsDP(int n){
        if (n==1 || n==2){
            return n;
        }
        //初始化dp表，用于存储子问题的解
        int[] dp = new int[n+1];
        //初始状态，预设最小子问题的解
        dp[1] = 1;
        dp[2] = 2;
        //状态转移，从最小子问题逐步求解最大子问题
        for (int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 爬楼梯，空间优化后的动态规划
     */
    int climbingStairsDPComp(int n){
        if (n==1 || n==2){
            return n;
        }
        int a=1, b=2;
        for (int i=3; i<=n; i++){
            int tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }

}
