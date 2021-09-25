package GraphPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS {

	Map<Integer, List<Integer>> adjList;

	public DFS() {
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

	private void dFS(int source) {
		Set<Integer> vis = new HashSet<>();
		dfsHelper(source, vis);
	}

	private void dfsHelper(int src, Set<Integer> vis) {
		System.out.print(src + " ");
		vis.add(src);
		List<Integer> neighbours = this.adjList.getOrDefault(src, new ArrayList<>());
		for (int neighbour : neighbours) {
			if (!vis.contains(neighbour)) {
				dfsHelper(neighbour, vis);
			}
		}
	}

	private void dFS2() {
		Set<Integer> vis = new HashSet<>();
		for (int vertex : this.adjList.keySet()) {
			if (!vis.contains(vertex)) {
				dfsHelper(vertex, vis);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		DFS graph = new DFS();
		graph.addEdge(1, 2, true);
		graph.addEdge(1, 3, true);
		graph.addEdge(2, 4, true);
		graph.addEdge(3, 4, true);
		graph.addEdge(3, 5, true);
		graph.addEdge(5, 6, true);
		graph.addEdge(7, 8, true);
		graph.display();
		// For Connected Graph
		graph.dFS(2);
		System.out.println();
		// For UnConnected Graph
		graph.dFS2();
	}
}
