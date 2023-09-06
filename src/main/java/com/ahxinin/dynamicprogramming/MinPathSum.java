package com.ahxinin.dynamicprogramming;

/**
 * @description: 最小路径和
 * @date : 2023-09-06
 */
public class MinPathSum {

    /**
     * 暴力搜索法
     */
    int minPathSumDFS(int[][] grid, int i, int j){
        //若为左上角单元格，则终止搜索
        if (i==0 && j==0){
            return grid[0][0];
        }
        //计算左上角到(i-1,j)和(i,j-1)的最小路径
        int left = minPathSumDFS(grid, i-1, j);
        int up = minPathSumDFS(grid, i, j-1);
        //返回左上角到(i,j)最小路径
        return Math.min(left, up) + grid[i][j];
    }

    /**
     * 记忆化搜索
     */
    int minPathSumDFSMem(int[][] grid, int[][] mem, int i, int j){
        //若为左上角单元格，则终止搜索
        if (i==0 && j==0){
            return grid[0][0];
        }
        //若有记录，返回结果
        if (mem[i][j] != -1){
            return mem[i][j];
        }
        //计算左上角到(i-1,j)和(i,j-1)的最小路径
        int left = minPathSumDFS(grid, i-1, j);
        int up = minPathSumDFS(grid, i, j-1);
        //记录左上角到(i,j)最小路径
        mem[i][j] = Math.min(left, up) + grid[i][j];
        return mem[i][j];
    }

    /**
     * 动态规划
     */
    int minPathSumDP(int[][] grid){
        int n = grid.length, m = grid[0].length;
        //初始化dp表
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        //状态转移，首行
        for (int j=1; j<m; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        //状态转移，首列
        for (int i=1; i<n; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        //状态转移，其他行列
        for (int i=1; i<n; i++){
            for (int j=1; j<m; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}
