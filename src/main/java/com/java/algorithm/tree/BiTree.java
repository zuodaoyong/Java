package com.java.algorithm.tree;

public class BiTree {

	private BiTNode rootNode;

	private void initBiTree() {
		this.rootNode = new BiTNode(' ');
	}

	private void createBiTree(BiTNode rootNode, char ch) {
		if (rootNode == null)
			System.exit(0);
		if (rootNode.data == ' ') {
			rootNode.data = ch;
			BiTNode biTNode = new BiTNode(ch);
			rootNode.lchild = biTNode;
			rootNode.rchild = biTNode;
			createBiTree(rootNode.lchild, '2');
			createBiTree(rootNode.rchild, '2');
		}
	}
	public static void main(String[] args) {
		BiTree biTree = new BiTree();
		biTree.initBiTree();
		biTree.createBiTree(biTree.rootNode,'a');
	}
}

class BiTNode {
	char data;
	BiTNode lchild, rchild;

	public BiTNode(char data) {
		super();
		this.data = data;
	}

	public BiTNode() {
	}
}