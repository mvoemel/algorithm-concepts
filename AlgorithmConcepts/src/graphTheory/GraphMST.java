package graphTheory;

/*
	This graph represents a undirected weighted graph for 
	the minimum-spanning-tree algorithms. It uses the 
	classes GraphMST and EdgeMST. The vertices are 
	represented as int's and the edges as EdgeMST 
	objects. The graph uses an array for the edges.
	
	@author Michael Voemel
	@date 15.02.2021
*/

public class GraphMST {
	
	int V;
	int E;
	EdgeMST[] edges;
	
	public GraphMST(int V, int E) {
		this.V = V;
		this.E = E;
		edges = new EdgeMST[E];
		for (int i=0; i<E; i++)
			edges[i] = new EdgeMST();
	}//Constructor
	
}//GraphMST



//this class represents an edge in the GraphMST class
class EdgeMST implements Comparable<EdgeMST>{

	int from;
	int to;
	int weight;
	
	public EdgeMST() {
		from = to = weight = -1;
	}
	
	public EdgeMST(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(EdgeMST other) {
		return this.weight - other.weight;
	}
	
}//Edge
