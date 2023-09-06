package com.ahxinin.greedy;

/**
 * @description: 零钱兑换：贪心
 * @date : 2023-09-06
 */
public class CoinChangeGreedy {

    int coinChangeGreedy(int[] coins, int amt){
        //假设coins列表有序
        int i = coins.length - 1;
        int count = 0;
        //循环进行贪心选择，直到无剩余金额
        while (amt > 0){
            //找到小于且最接近剩余金额
            while (i>0 && coins[i]>amt){
                i--;
            }
            //选择coins[i]
            amt -= coins[i];
            count++;
        }
        //若未找到可行方案，返回-1
        return amt==0 ? count : -1;
    }
}
