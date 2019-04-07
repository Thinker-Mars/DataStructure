package stack;

//简单顺序栈
public class MyStack {
	private int[] array;
	private int maxSize;
	private int top;
	
	public MyStack(int size) {
		this.maxSize = size;
		array = new int[size];
		top = -1;
	}
	//进栈
	public void push(int value) {
		if (top < maxSize - 1) {
			array[++top] = value;
		}
	}
	//删除栈顶数据
	public int pop() {
		return array[top--];
	}
	//访问栈顶数据
	public int peek() {
		return array[top];
	}
	//判断栈是否为空,若为空，则返回false
	public boolean isEmpty() {
		return (top == -1);
	}
	
	//判断栈是否已满
	public boolean isFull() {
		return (top == (maxSize-1));
	}

}
