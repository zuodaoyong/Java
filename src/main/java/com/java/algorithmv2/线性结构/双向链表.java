package com.java.algorithmv2.线性结构;

public class 双向链表 {


    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        Node21 node=new Node21(1,"宋江","及时雨");
        linkedList.add(node);

        linkedList.show();
    }



}

 class LinkedList{
    private Node21 head=new Node21(null,null,null);

    public void add(Node21 node){
        Node21 temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        node.pre=temp;

    }
    public void show(){
        Node21 temp=head;
        while(temp.next!=null){
            System.out.println(temp.next);
            temp=temp.next;
        }
    }
}
class Node21{
    public Integer no;
    public String name;
    public String nickName;
    public Node21 next;
    public Node21 pre;
    public Node21(Integer no,String name,String nickName){
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