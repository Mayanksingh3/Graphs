package GraphPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFS {
	Map<Integer, List<Integer>> adjList;

	public BFS() {
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

	private void bFS(int source) {
		Set<Integer> vis = new HashSet<>();
		bFSHelper(source, vis);
	}

	private void bFS2() {
		Set<Integer> vis = new HashSet<>();
		for (int vertex : this.adjList.keySet()) {
			if (!vis.contains(vertex)) {
				bFSHelper(vertex, vis);
				System.out.println();
			}
		}
	}

	private void bFSHelper(int source, Set<Integer> vis) {
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		vis.add(source);
		while (!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			List<Integer> neighbours = this.adjList.getOrDefault(temp, new ArrayList<>());
			for (int neighbour : neighbours) {
				if (!vis.contains(neighbour)) {
					q.add(neighbour);
					vis.add(neighbour);
				}
			}
		}
	}

	public static void main(String[] args) {
		BFS graph = new BFS();
		graph.addEdge(1, 2, true);
		graph.addEdge(1, 3, true);
		graph.addEdge(2, 4, true);
		graph.addEdge(3, 4, true);
		graph.addEdge(3, 5, true);
		graph.addEdge(5, 6, true);
		graph.addEdge(7, 8, true);
		graph.display();
		//For Connected Graph
		graph.bFS(2);
		System.out.println();
		// For UnConnected Graph
		graph.bFS2();
	}
}
