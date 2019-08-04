package com.java.algorithmv2.线性结构;

public class 约瑟夫环 {

    public static void main(String[] args) {
        //JosephNodeList josephNodeList=new JosephNodeList(10);

    }

    class JosephNodeList{

        private Node head;

        private void init(int capacity){
           Node p;
           for(int i=0;i<capacity;i++){
              Node node=new Node();
              if(i==0){
                  head=node;
              }
              p=node;
              p.next=head;
           }
        }

        public JosephNodeList(int capacity){
           init(capacity);
        }

        public Node getHead(){
            return head;
        }
    }

    class Node{
        private Integer num;
        private Node next;
        public Integer getNum() {
            return num;
        }
        public void setNum(Integer num) {
            this.num = num;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
}

