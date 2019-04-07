package list;
//有序链表测试
public class TestOrderLinkedList {

	public static void main(String[] args) {
		OrderLinkedList list = new OrderLinkedList();
		list.insert(1);
		list.insert(6);
		list.insert(0);
		list.display();
		list.insert(3);
		list.display();
		list.deleteHead();
		list.display();

	}

}
