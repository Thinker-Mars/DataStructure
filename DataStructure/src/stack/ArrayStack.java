package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

//增强功能版栈
public class ArrayStack {
	private Object[] elementData;
	private int top;
	private int size;
	
	public ArrayStack() {
		elementData = new Object[4];
		top = -1;
		this.size = 4;
	}
	
	public ArrayStack(int size) {
		if (size < 0) {
			throw new IllegalArgumentException("栈初始容量不能小于0" + size);
		}
		elementData = new Object[size];
		top = -1;
		this.size = size;
	}
	//判断是否需要扩容
	public boolean isGrow(int inputSize) {
		int oldSize = size;
		if (oldSize >= inputSize) {
			int newSize = 0;
			if ((oldSize<<1) - Integer.MAX_VALUE > 0) {
				newSize = Integer.MAX_VALUE;
			}
			else {
				newSize = (oldSize<<1);
			}
			elementData = Arrays.copyOf(elementData, newSize);
			//elementData = new Object[newSize];
			this.size = newSize;
			return true;
		}
		
		return false;
	}
	
	//删除栈顶元素
	public void remove() {
		elementData[top] = null;
		this.top--;
	}
	
	//判断栈是否为空
	public boolean isEmpty() {
		return (top == -1);
	}
	
	//获取栈顶元素
	public Object peek() {
		if(top == -1) {
			throw new EmptyStackException();
		}
		
		return elementData[top];
	}
	
	//删除栈顶的元素
	public Object pop() {
		Object object = peek();
		remove();
		return object;
	}
	
	//压入元素
	public Object push(Object value) {
		isGrow(top+1);
		elementData[++top] = value;
		return value;
	}


}
