package com.java.algorithmv2.线性结构;

public class 单链表 {


    public static void main(String[] args) {
        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.addNodeByNoOrder(3,"李逵","黑旋风");
        singleLinkedList.addNodeByNoOrder(1,"宋江","及时雨");
        singleLinkedList.addNodeByNoOrder(4,"李冲","豹子头");
        singleLinkedList.addNodeByNoOrder(2,"卢俊义","玉麒麟");
        singleLinkedList.show();
        //singleLinkedList.deleteNode(1);
        //singleLinkedList.show();
    }
}

class SingleLinkedList{
   private Node head=new Node(null,null,null);
    public void deleteNode(int no){
        Node p=this.head;
        while (p.next!=null){
            if(p.next.no==no){
                p.next=p.next.next;
                return;
            }
            p=p.next;
        }
    }

    public void addNode(int no,String name,String nickName){
        Node node = new Node(no, name, nickName);
        Node p=this.head;
        while (p.next!=null){
            p=p.next;
        }
        node.next=null;
        p.next=node;
    }

    public void addNodeByNoOrder(int no,String name,String nickName){
        Node p=this.head;
        while (true){
            if(p.next==null){
                break;
            }else if(p.next.no>no){
                break;
            }else if(p.next.no==no){
                System.out.println("已有该元素，不能添加");
                return;
            }
            p=p.next;
        }
        Node node = new Node(no, name, nickName);
        node.next=p.next;
        p.next=node;


//        if(p.next==null){
//            Node node = new Node(no, name, nickName);
//            node.next=null;
//            p.next=node;
//            return;
//        }
//        while (p.next!=null){
//            if(p.next.no==no){
//                System.out.println("已有该元素，不能添加");
//                return;
//            }
//            if(p.next.no<no){
//                p=p.next;
//            }else{
//                Node node = new Node(no, name, nickName);
//                node.next=p.next;
//                p.next=node;
//                return;
//            }
//        }
//        Node node = new Node(no, name, nickName);
//        node.next=null;
//        p.next=node;
    }

    public void show(){
        Node p=this.head;
        while (p.next!=null){
            System.out.println("no:"+p.next.no+",name:"+p.next.name+",nickName:"+p.next.nickName);
            p=p.next;
        }
    }
}
class Node{
    public Integer no;
    public String name;
    public String nickName;
    public Node next;
    public Node(Integer no,String name,String nickName){
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }

}
