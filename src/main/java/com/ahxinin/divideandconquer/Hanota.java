package com.ahxinin.divideandconquer;

import java.util.List;

/**
 * @description: 汉诺塔问题
 * @date : 2023-09-06
 */
public class Hanota {

    /**
     * 移动一个圆盘
     */
    void move(List<Integer> src, List<Integer> tar){
        Integer pan = src.remove(src.size() - 1);
        tar.add(pan);
    }

    /**
     * 求解汉诺塔，问题 f(i)
     */
    void dfs(int i, List<Integer> src, List<Integer> buf, List<Integer> tar){
        //若src只剩下一个圆盘，将其移动到tar
        if (i == 1){
            move(src, tar);
        }
        //子问题f(i-1), 将src顶部n-1个盘借助tar移动到buf
        dfs(i-1, src, tar, buf);
        //将src底部的盘移动到tar
        move(src, tar);
        //子问题f(i-1), 将buf的盘移动到tar
        dfs(i-1, buf, src, tar);
    }

    /**
     * 求解汉诺塔
     */
    void solveHanota(List<Integer> A, List<Integer> B, List<Integer> C){
        int n = A.size();
        //将A顶部的n个圆盘，借助B移动到C
        dfs(n, A, B, C);
    }
}
