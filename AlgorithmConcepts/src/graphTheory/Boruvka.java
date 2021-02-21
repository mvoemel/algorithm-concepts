package graphTheory;

import java.util.ArrayList;

/*
	Boruvka's algorithm is used to find the minimal spanning tree in 
	a weighted undirected graph. This algorithm uses the classes 
	GraphMST and UnionFind. We first add all vertices to the set of 
	components. Then as long as the size of the component-set is 
	greater than one, we connect each component to another with the 
	cheapest edge.
	Runtime: 
	- O((V+E)*log(V))
	
	@author Michael Voemel
	@date 15.02.2021
*/

public class Boruvka {
	
	//returns the weight of the MST of the graph
	public static int boruvka(GraphMST g) {
		UnionFind uf = new UnionFind(g.V);
		
		int mstWeight = 0;
		ArrayList<EdgeMST> mst = new ArrayList<>(g.V);
		
		for (int t=1; t<g.V && mst.size()<g.V-1; t *= 2) {
			//for each tree in forest, find closest edge
			EdgeMST[] closest = new EdgeMST[g.V];
			for (EdgeMST e: g.edges) {
				int u = e.from;
				int v = e.to;
				int i = uf.find(u);
				int j = uf.find(v);
				
				if (i == j)
					continue; // same tree
				if (closest[i] == null || e.weight < closest[i].weight)
					closest[i] = e;
				if (closest[j] == null || e.weight < closest[j].weight)
					closest[j] = e;
			}
			
			//add newly discovered edge to mst
			for (int i=0; i<g.V; i++) {
				EdgeMST e = closest[i];
				if (e != null) {
					int u = e.from;
					int v = e.to;
					
					//do not add the same edge twice
					if(!(uf.find(u) == uf.find(v))) {
						mst.add(e);
						mstWeight += e.weight;
						uf.union(u, v);
					}
				}
			}
		}
		
		return mstWeight;
	}//end boruvka
	
}//Boruvka
