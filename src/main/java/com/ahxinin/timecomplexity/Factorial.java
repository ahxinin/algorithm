package com.ahxinin.timecomplexity;

/**
 * 阶乘
 */
public class Factorial {

    /**
     * 阶乘阶，递归实现
     */
    int factorialRecur(int n){
        if (n == 0){
            return 1;
        }

        int count =0;
        //从一个分裂出n个
        for (int i=0; i<n; i++){
            count += factorialRecur(n - 1);
        }
        return count;
    }
}
