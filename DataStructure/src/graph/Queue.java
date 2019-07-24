package graph;

/**
 * 广度优先搜索所使用的队列
 * @author Cone
 * @since 2019年7月24日
 *
 */
public class Queue {
	
	private final int SIZE = 20;
	private int[] queueArray;
	private int front;//指向队列头部
	private int rear;//指向队列尾部
	
	public Queue() {
		
		queueArray = new int[SIZE];
		front = 0;
		rear = -1;
	}
	
	/**
	 * 向队列中添加元素
	 * @param value
	 */
	public void insert(int value) {
		
		if(rear == (SIZE - 1)) {
			rear = -1;
		}
		queueArray[++rear] = value;
	}
	
	/**
	 * 删除队列头部元素
	 * @return 要删除的值
	 */
	public int remove() {
		
		int temp = queueArray[front++];
		if(front == SIZE) {
			front = 0;
		}
		return temp;
	}
	
	/**
	 * 队列空时返回true
	 * @return
	 */
	public boolean isEmpty() {
		
		//或条件中，前者表示队列刚被初始化的情况，后者表示队列内元素被移除完的情况
		return (rear + 1 == front || front + SIZE == rear + 1);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
