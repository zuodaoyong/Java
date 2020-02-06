package com.java.algorithmv2.树;

/**
 * 以中序线索化二叉树为例
 *              1
 *          3        6
 *       8    10   14
 */
public class 线索化二叉树 {


    public static void main(String[] args) {

        TreeNode node1=new TreeNode(1);
        TreeNode node3=new TreeNode(3);
        TreeNode node6=new TreeNode(6);
        TreeNode node8=new TreeNode(8);
        TreeNode node10=new TreeNode(10);
        TreeNode node14=new TreeNode(14);

        node1.setLeft(node3);
        node1.setRight(node6);
        node3.setLeft(node8);
        node3.setRight(node10);
        node6.setLeft(node14);

        ThreadedBinaryTree threadedBinaryTree=new ThreadedBinaryTree(node1);
        //threadedBinaryTree.midThreadedBinaryTree(node1);
        //threadedBinaryTree.midThreadedBinaryTreePrint();
        threadedBinaryTree.preThreadedBinaryTree(node1);
        //System.out.println("node10的前驱节点="+node10.getLeft());
        //System.out.println("node10的后继节点="+node10.getRight());
        threadedBinaryTree.preThreadedBinaryTreePrint();
    }

    static class ThreadedBinaryTree{

        private TreeNode root;
        public ThreadedBinaryTree(TreeNode root){
            this.root=root;
        }
        private TreeNode pre;//标记当前节点的前驱节点的指针

        //前序线索化二叉树1,3,8,10,6,14
        public void preThreadedBinaryTree(TreeNode node){
            if(node==null){
                return;
            }
            //线索化当前节点
            if(node.getLeft()==null){
                node.setLeft(pre);
                node.setLeftType(1);
            }

            if(pre!=null&&pre.getRight()==null){
                pre.setRightType(1);
                pre.setRight(node);
            }
            pre=node;
            //线索化左子树
            if(node.getLeftType()==0){
                preThreadedBinaryTree(node.getLeft());
            }
            //线索化右子树
            if(node.getRightType()==0){
                preThreadedBinaryTree(node.getRight());
            }

        }

        //遍历前序线索化二叉树
        public void preThreadedBinaryTreePrint(){
            TreeNode node=this.root;
            while (node!=null){
                System.out.println(node);
                while (node.getLeftType()==0){
                    node=node.getLeft();
                    System.out.println(node);
                }
                //重置节点
                node=node.getRight();
            }
        }

        //中序线索化二叉树
        public void midThreadedBinaryTree(TreeNode node){
             //判断节点是否为空
            if(node==null){
                return;
            }
            //线索化左子树
            midThreadedBinaryTree(node.getLeft());
            //线索化当前节点
            if(node.getLeft()==null){
                node.setLeft(pre);
                node.setLeftType(1);
            }
            //处理当前节点的后继节点的思路是当node指向下一个节点，
            // pre指向当前节点时，由pre设置，好好思考下
            if(pre!=null&&pre.getRight()==null){
                pre.setRight(node);
                pre.setRightType(1);
            }
            //变更pre指针信息
            pre=node;
            //线索化右子树
            midThreadedBinaryTree(node.getRight());
        }

        /**
         * 遍历中序线索化二叉树
         */
        public void midThreadedBinaryTreePrint(){
            TreeNode node=this.root;
            while (node!=null){
                //循环找到第一个leftType=1的节点
                while (node.getLeftType()==0){
                    node=node.getLeft();
                }
                System.out.println(node);
                //如果当前节点的右指针指向的是后继节点，就一直输出
                while (node.getRightType()==1){
                    node=node.getRight();
                    System.out.println(node);
                }
                //重置节点
                node=node.getRight();
            }

        }


    }

    static class TreeNode{
        private int data;
        private TreeNode left;
        private int leftType;//0：指向左子树，1：指向前驱节点
        private TreeNode right;
        private int rightType;//0：指向右子树，1：指后继节点

        public TreeNode(int data){
            this.data=data;
        }

        public int getLeftType() {
            return leftType;
        }

        public void setLeftType(int leftType) {
            this.leftType = leftType;
        }

        public int getRightType() {
            return rightType;
        }

        public void setRightType(int rightType) {
            this.rightType = rightType;
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
    }
}
