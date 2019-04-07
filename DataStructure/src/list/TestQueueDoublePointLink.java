package list;
//双端链表实现队列测试
public class TestQueueDoublePointLink {

	public static void main(String[] args) {
		QueueDoublePointLink myQueue = new QueueDoublePointLink();
		myQueue.add("D");
		myQueue.add("666");
		myQueue.add("cone");
		myQueue.display();
		System.out.println(myQueue.getSize());
		myQueue.delete();
		myQueue.display();
		System.out.println(myQueue.getSize());

	}

}
