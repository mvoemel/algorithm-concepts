package graphTheory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
	The breadth first search algorithm is used on an unweighted graph. 
	This algorithm is used on the GraphALUD class. Unlike the depth 
	first search algorithm it does not go through the depth of a 
	graph first, it first searches through all direct successors 
	of the root and so on. The algorithm is used to find the 
	shortest path in an unweighted graph.
	Runtime: 
	- O(V+E) OP's
	- O(V) memory
	
	@author Michael Voemel
	@date 14.02.2021
 */

public class BreadthFirstSearch {
	
	//this method obtains BFS iteratively with O(V+E) OP's and O(V) memory
	public static int[] BFS(GraphALUD g, int start) {
		if (g==null || start<0 || start>g.V-1) return null;
		
		int n = g.V; // number of vertices
		boolean[] visited = new boolean[n];
		List<Integer> list = new ArrayList<>(n);
		
		//BFS uses linked list as queue
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[start] = true;
		queue.addLast(start);
		
		int curr;
		while (!queue.isEmpty()) {
			curr = queue.removeFirst();
			list.add(curr);
			
			Iterator<Integer> itr = g.adj[curr].iterator();
			
			while (itr.hasNext()) {
				int v = itr.next();
				if (!visited[v]) {
					visited[v] = true;
					queue.addLast(v);
				}
			}
		}
		
		int[] result = new int[n]; 
		for (int i=0; i<list.size(); i++)
			result[i] = list.get(i);
			
		return result;
	}//end BFS
	
}//BreadthFirstSearch
