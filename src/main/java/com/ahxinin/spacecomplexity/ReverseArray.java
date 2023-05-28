package com.ahxinin.spacecomplexity;

/**
 * @description: 数组逆序
 * @date : 2023-05-28
 */
public class ReverseArray {

    /**
     * 算法一，空间复杂度: S(n) = O(1)
     */
    public void algorithmOne(int n, int[] a){
        int t;
        for (int i=0; i<n/2; i++){
            t = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = t;
        }
    }

    /**
     * 算法二，空间复杂度：S(n) = O(n)
     */
    public void algorithmTwo(int n, int[] a){
        int b[] = new int[n];
        for (int i=0; i<n; i++){
            b[i] = a[n-i-1];
        }
        for (int i=0; i<n; i++){
            a[i] = b[i];
        }
    }
}
