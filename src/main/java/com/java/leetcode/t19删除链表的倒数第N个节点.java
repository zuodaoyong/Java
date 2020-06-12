package com.java.leetcode;


/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 */
public class t19删除链表的倒数第N个节点 {
    public static void main(String[] args) {

    }




    //head->1->2->3->4->5
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        ListNode newHead=new ListNode(-1);
        newHead.next=head;

        ListNode pre=newHead;
        ListNode current=newHead;
        int k=0;
        while (current.next!=null){
            current=current.next;
            k++;
            if(k>n){
                pre=pre.next;
            }
        }
        pre.next=pre.next.next;
        return newHead.next;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
