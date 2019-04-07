package list;
//用链表实现栈
public class StackSingleLink {
	private SingleLinkedList list;
	
	public StackSingleLink() {
		list = new SingleLinkedList();
	}
	
	//在栈顶添加元素
	public void add(Object obj) {
		list.addHead(obj);
	}
	
	//在栈顶删除元素
	public Object delete() {
		return list.delHead();
	}
	
	//判断是否为空
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	//展示栈内的元素
	public void display() {
		list.display();
	}

}
