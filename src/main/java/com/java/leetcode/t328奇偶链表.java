package com.java.leetcode;


/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class t328奇偶链表 {

    public static void main(String[] args) {
        ListNode root = init();
        oddEvenList(root);

    }

    private static ListNode init(){
        int[] arr={1,2,3,4,5};
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

    public static ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        int i=1;
        ListNode curr=head;
        ListNode p1=null;//奇数头节点
        ListNode p1_temp=null;
        ListNode p2=null;//偶数头节点
        ListNode p2_temp=null;
        while (curr!=null){
            if(i%2!=0){//奇数
                if(p1==null){
                    p1=curr;
                    p1_temp=p1;
                }else {
                   p1_temp.next=curr;
                   p1_temp=curr;
                }
            }else{//偶数
                if(p2==null){
                    p2=curr;
                    p2_temp=p2;
                }else{
                    p2_temp.next=curr;
                    p2_temp=curr;
                }
            }
            i++;
            curr=curr.next;
        }
        p1_temp.next=p2;
        p2_temp.next=null;
        return p1;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
