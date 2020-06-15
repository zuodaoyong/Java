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

    }

    public static boolean isPalindrome(ListNode head) {
        boolean flag=false;
        if(head==null){
            return true;
        }
        if(head!=null&&head.next==null){
            return true;
        }
        ListNode p=head;
        Stack<Integer> stack=new Stack<>();
        while (p!=null){
            Integer top=!stack.empty()?stack.elementAt(stack.size()-1):null;
            Integer next=!stack.empty()&&stack.size()-2>=0?stack.elementAt(stack.size()-2):null;
            if(top!=null&&top.intValue()==p.val){
                stack.pop();
            }else if(next!=null&&!flag&&next.intValue()==p.val){
                stack.pop();
                stack.pop();
                flag=true;
            }else {
                stack.push(p.val);
            }
            p=p.next;
        }
        if(stack.size()==0){
            return true;
        }
        return false;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
