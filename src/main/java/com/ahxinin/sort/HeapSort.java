package com.ahxinin.sort;

/* 堆排序 */
public class HeapSort {

    /*堆的长度为n, 从节点i开始，从顶到底堆化 */
    void shiftDown(int[] nums, int n, int i){
        while (true){
            //判断节点 i,l,r 中值最大的节点，记为ma
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int ma = i;
            if (l<n && nums[l]>nums[ma]){
                ma = l;
            }
            if (r<n && nums[r]>nums[ma]){
                ma = r;
            }

            //若节点 i 最大或者索引l, r越界，则无需继续堆化，跳出
            if (ma == i){
                break;
            }
            //交互两节点
            int temp = nums[i];
            nums[i] = nums[ma];
            nums[ma] = temp;
            //循环向下堆化
            i = ma;
        }
    }

    /*堆排序 */
    void heapSort(int[] nums){
        //建堆操作：堆化除叶节点以外的其他所有节点
        for (int i=nums.length/2-1; i>=0; i--){
            shiftDown(nums, nums.length, i);
        }
        //从堆中提取最大元素，循环n-1轮
        for (int i=nums.length-1; i>0; i--){
            //交换根节点与最右节点
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            //以根节点为起点，从顶至底进行堆化
            shiftDown(nums, i, 0);
        }
    }
}
