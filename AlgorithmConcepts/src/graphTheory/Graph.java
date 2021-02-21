package graphTheory;

import java.util.ArrayList;

/*
	This class represents a weighted graph with adjacency lists 
	using the classes Graph, Vertex and Edge. The vertices are 
	represented by Vertex objects with an id. The edges are 
	represented by Edge objects. The graph uses an adjacency 
	list of vertices.
	
	@author Michael Voemel
	@date 14.02.2021
*/

public class Graph {
	private ArrayList<Vertex> vertices;
	public int V;
	
	public Graph(int V) {
		this.V = V;
		vertices = new ArrayList<>(V);
		for (int i=0; i<V; i++)
			vertices.add(new Vertex(i));
	}
	
	public void addEdge(int from, int to, double weight) {
		if (from<0 || to<0 || from>=V || to>=V) throw new IllegalArgumentException();
		
		Vertex v = vertices.get(from);
		Edge e = new Edge(vertices.get(to), weight);
		v.neighbours.add(e);
	}
	
	public ArrayList<Vertex> getVertices(){
		return vertices;
	}
	
	public Vertex getVertex(int id) {
		return vertices.get(id);
	}
}//Graph



//this class represents a vertex in the class Graph
class Vertex implements Comparable<Vertex>{
	public final int id;
	public ArrayList<Edge> neighbours;
	
	public double minDist;
	public Vertex prev;
	
	public Vertex(int id) {
		this.id = id;
		neighbours = new ArrayList<>();
		minDist = Double.POSITIVE_INFINITY;
	}
	
	@Override
	public int compareTo(Vertex other) {
		return Double.compare(this.minDist, other.minDist);
	}
	
	@Override
	public String toString() {
		return "id: "+id;
	}
}//Vertex



//this class represents an edge in the class graph
class Edge {
	public final Vertex dest;
	public final double weight;
	
	public Edge(Vertex dest, double weight) {
		this.dest = dest;
		this.weight = weight;
	}
}//Edge
