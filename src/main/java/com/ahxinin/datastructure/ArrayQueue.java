package com.ahxinin.datastructure;

/**
 * 基于环形数组实现的队列
 */
public class ArrayQueue {

    private int[] nums; //用于存储队列元素的数组
    private int front;  //队首指针，指向队首元素
    private int queSize;    //队列长度

    public ArrayQueue(int capacity){
        nums = new int[capacity];
        front = queSize = 0;
    }

    /*获取队列的容量 */
    public int capacity(){
        return nums.length;
    }

    /*获取队列的长度 */
    public int size(){
        return queSize;
    }

    /*判断队列是否为空 */
    public boolean isEmpty(){
        return queSize == 0;
    }

    /*入队 */
    public void push(int num){
        //队列已满
        if (queSize == capacity()){
            return;
        }

        //计算尾指针，指向队尾索引+1
        //通过取余操作，实现rear越过数组尾部回到头部
        int rear = (front + queSize) % capacity();
        //将num添加到队尾
        nums[rear] = num;
        queSize++;
    }

    /*出队 */
    public int pop(){
        int num = peek();
        //队首指针向后移动一位，若越过尾部则返回数组头部
        front = (front+1) % capacity();
        queSize--;
        return num;
    }

    /*访问队首元素 */
    public int peek(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return nums[front];
    }

    /*返回数组 */
    public int[] toArray(){
        //仅转换有效长度范围的列表元素
        int[] res = new int[queSize];
        for (int i=0, j=front; i< queSize; i++, j++){
            res[i] = nums[j % capacity()];
        }
        return res;
    }
}
