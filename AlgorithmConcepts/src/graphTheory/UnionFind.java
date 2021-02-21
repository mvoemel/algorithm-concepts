package graphTheory;

/*
	This class provides a structure to keep track which vertices, 
	which are represented as int, are in the same subtree. Boruvka's 
	and Kruskal's algorithms use this structure.
	Runtime: (n represents the number of vertices in the graph)
	- initializing: O(n)
	- finding: O(log(n))
	- union: O(log(n))
	
	@author Michael Voemel
	@date 15.02.2021
*/

public class UnionFind {
	private int[] parents;
	private int[] ranks;
	
	public UnionFind(int n) {
		parents = new int[n];
		ranks = new int[n];
		for (int i=0; i<n; i++) {
			parents[i] = i;
			ranks[i] = 0;
		}
	}//Constructor
	
	public int find(int u) {
		while (u != parents[u])
			u = parents[u];
		return u;
	}//end find
	
	public void union(int u, int v) {
		int uP = find(u);
		int vP = find(v);
		if (uP == vP)
			return;
		
		if (ranks[uP] < ranks[vP])
			parents[uP] = vP;
		else if (ranks[uP] > ranks[vP])
			parents[vP] = uP;
		else {
			parents[vP] = uP;
			ranks[uP]++;
		}
	}//end union
	
}//UnionFind
