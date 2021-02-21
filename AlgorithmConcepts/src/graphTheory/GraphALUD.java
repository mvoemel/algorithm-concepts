package graphTheory;

import java.util.LinkedList;

/*
	This class represents an unweighted directed graph with adjacency lists.
	Graph A(djacency) L(ists) U(nweighted) D(irected).
	The vertices are represented as integers and the directed edges are represented 
	in the adjacency lists.
	
	@author Michael Voemel
	@date 12.02.2021
*/

public class GraphALUD {
	
	//number of vertices
	public int V;
	
	//adjacency lists
	public LinkedList<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	GraphALUD(int V){
		this.V = V;
		adj = new LinkedList[V]; // array with linked lists as elements
		
		for (int i=0; i<adj.length; i++)
			adj[i] = new LinkedList<Integer>();
	}//Constructor
	
	//add an edge from v to w
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}//end addEdge
	
}//GraphALUD
