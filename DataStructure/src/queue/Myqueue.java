package queue;

public class Myqueue {
	private Object[] queArray;
	private int maxSize;//队列元素最大值
	private int front;//队头指针
	private int rear;//队尾指针
	private int nItems;//队列内元素数目
	
	public Myqueue(int size) {
		this.maxSize = size;
		queArray = new Object[size];
		this.front = 0;
		this.rear = -1;
		this.nItems = 0;
	}
	
	//插入数据
	public void insert(int value) {
		if (isFull()) {
			System.out.println("队列已满，无法插入新的数据!");
		}
		else {
			if (rear == (maxSize-1)) {
				rear = -1;
			}
			queArray[++rear] = value;
			nItems++;
		}
		
	}
	
	//删除数据
	public Object remove() {
		Object removeValue = null;
		if (isEmpty()) {
			return removeValue;
		}
		else {
			removeValue = queArray[front];
			queArray[front++] = null;
			if (front == maxSize) {
				front = 0;
			}
			nItems--;
			return removeValue;
		}
	}
	
	//查看队头元素
	public Object peek() {
		return queArray[front];
	}
	
	//查看队列大小
	public int getSize() {
		return nItems;
	}
	
	//队列是否为空
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	//队列是否已满
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	//展示队列元素数据
	public void display() {
		for (int i = 0; i < queArray.length; i++) {
			System.out.print(queArray[i]+ " ");
		}
		System.out.println();
	}

}
