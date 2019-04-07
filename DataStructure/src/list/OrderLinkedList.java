package list;
//有序链表
public class OrderLinkedList {
	private Node head;
	public OrderLinkedList() {
		head = null;
	}
	
	private class Node {
		private int data;
		private Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	//新增数据，按照从小到大的顺序排列
	public void insert(int data) {
		Node node = new Node(data);
		Node previous = null;
		Node current = head;
		while(current != null && data > current.data) {
			previous = current;
			current = current.next;
		}
		if (previous == null) {
			head = node;
			head.next = current;
		}
		else {
			previous.next = node;
			node.next = current;
		}
	}
	
	//删除头部数据
	public void deleteHead() {
		head = head.next;
	}
	
	//展示数据
	public void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

}
