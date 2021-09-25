package GraphPack;

import java.util.*;

public class Graph {

	Map<Integer, List<Integer>> adjList;

	public Graph() {
		adjList = new HashMap<>();
	}

	private void addEdge(int u, int v, boolean biDir) {
		List<Integer> uNeighbour = this.adjList.getOrDefault(u, new ArrayList<>());
		uNeighbour.add(v);
		this.adjList.put(u, uNeighbour);
		if (biDir) {
			List<Integer> vNeighbour = this.adjList.getOrDefault(v, new ArrayList<>());
			vNeighbour.add(u);
			this.adjList.put(v, vNeighbour);
		}
	}

	private void display() {
		for (var entry : this.adjList.entrySet()) {
			List<Integer> list = entry.getValue();
			System.out.println(entry.getKey() + " ---> " + list);
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge(1, 2, true);
		graph.addEdge(1, 3, true);
		graph.addEdge(2, 4, true);
		graph.addEdge(3, 4, true);
		graph.addEdge(3, 5, true);
		graph.addEdge(5, 6, true);
		graph.addEdge(7, 8, true);
		graph.display();
	}
}
