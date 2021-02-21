package graphTheory;

import java.util.LinkedList;

/*
	This graph represents a undirected weighted graph 
	for Prim's algorithm. It uses the classes GraphPrim 
	and EdgePrim. The vertices are represented as int's 
	and the edges as EdgePrim objects. The graph uses 
	adjacency lists.
	
	@author Michael Voemel
	@date 15.02.2021
*/

public class GraphPrim {
	
	int V;
	LinkedList<EdgePrim>[] adj;
	
	@SuppressWarnings("unchecked")
	public GraphPrim(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i=0; i<V; i++)
			adj[i] = new LinkedList<>();
	}
	
	//method to add an undirected edge between two vertices
	//Precondition: src && dest are not < 0 and >= V
	public void addEdge(int src, int dest, int weight) {
		adj[src].addLast(new EdgePrim(dest, weight));
		adj[dest].addLast(new EdgePrim(src, weight));
	}//end addEdge
	
}//GraphPrim



//this class represents an edge in the GraphPrim class
class EdgePrim implements Comparable<EdgePrim>{
	int dest;
	int weight;
	
	public EdgePrim(int dest, int weight) {
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public int compareTo(EdgePrim o) {
		return this.weight - o.weight;
	}
}//EdgePrim