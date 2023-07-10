package com.ahxinin.datastructure.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/*Top-K问题 */
public class TopK {

    /*基于堆查找数组中最大的K个元素 */
    Queue<Integer> topKHeap(int[] nums, int k){
        Queue<Integer> heap = new PriorityQueue<>();
        //将数组的前 k 个元素入堆
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        //从第 k+1 个元素开始，保持堆的长度为 k
        for (int i = k; i < nums.length; i++){
            //若当前元素大于堆顶元素，则将堆顶元素出堆，当前元素入堆
            if (nums[i] > heap.peek()){
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap;
    }
}
