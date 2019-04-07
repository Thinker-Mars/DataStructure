package list;
//双端链表
public class DoublePointLink {
	
	private Node head;//头部
	private Node tail;//尾部
	private int size;//链表大小
	
	public DoublePointLink() {
		head = null;
		tail = null;
		size = 0;
	}
	
	private class Node {
		private Object data;
		private Node next;
		public Node(Object obj) {
			this.data = obj;
		}
	}
	
	//在头部增加元素
	public void addHead(Object obj) {
		Node node = new Node(obj);
		if(size == 0) {
			head = node;
			tail = node;
			size++;
		}
		else {
			node.next = head;
			head = node;
			size++;
		}
	}
	
	//在尾部增加元素
	public void addTail(Object obj) {
		Node node = new Node(obj);
		if(size == 0) {
			head = node;
			tail = node;
			size++;
		}
		else {
			tail.next = node;
			tail = node;
			size++;
		}
	}
	
	//删除头部节点,成功返回true，失败返回false
	public boolean deleteHead() {
		if(isEmpty()) {
			return false;
		}
		else {
			if (head.next == null) {
				head = null;
				tail = null;
			}
			else {
				head = head.next;
			}
			size--;
			return true;
		}
	}
	
	//判断链表是否为空,空则返回true
	public boolean isEmpty() {
		return (size == 0);
	}
	
	//获取链表大小
	public int getSize() {
		return size;
	}
	
	//展示链表元素
	public void display() {
		Node node = head;
		int tempSize = size;
		if(isEmpty()) {
			System.out.println("[]");
		}
		else {
			if(size == 1) {
				System.out.print("[" +node.data + "]");
			}
			while(tempSize > 0) {
				if(node.equals(head)) {
					System.out.print("[" + node.data + "=>");
				}
				else if(node.next == null) {
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
	}
	
	

}
