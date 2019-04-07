package queue;

public class TestMyQueue {

	public static void main(String[] args) {
		Myqueue myqueue = new Myqueue(3);
		myqueue.insert(1);
		myqueue.insert(2);
		myqueue.insert(3);
		//System.out.println(myqueue.peek());
		//myqueue.display();
		myqueue.remove();
		//System.out.println(myqueue.peek());
		//myqueue.display();
		myqueue.insert(4);
		//System.out.println(myqueue.peek());
		//myqueue.display();
		myqueue.insert(5);
		myqueue.insert(6);
		System.out.println(myqueue.peek());
		myqueue.display();
	}

}
