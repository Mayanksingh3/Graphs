package GraphPack;

import java.util.*;

public class TopologicalSorting {
	Map<Integer, List<Integer>> adjList;
	int numVertex;

	public TopologicalSorting() {
		this.adjList = new HashMap<>();
	}

	public TopologicalSorting(int numVertex) {
		this.numVertex = numVertex;
		this.adjList = new HashMap<>();
	}

	public void addEdge(int u, int v, boolean isBidirected) {
		List<Integer> uNeighbour = this.adjList.getOrDefault(u, new ArrayList<>());
		uNeighbour.add(v);
		this.adjList.put(u, uNeighbour);
		if (isBidirected) {
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

	private int[] inDegree() {
		int[] indegree = new int[this.numVertex];
		for (List<Integer> neighbour : this.adjList.values()) {
			for (int vertex : neighbour) {
				indegree[vertex]++;
			}
		}
		System.out.println(Arrays.toString(indegree));
		return indegree;
	}

	private void topologicalSorting() {
		int[] indegree = this.inDegree();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < this.numVertex; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int vertex = q.poll();
			System.out.print(vertex + " ");
			List<Integer> vNeighbour = this.adjList.getOrDefault(vertex, new ArrayList<>());
			for (int neighbour : vNeighbour) {
				indegree[neighbour]--;
				if (indegree[neighbour] == 0) {
					q.add(neighbour);
				}
			}
		}
	}

	public static void main(String[] args) {
		TopologicalSorting graph = new TopologicalSorting(7);
		graph.addEdge(0, 1, false);
		graph.addEdge(0, 2, false);
		graph.addEdge(2, 3, false);
		graph.addEdge(2, 4, false);
		graph.addEdge(3, 1, false);
		graph.addEdge(4, 6, false);
		graph.addEdge(5, 3, false);
		graph.addEdge(5, 6, false);
		graph.display();
		graph.inDegree();
		graph.topologicalSorting();
	}

}
