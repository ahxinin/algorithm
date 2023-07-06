package com.ahxinin.datastructure;

/**
 * 链表节点类
 */
public class ListNode {
    //节点值
    public int val;

    //指向下一个节点的指针
    public ListNode next;

    //指向前一个节点的指针
    public ListNode prev;

    //构造函数
    public ListNode(int x){
        val = x;
        prev = next = null;
    }
}
