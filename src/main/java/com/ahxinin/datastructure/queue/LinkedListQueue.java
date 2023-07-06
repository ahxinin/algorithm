package com.ahxinin.datastructure.queue;

import com.ahxinin.datastructure.ListNode;

/**
 * 基于链表实现的队列
 */
public class LinkedListQueue {

    //头节点front, 尾节点rear
    private ListNode front, rear;
    private int queSize = 0;

    public LinkedListQueue(){
        front = null;
        rear = null;
    }

    /*获取队列的长度 */
    public int size(){
        return queSize;
    }

    /*判断队列是否为空 */
    public boolean isEmpty(){
        return size() == 0;
    }

    /*入队 */
    public void push(int num){
        //尾节点后添加 num
        ListNode node = new ListNode(num);
        //如果队列为空，则将头、尾节点都指向该节点
        if (front == null){
            front = node;
            rear = node;
        //如果队列不为空，则将该节点添加到尾节点之后
        }else {
            rear.next = node;
            rear = node;
        }
        queSize++;
    }

    /*出队 */
    public int pop(){
        int num = peek();
        //删除头节点
        front = front.next;
        queSize--;
        return num;
    }

    /*访问队首元素 */
    public int peek(){
        if (size() == 0){
            throw new IndexOutOfBoundsException();
        }
        return front.val;
    }

    /*将链表转化为Array并返回 */
    public int[] toArray(){
        ListNode node = front;
        int[] res = new int[size()];
        for (int i=0; i<res.length; i++){
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }
}
