package graphTheory;

import java.util.ArrayList;
import java.util.Arrays;

/*
	Kruskal's algorithm is used to find the minimal spanning tree in 
	a weighted undirected graph. This algorithm uses the classes 
	GraphMST and UnionFind. We first sort the edges by weight and than 
	add them one-by-one as long as there is no cycle.
	Runtime: 
	- O(E*log(V)) if implemented with UnionFind, which it is here, else
	it would have a running time of O(E*V)
	
	@author Michael Voemel
	@date 15.02.2021
*/

public class Kruskal {
	
	//returns the weight of the MST of the graph
	public static int kruskal(GraphMST g) {
		UnionFind uf = new UnionFind(g.V);
		boolean[] visited = new boolean[g.V];
		
		int mstWeight = 0;
		ArrayList<EdgeMST> mst = new ArrayList<>(g.V);
		
		Arrays.sort(g.edges);
		
		for (EdgeMST e: g.edges) {
			if ((visited[e.from] && visited[e.to]) 
					&& uf.find(e.from) == uf.find(e.to))
				continue;
			
			mstWeight += e.weight;
			mst.add(e);
			visited[e.from] = true;
			visited[e.to] = true;
			uf.union(e.from, e.to);
		}
		
		return mstWeight;
	}//end kruskal
	
}//Kruskal
