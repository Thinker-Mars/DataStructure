package graph;

/**
 * 图实现类
 * @author Cone
 * @since 2019年7月24日
 *
 */
public class Graph {
	
	private final int MAXS_VERTS = 20;//标识顶点个数
	private Vertex vertexArray[];//用来存储顶点的数组
	private int[][] adjMat;//表示邻接矩阵
	private int numVerts;//顶点个数
	private Stack myStack;//深度优先搜索使用的栈
	private Queue myQueue;//广度优先搜索使用的队列
	
	
	public Graph() {
		
		this.vertexArray = new Vertex[MAXS_VERTS];
		this.adjMat = new int[MAXS_VERTS][MAXS_VERTS];
		numVerts = 0;//默认没有顶点
		//初始化邻接矩阵的所有元素都为0，即所有顶点都没有边
		for(int i = 0; i < MAXS_VERTS; i++) {
			for(int j = 0; j < MAXS_VERTS; j++) {
				adjMat[i][j] = 0;
			}
		}
		myStack = new Stack();
		myQueue = new Queue();
	}
	
	/**
	 * 将顶点添加到数组中
	 * @param lab
	 */
	public void addVertex(char lab) {
		
		vertexArray[numVerts++] = new Vertex(lab);
	}
	
	/**
	 * 添加边(因为是对称的，所以两次赋值)
	 * @param start
	 * @param end
	 */
	public void addEdge(int start, int end) {
		
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	/**
	 * 打印某个节点的标签
	 * @param key 节点数组的索引
	 */
	public void displayVertex(int key) {
		
		System.out.println(vertexArray[key].label);
	}
	
	//-----------------------深度优先搜索算法-----------------------//
	
	public void depthFirstSearch() {
		//从顶点开始
		vertexArray[0].wasVisited = true;
		displayVertex(0);
		myStack.push(0);
		while (!myStack.isEmpty()) {
		
			int v = getUnvisitedVertex(myStack.peek());
			if (v == -1) {
				//出栈
				myStack.pop();
			}
			else {
				vertexArray[v].wasVisited = true;
				displayVertex(v);
				//压入栈
				myStack.push(v);
			}
		}
		
		for (int i = 0; i < numVerts; i++) {
			//搜索结束，将所有节点的访问标志置为false
			vertexArray[i].wasVisited = false;
		}
		
		
//		for (Vertex vertex : vertexArray) {
//			vertex.wasVisited = false;
//		}
	}
	
	/**
	 * 得到当前节点的邻接未访问节点
	 * @param v 当前节点
	 * @return 节点数组的索引，没有邻接未访问节点则返回-1
	 */
	public int getUnvisitedVertex(int v) {
		
		for (int i = 0; i <MAXS_VERTS; i++) {
			
			//邻接矩阵元素为1而且未被访问
			if (adjMat[v][i] == 1 && vertexArray[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}
	
	
	//-----------------------广度优先搜索算法-----------------------//
	public void breadthFirstSearch() {
		
		vertexArray[0].wasVisited = true;
		displayVertex(0);
		myQueue.insert(0);
		int v2;
		while (!myQueue.isEmpty()) {
			int v1 = myQueue.remove();
			while ((v2 = getUnvisitedVertex(v1)) != -1) {
				vertexArray[v2].wasVisited = true;
				displayVertex(v2);
				myQueue.insert(v2);
			}
		}
		
		
		for (int i = 0; i < numVerts; i++) {
			//搜索结束，将所有节点的访问标志置为false
			vertexArray[i].wasVisited = false;
		}
		
//		for (Vertex vertex : vertexArray) {
//			vertex.wasVisited = false;
//		}
	}
	
	
	class Vertex{
		
		public char label;//标识顶点
		public boolean wasVisited;//是否被访问
		
		public Vertex(char label) {
			this.label = label;
			this.wasVisited = false;
		}
	}

}
