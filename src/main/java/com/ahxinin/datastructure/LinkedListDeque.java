package com.ahxinin.datastructure;

/**
 * 基于双向链表实现的双向队列
 */
public class LinkedListDeque {

    private ListNode front, rear;   //头节点front, 尾节点rear
    private int queSize;    //双向队列长度

    public LinkedListDeque(){
        front = rear = null;
    }

    /*获取双向队列的长度 */
    public int size(){
        return queSize;
    }

    /*判断双向队列是否为空 */
    public boolean isEmpty(){
        return size() == 0;
    }

    /*入队操作*/
    private void push(int num, boolean isFront){
        ListNode node = new ListNode(num);
        //若链表为空，则将front,rear都指向node
        if (isEmpty()){
            front = rear = node;
        //队首入队操作
        }else if (isFront){
            //将node添加到链表头部
            front.prev = node;
            node.next = front;
            front = node;   //更新头节点
        //队尾入队操作
        }else {
            //将node添加到链表尾部
            rear.next = node;
            node.prev = rear;
            rear = node;    //更新尾节点
        }
        queSize++;  //更新队列长度
    }

    /*队首入队 */
    public void pushFirst(int num){
        push(num, true);
    }

    /*队尾入队 */
    public void pushLast(int num){
        push(num, false);
    }

    /*出队操作 */
    private Integer pop(boolean isFront){
        //若队列为空，直接返回null
        if (isEmpty()){
            return null;
        }
        int val;
        //队首出队操作
        if (isFront){
            val = front.val; //暂存头节点值
            //删除头节点
            ListNode fNext = front.next;
            if (fNext != null){
                fNext.prev = null;
                front.next = null;
            }
            front = fNext; //更新头节点
        //队尾出队操作
        }else {
            val = rear.val; //暂存尾节点值
            //删除尾节点
            ListNode rNext = rear.prev;
            if (rNext != null){
                rNext.next = null;
                rear.prev = null;
            }
            rear = rNext; //更新尾节点
        }
        queSize--;
        return val;
    }

    /*队首出队 */
    public Integer popFirst(){
        return pop(true);
    }

    /*队尾出队 */
    public Integer popLast(){
        return pop(false);
    }

    /*访问队首元素 */
    public Integer peekFirst(){
        return isEmpty() ? null : front.val;
    }

    /*访问队尾元素 */
    public Integer peekLast(){
        return isEmpty() ? null : rear.val;
    }

    /*返回数组 */
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
