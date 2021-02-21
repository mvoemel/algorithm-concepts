package graphTheory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
	Depth first search is an algorithm for a graph. This algorithm is 
	used on a GraphALUD class. It first goes through the depth of 
	each node. Uses: detect cycles, path finding, topological sorting 
	(sorting by reversed post-order), test if a graph is bipartite, 
	solving problems with one solution (mazes).
	Runtime: 
	- O(V+E) OP's
	- O(V) memory
	
	@author Michael Voemel
	@date 12.02.2021
 */

public class DepthFirstSearch {
	
	//this method obtains DFS iteratively with O(V+E) OP's and O(V) memory
	public static int[] DFSiterative(GraphALUD g, int start) {
		if (g==null || start<0 || start>g.V-1) return null;
		
		int n = g.V; // number of vertices
		boolean[] visited = new boolean[n];
		List<Integer> list = new ArrayList<>(n);
		
		//DFS uses stack as queue
		Stack<Integer> queue = new Stack<>();
		
		queue.push(start);
		
		int curr;
		while(!queue.isEmpty()) {
			curr = queue.pop();
			
			if (!visited[curr]) {
				list.add(curr);
				visited[curr] = true;
			}
			
			Iterator<Integer> itr = g.adj[curr].iterator();
			
			while(itr.hasNext()) {
				int v = itr.next();
				if (!visited[v])
					queue.push(v);
			}
		}
		
		int[] result = new int[n]; 
		for (int i=0; i<list.size(); i++)
			result[i] = list.get(i);
			
		return result;
	}//end DFSiterative
	
	
	//this method obtains DFS recursively with O(V+E) OP's and O(V) memory
	public static int[] DFSrecursive(GraphALUD g, int start) {
		if (g==null || start<0 || start>g.V-1) return null;
		
		int n = g.V; // number of vertices
		boolean[] visited = new boolean[n];
		List<Integer> list = new ArrayList<>(n);
		
		DFSrecursiveUtil(g, start, visited, list);
		
		int[] result = new int[n]; 
		for (int i=0; i<list.size(); i++)
			result[i] = list.get(i);
			
		return result;
	}//end DFSrecursive
	
	
	//this is the recursive method used by DFSrecursive
	private static void DFSrecursiveUtil(GraphALUD g, int v, boolean[] visited, List<Integer> list) {
		visited[v] = true;
		list.add(v);
		
		Iterator<Integer> itr = g.adj[v].iterator();
		while(itr.hasNext()) {
			int n = itr.next();
			if (!visited[n])
				DFSrecursiveUtil(g, n, visited, list);
		}
	}//end DFSrecursivelyUtil
	
}//DepthFirstSearch
