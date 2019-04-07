package stack;
//增强功能版栈测试类
public class TestArrayStack {
	public static void main(String[] args) {
		
		ArrayStack arrayStack = new ArrayStack();
		String string = "how are you";
		char[] cha = string.toCharArray();
		for(char c : cha) {
			arrayStack.push(c);
		}
		while(!arrayStack.isEmpty()) {
			System.out.print(arrayStack.pop());
		}
//		arrayStack.push(1);
//		arrayStack.push("666");
//		arrayStack.push(2);
//		arrayStack.pop();
//		arrayStack.pop();
//		System.out.println(arrayStack.peek());
	}

}
