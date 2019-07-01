package com.java.algorithmv2.线性结构;

public class 双向链表 {


    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();

        linkedList.add(1,"宋江","及时雨");

        linkedList.show();
    }



}

 class LinkedList{
    private Node2 head=new Node2(null,null,null);

    public void add(int no,String name,String nickName){
        Node2 temp=head;
        Node2 node=new Node2(no,name,nickName);
        while (temp.next!=null){
            temp=temp.next;
        }
        //node.next=temp.next;
        temp.next=node;
        node.pre=temp;

    }
    public void show(){
        Node2 temp=head;
        while(temp.next!=null){
            System.out.println(temp.next);
            temp=temp.next;
        }
    }
}
class Node2{
    public Integer no;
    public String name;
    public String nickName;
    public Node2 next;
    public Node2 pre;
    public Node2(Integer no,String name,String nickName){
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                ", pre=" + pre +
                '}';
    }
}