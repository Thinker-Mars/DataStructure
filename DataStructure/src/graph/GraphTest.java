package graph;

public class GraphTest {
	
	public static void main(String[] args) {
		
		Graph graph = new Graph();
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		System.out.println("深度优先算法...");
		graph.depthFirstSearch();
		System.out.println("-----------");
		System.out.println("广度优先算法...");
		graph.breadthFirstSearch();
	}

}
