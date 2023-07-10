package com.ahxinin.datastructure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Heap {

    /*初始化堆 */
    //初始化小顶堆
    Queue<Integer> minHeap = new PriorityQueue<>();
    //初始化大顶堆
    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    /*元素入堆 */
    void offer(){
        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.offer(2);
        maxHeap.offer(5);
    }

    /*获取堆顶元素 */
    void peek(){
        int peek = maxHeap.peek();
    }

    /*建堆 */
    void init(){
        minHeap = new PriorityQueue<>(Arrays.asList(1, 3, 2, 5));
    }
}
