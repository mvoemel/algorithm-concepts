package graphTheory;

/*
	This class represents a weighted directed graph with a modified 
	adjacency matrix. the row graph[i] represents the i-th edge 
	with three values u (from Vertex), v (to Vertex), w (weight).
	Graph A(djacency) M(atrix) W(eighted) D(irected).
	The vertices are represented as integers and the directed edges 
	are represented as an array with length three in the adjacency 
	matrix. The adjacency matrix length's are adj[E][3].
	
	@author Michael Voemel
	@date 15.02.2021
*/

public class GraphAMWD {
	
	int[][] adj;
	int V;
	int E;
	
	GraphAMWD(int[][] graph, int V, int E){
		this.adj = graph;
		this.V = V;
		this.E = E;
	}//Constructor
	
}//GraphAMWD
