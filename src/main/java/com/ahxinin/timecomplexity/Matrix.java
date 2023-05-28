package com.ahxinin.timecomplexity;

/**
 * @description: 矩阵
 * @date : 2023-05-28
 */
public class Matrix {

    public void calculate(int n){

        int[][] a = {{1,2}, {1,2}};
        int[][] b = {{2,3}, {2,3}};
        int[][] c = new int[n][n];

        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                c[i][j] = 0;
                for (int k=0; k<n; k++){
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }
    }
}
