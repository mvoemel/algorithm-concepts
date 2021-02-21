package graphTheory;

/*
	The Floyd-Warshall algorithm is used for solving the 
	all-pair shortest path problem. This is to find the 
	shortest distance between any two vertices of a given 
	directed graph without negative closed walks. This 
	algorithm takes a graph in form of a adjacency matrix 
	and the number of vertices as input and return a two 
	dimensional array.
	Runtime: 
	- O(V^3)
	
	@author Michael Voemel
	@date 15.02.2021
*/

public class FloydWarshall {
	
	//return a matrix with all-pair shortest path
	//Precondition: the graph has no negative closed walks
	public static int[][] floydWarshall(int[][] g, int V) {
		if (g==null || V<0 || g.length!=V) return null;
		
		int[][] dist = new int[V][V];
		
		for (int i=0; i<V; i++)
			for (int j=0; j<V; j++)
				dist[i][j] = g[i][j];
		
		for (int k=0; k<V; k++) {
			for (int i=0; i<V; i++) {
				for (int j=0; j<V; j++) {
					
					if (dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
					
				}
			}
		}
		
		return dist;
	}//end flydWarhsll
	
}//FloydWarshall
