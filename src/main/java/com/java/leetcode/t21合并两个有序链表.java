package com.java.leetcode;


/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class t21合并两个有序链表 {
    public static void main(String[] args) {


    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1;
        p1=l1;
        ListNode p2;
        p2=l2;
        ListNode newHead=new ListNode(-1);
        ListNode newp=newHead;
        while (p1!=null&&p2!=null){
            if(p1.val>=p2.val){
                newp.next=p2;
                newp=newp.next;
                p2=p2.next;
            }else{
                newp.next=p1;
                newp=newp.next;
                p1=p1.next;
            }
        }
        if(p1!=null){
            newp.next=p1;
        }
        if(p2!=null){
            newp.next=p2;
        }
        return newHead.next;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
