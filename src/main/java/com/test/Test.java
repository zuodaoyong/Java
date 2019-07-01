package com.test;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Test {

	public static void main(String[] args) throws Exception {
		// 测试
		System.out.println("双向链表的测试");
		// 先创建节点
		HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
		// 创建一个双向链表
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(hero1);

		doubleLinkedList.list();



	}

}
// 创建一个双向链表的类
class DoubleLinkedList {

	// 先初始化一个头节点, 头节点不要动, 不存放具体的数据
	private HeroNode2 head = new HeroNode2(0, "", "");


	// 遍历双向链表的方法
	// 显示链表[遍历]
	public void list() {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点，不能动，因此我们需要一个辅助变量来遍历
		HeroNode2 temp = head.next;
		while (true) {
			// 判断是否到链表最后
			if (temp == null) {
				break;
			}
			// 输出节点的信息
			System.out.println(temp);
			// 将temp后移， 一定小心
			temp = temp.next;
		}
	}

	// 添加一个节点到双向链表的最后.
	public void add(HeroNode2 heroNode) {

		HeroNode2 temp = head;
		temp.next = heroNode;
		heroNode.pre = temp;
	}


}

// 定义HeroNode2 ， 每个HeroNode 对象就是一个节点
class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next; // 指向下一个节点, 默认为null
	public HeroNode2 pre; // 指向前一个节点, 默认为null
	// 构造器

	public HeroNode2(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	// 为了显示方法，我们重新toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}
