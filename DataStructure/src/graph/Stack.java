package graph;

/**
 * 深度优先搜索所使用的栈
 * @author Cone
 * @since 2019年7月23日
 *
 */
public class Stack {
	
	private final int SIZE = 20;
	private int[] stackArray;
	private int top;//指针，指向栈顶元素
	
	public Stack() {
		
		stackArray = new int[SIZE];
		top = -1;
	}
	
	/**
	 * 进栈
	 * @param value
	 */
	public void push(int value) {
		
		stackArray[++top] = value;
	}
	
	/**
	 * 出栈
	 * @return
	 */
	public int pop() {
		
		return stackArray[top--];
	}
	
	/**
	 * 查看栈顶元素
	 * @return
	 */
	public int peek() {
		
		return stackArray[top];
	}
	
	/**
	 * 栈是否为空
	 * @return
	 */
	public boolean isEmpty() {
		
		return (top == -1);
	}

}
