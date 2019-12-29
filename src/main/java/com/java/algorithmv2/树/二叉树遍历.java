package com.java.algorithmv2.树;

/**
 *        1
 *     2    3
 *        4   5
 */
public class 二叉树遍历 {

    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode3.setLeft(treeNode4);
        treeNode3.setRight(treeNode5);

        BinaryTree binaryTree=new BinaryTree(treeNode1);
        binaryTree.prePrint();//1 2 3 4 5
        binaryTree.midPrint();//2 1 4 3 5
        binaryTree.postPrint();//2 4 5 3 1
    }
}

class BinaryTree{
    private TreeNode root;
    public BinaryTree(TreeNode root){
        this.root=root;
    }

    public void prePrint(){
        if(this.root==null){
            System.out.println("树为空");
        }
        this.root.prePrint();
    }

    public void midPrint(){
        if(this.root==null){
            System.out.println("树为空");
        }
        this.root.midPre();
    }

    public void postPrint(){
        if(this.root==null){
            System.out.println("树为空");
        }
        this.root.postPrint();
    }
}

class TreeNode{
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data){
        this.data=data;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }

    /**
     * 先序遍历
     */
    public void prePrint(){
        System.out.println(this);//先遍历父节点
        if(this.left!=null){
            this.left.prePrint();
        }
        if(this.right!=null){
            this.right.prePrint();
        }
    }

    /**
     * 中序遍历
     */
    public void midPre(){
        if(this.left!=null){
            this.left.midPre();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.midPre();
        }
    }

    /**
     * 后序遍历
     */
    public void postPrint(){
        if(this.left!=null){
            this.left.postPrint();
        }
        if(this.right!=null){
            this.right.postPrint();
        }
        System.out.println(this);
    }
}