package GraphPack;

import java.util.*;

public class SingleSourceShortestPath {

	Map<Integer, List<Integer>> adjList;

	public SingleSourceShortestPath() {
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
	
	private void singlSourceShortestPath(int source) {
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		Map<Integer,Integer> dis = new HashMap<>();
		for(int vertex:this.adjList.keySet()) {
			dis.put(vertex, Integer.MAX_VALUE);
		}
		dis.put(source, 0);
		while (!q.isEmpty()) {
			int temp = q.poll();
			List<Integer> neighbours = this.adjList.getOrDefault(temp, new ArrayList<>());
			for (int neighbour : neighbours) {
				if (dis.get(neighbour) == Integer.MAX_VALUE) {
					q.add(neighbour);
					int ndis = dis.get(temp)+1;
					dis.put(neighbour,ndis);
					System.out.println(neighbour + " distance from  " + source + " is " + ndis);
				}
			}
		}
	}

	public static void main(String[] args) {
		SingleSourceShortestPath graph = new SingleSourceShortestPath();
		graph.addEdge(1, 2, true);
		graph.addEdge(1, 3, true);
		graph.addEdge(2, 4, true);
		graph.addEdge(3, 4, true);
		graph.addEdge(3, 5, true);
		graph.addEdge(5, 6, true);
//		graph.addEdge(7, 8, true);
		graph.display();
		graph.singlSourceShortestPath(4);
	}
}