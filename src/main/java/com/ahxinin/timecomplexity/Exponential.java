package com.ahxinin.timecomplexity;

/**
 * 指数阶
 */
public class Exponential {

    /**
     * 指数阶，循环实现
     */
    int exponential(int n){
        int count = 0, base = 1;

        //每轮一分为二，形成数列1,2,4,8,...,2^(n-1)
        for (int i = 0; i < n; i++){
            for (int j = 0; j < base; j++){
                count++;
            }
            base *= 2;
        }
        // count = 1+2+4+8+...+2^(n-1) = 2^n - 1
        return count;
    }
}
