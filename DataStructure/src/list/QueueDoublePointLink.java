package list;
//用双端链表实现队列
public class QueueDoublePointLink {
	private DoublePointLink link;
	
	public QueueDoublePointLink() {
		link = new DoublePointLink();
	}
	
	//在队列尾部插入元素
	public void add(Object obj) {
		link.addTail(obj);
	}
	
	//在队列头部删除元素
	public void delete() {
		link.deleteHead();
	}
	
	//判断队列是否为空
	public boolean isEmpty() {
		return link.isEmpty();
	}
	
	//获取队列大小
	public int getSize() {
		return link.getSize();
	}
	
	//展示队列元素
	public void display() {
		link.display();
	}

}
