package com.java.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class t2两数相加 {
    public static void main(String[] args) {
        ListNode l1 = buildNodeList(new int[]{9,9});
        ListNode l2 = buildNodeList(new int[]{9});
        ListNode resNodeList = addTwoNumbers(l1, l2);
        printNodeList(resNodeList);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode q=null;
        Integer carry=null;
        while (p1!=null&&p2!=null){
            int sum=p1.val+p2.val;
            if(carry!=null){
                sum=sum+carry.intValue();
                carry=null;
            }
            int sumLen=(sum+"").length();
            if(sumLen>1){
                carry=sum/((sumLen-1)*10)%10;
                int firstBit=(sum/1)%10;//获取个位数值
                p1.val=firstBit;
            }else{
                p1.val=sum;
            }
            q=p1;
            p1=p1.next;
            p2=p2.next;
        }

        while (p1!=null){
            int sum=p1.val;
            if(carry==null){
                break;
            }
            sum=sum+carry.intValue();
            carry=null;
            int sumLen=(sum+"").length();
            if(sumLen>1){
                carry=sum/((sumLen-1)*10)%10;
                int firstBit=(sum/1)%10;//获取个位数值
                p1.val=firstBit;
            }else{
                p1.val=sum;
            }
            q=p1;
            p1=p1.next;
        }

        while (p2!=null){
            int sum=p2.val;
            if(carry!=null){
                sum=sum+carry.intValue();
                carry=null;
                int sumLen=(sum+"").length();
                if(sumLen>1){
                    carry=sum/((sumLen-1)*10)%10;
                    int firstBit=(sum/1)%10;//获取个位数值
                    q.next=new ListNode(firstBit);
                }else{
                    q.next=new ListNode(sum);
                }
            }else{
                q.next=p2;
            }
            q=q.next;
            p2=p2.next;
        }
        if(carry!=null){
            q.next=new ListNode(carry.intValue());
        }
        return l1;
    }

    private static ListNode buildNodeList(int[] nums){
        ListNode rootNode=null;
        ListNode p=null;
        for(int i=0;i<nums.length;i++){
            if(rootNode==null){
                rootNode=new ListNode(nums[i]);
                rootNode.next=null;
                p=rootNode;
            }else{
                ListNode tempNode=new ListNode(nums[i]);
                p.next=tempNode;
                p=tempNode;
            }
        }
        return rootNode;
    }

    private static void printNodeList(ListNode listNode){
        ListNode p1=listNode;
        while (p1!=null){
            System.out.print(p1.val+" ");
            p1=p1.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


