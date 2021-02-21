package graphTheory;

import java.util.PriorityQueue;

/*
	Dijkstra's algorithm is used on a non-negative weighted graph. 
	This algorithm is used on the Graph class. Dijkstra's algorithm 
	is used to find the minimal-cost paths from a starting vertex 
	to all other vertices in a non-negative weighted graph. The 
	algorithm is implemented with priority queue.
	Runtime: 
	- O((V+E)*log(V))
	Optimization: using Fibonacci heaps the runtime of the algorithm 
	would be O(V*log(V)+E)
	
	@author Michael Voemel
	@date 14.02.2021
*/

public class Dijkstra {
	
	//this method obtains the shortest paths in an non-negative weighted graph
	//Precondition: the graph does not have negative weighted edges
	public static double[] dijkstra(Graph g, int idStartVertex) {
		Vertex source = g.getVertex(idStartVertex);
		PriorityQueue<Vertex> queue = new PriorityQueue<>();
		
		source.minDist = 0;
		queue.add(source);
		
		Vertex curr;
		while (!queue.isEmpty()) {
			curr = queue.poll();
			
			for (Edge e: curr.neighbours) {
				if (e.dest.minDist > curr.minDist+e.weight) {
					queue.remove(e.dest);
					e.dest.minDist = curr.minDist+e.weight;
					
					e.dest.prev = curr;
					
					queue.add(e.dest);
				}
			}
		}
		
		double[] dist = new double[g.V];
		for (int i=0; i<g.V; i++)
			dist[i] = g.getVertices().get(i).minDist;
		
		return dist;
	}//end dijkstra
	
}//Dijkstra
