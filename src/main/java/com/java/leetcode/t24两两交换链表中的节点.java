package com.java.leetcode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class t24两两交换链表中的节点 {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=new ListNode(-1);
        newHead.next=head;
        ListNode p=newHead;
        ListNode left=head;
        ListNode right=head;
        while (right.next!=null){
            right=right.next;
            if(left.next==right&&left==p){
                left=left.next;
            }
            if(p.next==left&&left.next==right){
                p.next=right;
                left.next=right.next;
                right.next=left;
                p=left;
            }
        }
        return newHead.next;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
