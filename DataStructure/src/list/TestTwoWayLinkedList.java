package list;
//双向链表测试
public class TestTwoWayLinkedList {

	public static void main(String[] args) {
		TwoWayLinkedList list = new TwoWayLinkedList();
		list.addHead("D");
		list.addHead("666");
		list.addHead("B");
		list.addTail("A");
		list.display();
		list.deleteHead();
		list.display();
		list.deleteTail();
		list.display();
		

	}

}
