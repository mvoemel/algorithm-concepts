package graphTheory;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;
import org.junit.Assert;

public class GraphAlgorithmsTest {
	
	@Test
	public void testDFSiterative() {
		GraphALUD g1 = new GraphALUD(4);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(2, 0);
		g1.addEdge(2, 3);
		g1.addEdge(3, 3);
		int[] array1 = {2,3,0,1};
		Assert.assertArrayEquals(array1, DepthFirstSearch.DFSiterative(g1, 2));
		
		GraphALUD g2 = new GraphALUD(5);
		g2.addEdge(1, 0);
		g2.addEdge(0, 2);
		g2.addEdge(2, 1);
		g2.addEdge(0, 3);
		g2.addEdge(1, 4);
		int[] array2 = {0,3,2,1,4};
		Assert.assertArrayEquals(array2, DepthFirstSearch.DFSiterative(g2, 0));
	}
	
	@Test
	public void testDFSrecursive() {
		GraphALUD g1 = new GraphALUD(4);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(2, 0);
		g1.addEdge(2, 3);
		g1.addEdge(3, 3);
		int[] array1 = {2,0,1,3};
		Assert.assertArrayEquals(array1, DepthFirstSearch.DFSrecursive(g1, 2));
		
		GraphALUD g2 = new GraphALUD(5);
		g2.addEdge(1, 0);
		g2.addEdge(0, 2);
		g2.addEdge(2, 1);
		g2.addEdge(0, 3);
		g2.addEdge(1, 4);
		int[] array2 = {0,2,1,4,3};
		Assert.assertArrayEquals(array2, DepthFirstSearch.DFSrecursive(g2, 0));
	}
	
	@Test
	public void testBFS() {
		GraphALUD g1 = new GraphALUD(4);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(2, 0);
		g1.addEdge(2, 3);
		g1.addEdge(3, 3);
		int[] array1 = {2,0,3,1};
		Assert.assertArrayEquals(array1, BreadthFirstSearch.BFS(g1, 2));
	}
	
	@Test
	public void testDijkstra() {
		Graph g = new Graph(9);
		g.addEdge(0, 1, 4); g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8); g.addEdge(1, 7, 11); g.addEdge(2, 1, 8);
		g.addEdge(2, 8, 2); g.addEdge(2, 5, 4); g.addEdge(2, 3, 7);
		g.addEdge(3, 2, 7); g.addEdge(3, 5, 14); g.addEdge(3, 4, 9); 
		g.addEdge(4, 3, 9); g.addEdge(4, 5, 10); 
		g.addEdge(5, 4, 10); g.addEdge(5, 3, 9); g.addEdge(5, 2, 4); g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1); g.addEdge(6, 8, 6); g.addEdge(6, 5, 2);
		g.addEdge(7, 0, 8); g.addEdge(7, 8, 7); g.addEdge(7, 1, 11); g.addEdge(7, 6, 1);
		g.addEdge(8, 2, 2); g.addEdge(8, 7, 7); g.addEdge(8, 6, 6);
		double[] result = {0, 4, 12, 19, 21, 11, 9, 8, 14};
		Assert.assertTrue(Arrays.equals(result, Dijkstra.dijkstra(g, 0)));
	}
	
	@Test
	public void testBellmanFord() {
		int[][] graphM = { { 0, 1, -1 }, { 0, 2, 4 },
                { 1, 2, 3 }, { 1, 3, 2 }, 
                { 1, 4, 2 }, { 3, 2, 5 }, 
                { 3, 1, 1 }, { 4, 3, -3 } };
		int V = 5;
		int E = 8;
		int[] result = {0,-1,2,-2,1};
		GraphAMWD g = new GraphAMWD(graphM, V, E);
		try {
			Assert.assertTrue(Arrays.equals(result, BellmanFord.bellmanFord(g, 0)));
		} catch (NegativeCycleException e) {
			System.out.println("A NegativeCycleException has been thrown");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBoruvka() {
		int V = 4;
		int E = 5;
		GraphMST g = new GraphMST(V, E);
		g.edges[0].from = 0;
		g.edges[0].to = 1;
		g.edges[0].weight = 10;
		
		g.edges[1].from = 0;
		g.edges[1].to = 2;
		g.edges[1].weight = 6;
		
		g.edges[2].from = 0;
		g.edges[2].to = 3;
		g.edges[2].weight = 5;
		
		g.edges[3].from = 1;
		g.edges[3].to = 3;
		g.edges[3].weight = 15;
		
		g.edges[4].from = 2;
		g.edges[4].to = 3;
		g.edges[4].weight = 4;
		assertEquals(19, Boruvka.boruvka(g));
	}
	
	@Test
	public void testKruskal() {
		int V = 4;
		int E = 5;
		GraphMST g = new GraphMST(V, E);
		g.edges[0].from = 0;
		g.edges[0].to = 1;
		g.edges[0].weight = 10;
		
		g.edges[1].from = 0;
		g.edges[1].to = 2;
		g.edges[1].weight = 6;
		
		g.edges[2].from = 0;
		g.edges[2].to = 3;
		g.edges[2].weight = 5;
		
		g.edges[3].from = 1;
		g.edges[3].to = 3;
		g.edges[3].weight = 15;
		
		g.edges[4].from = 2;
		g.edges[4].to = 3;
		g.edges[4].weight = 4;
		assertEquals(19, Kruskal.kruskal(g));
	}
	
	@Test
	public void testPrim() {
		int V = 9; 
        GraphPrim g = new GraphPrim(V); 
        g.addEdge(0, 1, 4); 
        g.addEdge(0, 7, 8); 
        g.addEdge(1, 2, 8); 
        g.addEdge(1, 7, 11); 
        g.addEdge(2, 3, 7); 
        g.addEdge(2, 8, 2); 
        g.addEdge(2, 5, 4); 
        g.addEdge(3, 4, 9); 
        g.addEdge(3, 5, 14); 
        g.addEdge(4, 5, 10); 
        g.addEdge(5, 6, 2); 
        g.addEdge(6, 7, 1); 
        g.addEdge(6, 8, 6); 
        g.addEdge(7, 8, 7); 
        assertEquals(37, Prim.prim(g, 0));
	}
	
	@Test
	public void testFloydWarshall() {
		final int INF = 99999;
		int V = 4;
		int[][] g = { 	{0,   5,  INF, 10},
                		{INF,  0,  3,  INF},
                		{INF, INF, 0,   1},
                		{INF, INF, INF, 0} };
		int[][] expected = { 	{0,   5,  8, 9},
								{INF,  0,  3,  4},
								{INF, INF, 0,   1},
								{INF, INF, INF, 0} };
		int[][] actual = FloydWarshall.floydWarshall(g, V);
		for (int i=0; i<V; i++)
			Assert.assertTrue(Arrays.equals(expected[i], actual[i]));
	}
	
}
