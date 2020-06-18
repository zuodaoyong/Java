package com.java.leetcode;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class t234回文链表 {
    public static void main(String[] args) {
        ListNode head = init();
        isPalindrome(head);
    }

    private static ListNode  init(){
        int[] arr={1,3,4,4,1};
        ListNode head=null;
        ListNode p=null;
        for(int i=0;i<arr.length;i++){
            if(head==null){
               head=new ListNode(arr[i]);
               p=head;
            }else {
                ListNode node=new ListNode(arr[i]);
                p.next=node;
                p=node;
            }
        }
        return head;
    }

    public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        ListNode p=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
        //切割链表
        while (p.next!=slow){
            p=p.next;
        }
        p.next=null;
        //链表转置
        ListNode newHead=null;
        ListNode newNode=null;
        while (slow!=null){
            newNode=slow.next;
            slow.next=newHead;
            newHead=slow;
            slow=newNode;
        }
        //判断回文
        while (newHead!=null&&head!=null){
            if(newHead.val!=head.val){
                return false;
            }
            newHead=newHead.next;
            head=head.next;
        }
        return true;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
