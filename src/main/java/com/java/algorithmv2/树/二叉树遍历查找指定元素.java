package com.java.algorithmv2.树;

/**
 *        1
 *     2    3
 *        4   5
 */
public class 二叉树遍历查找指定元素 {
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
        binaryTree.preSearch(4);
        binaryTree.midSearch(4);
        binaryTree.postSearch(4);
    }


    static class BinaryTree{
        private TreeNode root;

        public BinaryTree(TreeNode root){
            this.root=root;
        }

        public void preSearch(int e){
            TreeNode treeNode = this.root.preSearch(e);
            System.out.println(treeNode);
        }

        public void midSearch(int e){
            TreeNode treeNode = this.root.minSearch(4);
            System.out.println(treeNode);
        }

        public void postSearch(int e){
            TreeNode treeNode = this.root.postSearch(e);
            System.out.println(treeNode);
        }
    }
    static class TreeNode{
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

        public TreeNode preSearch(int e){
            System.out.println("前序遍历");
            if(this.data==e){
                return this;
            }
            TreeNode treeNode=null;
            if(this.left!=null){
                treeNode=this.left.preSearch(e);
            }
            if(treeNode!=null){
                return treeNode;
            }
            if(this.right!=null){
                treeNode=this.right.preSearch(e);
            }
            return treeNode;
        }

        public TreeNode minSearch(int e){
            TreeNode treeNode=null;
            if(this.left!=null){
                treeNode=this.left.minSearch(e);
            }
            if(treeNode!=null){
                return treeNode;
            }
            System.out.println("中序遍历");
            if(this.data==e){
                return this;
            }
            if(this.right!=null){
                treeNode=this.right.minSearch(e);
            }
            return treeNode;
        }

        public TreeNode postSearch(int e){
            TreeNode treeNode=null;
            if(this.left!=null){
                treeNode=this.left.postSearch(e);
            }
            if(treeNode!=null){
                return treeNode;
            }
            if(this.right!=null){
                treeNode=this.right.postSearch(e);
            }
            if(treeNode!=null){
                return treeNode;
            }
            System.out.println("后序遍历");
            if(this.data==e){
                return this;
            }
            return treeNode;
        }
    }
}
