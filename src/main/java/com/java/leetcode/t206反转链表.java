package com.java.leetcode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class t206反转链表 {

    public static void main(String[] args) {

    }

    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode p=head;
        int t;
        ListNode current=head;
        while (current.next!=null){
            current=current.next;
            while (p!=current){
                t=current.val;
                current.val=p.val;
                p.val=t;
                p=p.next;
            }
            p=head;
        }
        return p;
    }



    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
     }
}
