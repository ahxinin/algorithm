package com.ahxinin.datastructure;

/**
 * 基于环形数组实现双向队列
 */
public class ArrayDeque {

    private int[] nums; //用于存储双向队列元素的数组
    private int front; //队首指针，指向队首元素
    private int queSize; //双向队列长度

    public ArrayDeque(int capacity){
        this.nums = new int[capacity];
        front = queSize = 0;
    }

    /*获取双向队列的容量 */
    public int capacity(){
        return nums.length;
    }

    /*获取双向队列的长度 */
    public int size(){
        return queSize;
    }

    /*判断双向队列是否为空 */
    public boolean isEmpty(){
        return queSize == 0;
    }

    /*计算环形数组索引 */
    private int index(int i){
        //通过取余操作实现数组首尾相连
        //当 i 超过数组尾部时，回到头部
        //当 i 超过数组头部时，回到尾部
        return (i + capacity()) % capacity();
    }

    /*队首入队 */
    public void pushFirst(int num){
        //队列已满
        if (queSize == capacity()){
            return;
        }
        //队首指针向左移动一位
        //通过取余操作，实现front越过数组头部后回到尾部
        front = index(front - 1);
        //将num添加到队首
        nums[front] = num;
        queSize++;
    }

    /*队尾入队 */
    public void pushLast(int num){
        //队列已满
        if (queSize == capacity()){
            return;
        }
        //计算尾指针，指向队尾索引+1
        int rear = index(front + queSize);
        //将num添加到队尾
        nums[rear] = num;
        queSize++;
    }

    /*队首出队 */
    public int popFirst(){
        int num = peekFirst();
        //队首指针向后移动一位
        front = index(front + 1);
        queSize--;
        return num;
    }

    /*队尾出队 */
    public int popLast(){
        int num = peekLast();
        queSize--;
        return num;
    }

    /*访问队首元素 */
    public int peekFirst(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return nums[front];
    }

    /*访问队尾元素 */
    public int peekLast(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        //计算尾元素索引
        int last = index(front + queSize + 1);
        return nums[last];
    }
}
