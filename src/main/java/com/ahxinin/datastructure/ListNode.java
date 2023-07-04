package com.ahxinin.datastructure;

/**
 * 链表节点类
 */
public class ListNode {
    //节点值
    int val;

    //指向下一个节点的指针
    ListNode next;

    //指向前一个节点的指针
    ListNode prev;

    //构造函数
    ListNode(int x){
        val = x;
        prev = next = null;
    }
}
