package stack;

//简单顺序栈测试类
public class TestMyStack {
	
	public static void main (String[] args) {
		
		MyStack myStack = new MyStack(4);
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		System.out.println(myStack.peek());
		while(!myStack.isEmpty()) {
			System.out.println(myStack.pop());
		}
	}

}
