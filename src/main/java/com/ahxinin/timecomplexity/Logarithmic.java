package com.ahxinin.timecomplexity;

/**
 * 对数阶
 */
public class Logarithmic {

    /**
     * 对数阶，循环实现
     */
    int logarithmic(float n){
        int count = 0;
        while (n > 1){
            n = n / 2;
            count++;
        }
        return count;
    }
}
