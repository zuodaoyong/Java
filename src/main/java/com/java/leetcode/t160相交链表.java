package com.java.leetcode;


import java.util.Arrays;
import java.util.List;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */
public class t160相交链表 {
    public static void main(String[] args) {

        List<Integer> listA = Arrays.asList(new Integer[]{4,1,8,4,5});
        List<Integer> listB = Arrays.asList(new Integer[]{5,0,1,8,4,5});
        ListNode nodeA = buildListNode(listA);
        ListNode nodeB = buildListNode(listB);
        getIntersectionNode(nodeA,nodeB);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode p=headA;
        ListNode q=headB;
        while (p!=q){
            p=(p==null)?headB:p.next;
            q=(q==null)?headA:q.next;
        }
        return p;
    }


    private static ListNode buildListNode(List<Integer> list){
        ListNode headNode=null;
        ListNode p=null;
        for(Integer e:list){
            if(headNode==null){
                headNode=new ListNode(e);
                p=headNode;
            }else{
                ListNode node=new ListNode(e);
                p.next=node;
                p=node;
            }
        }
        return headNode;
    }


    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
}
