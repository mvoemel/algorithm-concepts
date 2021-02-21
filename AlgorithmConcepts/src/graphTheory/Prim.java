package graphTheory;

import java.util.PriorityQueue;

/*
	Prim's algorithm is used to find the minimal spanning tree in 
	a weighted undirected graph. This algorithm uses the class 
	GraphPrim. Prim's algorithm is an alternative to Kruskal's 
	algorithm. It needs a given starting vertex, form where we 
	add one-by-one the smallest edge, outgoing from the starting 
	vertex or the created subtree.
	Runtime: 
	- O((V+E)*log(V))
	
	@author Michael Voemel
	@date 15.02.2021
*/

public class Prim {
	
	//returns the weight of the MST of the graph
	public static int prim(GraphPrim g, int src) {
		if (g==null || src<0 || src>=g.V) return -1;
		
		boolean[] visited = new boolean[g.V];
		int mstWeight = 0;
		
		PriorityQueue<EdgePrim> queue = new PriorityQueue<>();
		
		visited[src] = true;
		
		//add every neighbour of src to queue
		for (EdgePrim e: g.adj[src])
			queue.add(e);
		
		EdgePrim curr;
		while (!queue.isEmpty()) {
			curr = queue.remove();
			
			//dest vertex already visited
			if (visited[curr.dest])
				continue;
			
			visited[curr.dest] = true;
			mstWeight += curr.weight;
			
			for (EdgePrim e: g.adj[curr.dest])
				queue.add(e);
		}
		
		for (int i=0; i<g.V; i++)
			if (!visited[i])
				return -1;
		
		return mstWeight;
	}//end prim
	
}//Prim

