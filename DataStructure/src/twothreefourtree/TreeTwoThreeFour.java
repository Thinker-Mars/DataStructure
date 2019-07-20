package twothreefourtree;


/**
 * 2-3-4树实现类
 * @author Cone
 * @since 2019年7月16日
 *
 */
public class TreeTwoThreeFour {
	
	private Node root = new Node();
	
	/**
	 * 寻找节点
	 * @param key 要寻找的数据项的data
	 * @return 数据项数组节点索引
	 */
	public int find(long key) {
		Node currentNode = root;
		int index;
		while (true) {
			if ((index = currentNode.findItem(key)) != -1) {
				return index;
			}
			else if (currentNode.isLeaf()) {//当前节点是叶节点则直接返回-1
				return -1;
			}
			else {
				getNextChild(currentNode, key);
			}
			
		}

	}
	
	/**
	 * 寻找给定节点的下一个子节点（key作为条件）
	 * @param currentNode 当前节点
	 * @param key 查找值key
	 * @return
	 */
	public Node getNextChild(Node currentNode, long key) {
		
		int i;
		int numItems = currentNode.getNumItems();
		for (i = 0; i < numItems; i++) {
			if (key < currentNode.getItem(i).data) {
				return currentNode.getChild(i);
			}
		}
		return currentNode.getChild(i);
	}
	
	/**
	 * 将节点插入树中
	 * @param value 要插入的值
	 * 插入时，碰到没有满的节点时，要继续向下寻找其子节点进行插入。如果直接插入该节点，那么还要进行子节点的增加
	 * 因为在2-3-4树中节点的子节点个数要比数据项多1
	 */
	public void insert(long value) {
		Node curNode = root;
		DataItem tempItem = new DataItem(value);
		while (true) {
			if (curNode.isFull()) {//节点的数据项满了，分裂节点
				split(curNode);
				curNode = curNode.getParent();
				curNode = getNextChild(curNode, value);
			}
			else if (curNode.isLeaf()) {//是叶节点，则返回
				break;
			}
			else {
				curNode = getNextChild(curNode, value);
			}
		}
		curNode.insertItem(tempItem);
	}
	
	/**
	 * 分裂节点
	 * @param thisNode
	 */
	public void split(Node thisNode) {
		
		DataItem itemC = thisNode.removeItem();
		DataItem itemB = thisNode.removeItem();
		Node child2 = thisNode.disconnectChild(2);
		Node child3 = thisNode.disconnectChild(3);
		Node parent;
		Node newRight = new Node();
		int itemIndex;
		if (thisNode == root) {//根分裂
			root = new Node();
			parent = root;
			root.connectChild(0, thisNode);
		}
		else {//节点分裂
			parent = thisNode.getParent();
		}
		itemIndex = parent.insertItem(itemB);
		int num = parent.getNumItems();
		for (int j = num - 1; j > itemIndex; j--) {
			Node temp = parent.disconnectChild(j);
			parent.connectChild(j + 1, temp);
		}
		parent.connectChild(itemIndex + 1, newRight);
		
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
		
	}
	
	/**
	 * 从root开始打印树
	 */
	public void displayTree() {
		reDisplayTree(root, 0, 0);
	}
	
	
	/**
	 * 递归展示树（各个节点数据项的值）
	 * @param thisNode 入口节点，这里取root
	 * @param level 树的深度，root为0，依次递增
	 * @param chiildNum 节点数组的索引
	 */
	public void reDisplayTree(Node thisNode, int level, int childNum) {
		System.out.println("level " + level + "--" + "child " + childNum);
		thisNode.displayNode();
		int numItems = thisNode.getNumItems();
		for (int i = 0; i < numItems + 1; i++) {
			Node nextNode = thisNode.getChild(i);
			if (nextNode != null) {
				reDisplayTree(nextNode, level + 1, i);//递归展示树
			}
			else {
				return;
			}
		}
	}

}
