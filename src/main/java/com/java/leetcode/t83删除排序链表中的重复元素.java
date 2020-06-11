package com.java.leetcode;


/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class t83删除排序链表中的重复元素 {

    public static void main(String[] args) {


    }

    //[1,1,1,2,3,3,4,4,5]
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
       ListNode pre=head;
       ListNode currrent=head.next;
       while (currrent!=null){
           if(currrent.val==pre.val){
               pre.next=currrent.next;
           }else{
               pre=pre.next;
           }
           currrent=currrent.next;
       }
       return head;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

}
