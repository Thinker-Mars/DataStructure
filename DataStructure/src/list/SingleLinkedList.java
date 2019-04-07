package list;
//单向链表
public class SingleLinkedList {
	private Node head;
	private int size;
	
	public SingleLinkedList() {
		size = 0;
		head = null;
	}
	
	//node类
	private class Node{
		private Object data;//每个节点的数据
		private Node next;//指向下一个节点的链接
		
		public Node(Object data) {
			this.data = data;
		}
	}
	
	//在链表头添加元素
	public Object addHead(Object obj) {
		Node newHead = new Node(obj);
		if (size == 0) {
			head = newHead;
		}
		else {
			newHead.next = head;
			head = newHead;
		}
		size++;
		return obj;
	}
	
	//在链表头删除元素
	public Object delHead() {
		Object obj = head.data;
		head = head.next;
		size--;
		return obj;
	}
	
	//查找指定元素，找到返回节点node，找不到返回null
	public Node search(Object obj) {
		Node current = head;
		int tempSize = size;
		while (tempSize > 0) {
			if (obj.equals(current.data)) {
				return current;
			}
			else {
				current = current.next;
				
			}
			tempSize--;
		}
		return null;
	}
	
	//删除指定的元素，成功返回true
	public boolean delete(Object obj) {
		if (size == 0) {
			return false;
		}
		Node current = head;
		Node previous = head;
		while (current.data != obj) {
			if (current.next == null) {
				return false;
			}
			else {
				previous = current;
				current = current.next;
			}
			
		}
		if (current == head) {
			head = current.next;
			size--;
		}
		else {
			previous.next = current.next;
			size--;
		}
		
		return true;
			
	}
	
	//判断链表是否为空
	public boolean isEmpty() {
		return (size == 0);
	}
	
	//展示链表元素
	public void display() {
		if (size > 0) {
			Node node = head;
			int tempSize = size;
			if (size == 1) {
				System.out.println("[" + node.data + "]");
				return;
			}
			while (tempSize > 0) {
				if (node.equals(head)) {
					System.out.print("[" + node.data + "=>");
				}
				else if (node.next == null) {
					System.out.print(node.data + "]");
				}
				else {
					System.out.print(node.data + "=>");
				}
				node = node.next;
				tempSize--;
			}
			System.out.println();
			
		}
		else {
			System.out.println("[]");
		}
	}
	
	

}
