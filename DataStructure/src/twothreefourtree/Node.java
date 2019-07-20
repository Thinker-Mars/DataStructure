package twothreefourtree;

/**
 * 节点类
 * @author Cone
 * @since 2019年7月15日
 *
 */
public class Node {
	
	private static final int order = 4;
	
	private int numItems;//数据项个数
	
	private Node parent;//父节点
	
	private Node childrenArray[] = new Node[order];//一个节点最多有4个子节点
	
	private DataItem itemArray[] = new DataItem[order - 1];//一个节点最多有3个数据项
	
	/**
	 * 连接子节点
	 * @param childNum 节点数组的索引
	 * @param child 要连接的节点
	 */
	public void connectChild(int childNum, Node child) {
		
		childrenArray[childNum] = child;
		if (child != null) {
			child.parent = this;
		}
	}
	
	/**
	 * 断开与子节点的连接，并返回该子节点
	 * @param childNum 节点数组的索引
	 * @return 断开的子节点
	 */
	public Node disconnectChild(int childNum) {
		
		Node currentNode = childrenArray[childNum];
		childrenArray[childNum] = null;
		return currentNode;
	}
	
	/**
	 * 得到节点的某个子节点
	 * @param childNum 节点数组的索引
	 * @return
	 */
	public Node getChild(int childNum) {
		
		return childrenArray[childNum];
	}
	
	/**
	 * 得到父节点
	 * @return
	 */
	public Node getParent() {
		return parent;
	}
	
	/**
	 * 判断是否是叶节点
	 */
	public boolean isLeaf() {
		return (childrenArray[0]) == null ? true : false;
	}
	
	/**
	 * 得到节点数据项的个数
	 * @return
	 */
	public int getNumItems() {
		return numItems;
	}
	
	/**
	 * 得到节点的某个数据项
	 * @param index 节点索引
	 * @return
	 */
	public DataItem getItem(int index) {
		return itemArray[index];
	}
	
	/**
	 * 判断节点的数据项是否满了
	 * @return
	 */
	public boolean isFull() {
		return (numItems == order - 1) ? true : false;
	}
	
	/**
	 * 找到数据项在节点中的位置
	 * @param key 关键值value
	 * @return 节点索引，-1表示不存在
	 */
	public int findItem(long key) {
		for(int i = 0; i < order - 1; i++) {
			if (itemArray[i] == null) {
				break;
			}
			else {
				if (itemArray[i].data == key) {
					return i;
				}
				else  {
					continue;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 将数据项插入到节点
	 * @param newItem 新数据项
	 * @return 数据项在node中的索引
	 */
	public int insertItem(DataItem newItem) {
		
		numItems++;
		long newKey = newItem.data;//新插入数据项的值
		for (int i = order - 2; i >= 0; i--) {
			if (itemArray[i] == null) {
				continue;
			}
			else {
				long itemKey = itemArray[i].data;//已有数据项的值
				if (itemKey > newKey) {
					itemArray[i + 1] = itemArray[i];//大的数据项往后移动
				}
				else {
					itemArray[i + 1] = newItem;
					return i + 1;
				}
			}
		}
		//能走到这里说明当前节点没有数据项或者新插入的数据项均比当前数据项都小
		//那么将新插入的数据项放在第一位
		itemArray[0] = newItem;
		return 0;
	}
	
	/**
	 * 移除节点的数据项
	 * @return 从最右边开始移除数据项，返回被移除的数据项
	 */
	public DataItem removeItem() {
		DataItem temp = itemArray[numItems - 1];
		itemArray[numItems - 1] = null;
		numItems--;
		return temp;
	}
	
	/**
	 * 打印节点的所有数据项
	 */
	public void displayNode() {
		//以下两种遍历方式均可
		//采用第一种方式时，切记要判断dataItem是否为null，否则会抛空指针异常
		//因为试图对null进行getter操作
		for(DataItem dataItem  : itemArray) {
			if (dataItem == null) {
				System.out.println(" null ");
			}
			else {
				dataItem.display();
			}
		}
		
//		for(int i = 0; i < numItems; i++) {
//			itemArray[i].display();
//		}
		
		

		
	}
	

}
