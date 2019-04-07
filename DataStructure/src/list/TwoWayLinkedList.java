package list;

//双向链表
public class TwoWayLinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	public TwoWayLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}
	
	
	private class Node {
		private Object data;
		private Node next;//指向下一个
		private Node prev;//指向上一个
		public Node (Object data) {
			this.data = data;
		}
	}
	
	//在链表头部增加数据
	public void addHead(Object data) {
		Node newNode = new Node(data);
		if (size == 0) {
			head = newNode;
			tail = newNode;
			size++;
		}
		else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
			size++;
		}
	}
	
	//在链表尾部添加数据
	public void addTail(Object data) {
		Node newNode = new Node(data);
		if (size == 0) {
			head = newNode;
			tail = newNode;
			size++;
		}
		else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			size++;
		}
	}
	
	//删除链表头数据
	public Node deleteHead() {
		Node temp = head;
		if (size != 0) {
			head = head.next;
			head.prev = null;
			size--;
		}
		return temp;
	}
	
	//删除链表尾部数据
	public Node deleteTail() {
		Node temp = tail;
		if (size != 0) {
			tail = tail.prev;
			tail.next = null;
			size--;
		}
		return temp;
	}
	
	//展示双向链表数据
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
