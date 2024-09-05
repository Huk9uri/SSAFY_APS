package 프림;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

public class 프림01_다익스트라자 {
	static class Node {
		int V, W;

		public Node(int v, int w) {
			super();
			V = v;
			W = w;
		}

	}

	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adjList;
	static int[] dist; // 거리 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		E = sc.nextInt();

		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		dist = new int[V];
		Arrays.fill(dist, INF);

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			adjList[A].add(new Node(B, W)); // 유향
		}
		dijkstra(0);
		System.out.println(Arrays.toString(dist));
	}

	static void dijkstra(int st) {
		boolean[] visited = new boolean[V];
		dist[st] = 0; // 시작 노드까지의 거리는 0으로 초기화
		// 어디까지 할지는 문제를 보고 결정한다. (도착지가 주어진다면 그곳을 방문하는 순간 멈추도록)

		for (int i = 0; i < V - 1; i++) {
			int min = INF;
			int idx = -1;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			visited[idx] = true; // 뽑앗다.

			for (Node node : adjList[idx]) {
				if (!visited[node.V] && dist[node.V] > dist[idx] + node.W) {
					dist[node.V] = dist[idx] + node.W;
				}
			}
		}

	}

	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n";
}
