package graphTheory;

/*
	Bellman Ford's algorithm is used on a general weighted graph 
	(positive and negative weights). This algorithm is used on the 
	GraphAMWD class. Bellman Ford's algorithm is used to find the 
	minimal-cost paths from a starting vertex to all other vertices 
	in a general weighted graph and to detect negative cycles in a 
	graph. It first relaxes V-1 times the minimal distances. 
	A simple shortest path from the src vertex to any other vertex 
	can have at most V-1 edges. Than we check for negative cycles. 
	The step before guarantees shortest distances if graph does 
	not contain negative weight cycles. If we get a shorter path, 
	then there is a negative cycle.
	Runtime:
	- O(V*E)
	
	@author Michael Voemel
	@date 15.02.2021
*/

public class BellmanFord {
	
	//this method obtains the shortest paths in an negative weighted graph
	//Precondition: g != null und !(src < 0 || src >= g.V)
	public static int[] bellmanFord(GraphAMWD g, int src) throws NegativeCycleException {
		int[] dist = new int[g.V];
		for (int i=0; i<g.V; i++)
			dist[i] = Integer.MAX_VALUE;
		
		dist[src] = 0;
		
		//relax edges V-1 times.
		for (int i=0; i<g.V-1; i++) {
			for (int j=0; j<g.E; j++) {
				if (dist[g.adj[j][0]] != Integer.MAX_VALUE 
						&& dist[g.adj[j][0]] + g.adj[j][2] < dist[g.adj[j][1]]) {
					
					dist[g.adj[j][1]] = dist[g.adj[j][0]] + g.adj[j][2];
					
				}
			}
		}
		
		//check for negative cycle
		for (int i=0; i<g.E; i++) {
			int x = g.adj[i][0];
			int y = g.adj[i][1];
			int w = g.adj[i][2];
			if (dist[x] != Integer.MAX_VALUE && dist[x] + w < dist[y])
				throw new NegativeCycleException();
		}
		
		return dist;
	}//end bellmanFord
	
}//BellmanFord



@SuppressWarnings("serial")
class NegativeCycleException extends Exception {
	
	NegativeCycleException(){
		super("The graph has a negative cycle.");
	}
	
}//NegativeCycleException
