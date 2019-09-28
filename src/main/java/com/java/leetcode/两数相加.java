package com.java.leetcode;

import com.common.CommonUtils;
import org.springframework.util.StringUtils;

import java.util.Scanner;
import java.util.Stack;

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
public class 两数相加 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split("\\+");
        Stack<String> aStack=inStack(split[0]);
        Stack<String> bStack=inStack(split[1]);

        ListNode aListNode=inListNode(aStack);
        ListNode bListNode=inListNode(bStack);

        aListNode.print();
        bListNode.print();
    }

    private static Stack<String> inStack(String s){
        Stack<String> stack=new Stack<>();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(CommonUtils.isNumber(chars[i])){
                stack.push(String.valueOf(chars[i]));
            }
        }
        return stack;
    }

    private static ListNode inListNode(Stack<String> aStack){
        ListNode listNode=new ListNode();
        while (!aStack.empty()){
            listNode.addNode(Integer.valueOf(aStack.pop()));
        }
        return listNode;
    }

    //private static ListNode
}

class ListNode{
    Node head=new Node();
    public void addNode(int e){
        Node node=new Node();
        node.data=e;
        if(head.next!=null){
            node.next=head.next;
        }
        head.next=node;
    }

    public void print(){
        Node p=head.next;
        while (p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println();
    }
}

class Node{
    int data;
    Node next;
}
