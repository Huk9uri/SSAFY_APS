package 하나로프림;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static class Edge implements Comparable<Edge> {
		int A, B;
		double W;

		public Edge(int a, int b, double w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.W, o.W);
		}

		static final int INF = Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt(); // 섬의 개수
			int E = V * (V - 1) / 2;

			List<Edge>[] adjList = new ArrayList[V + 1];

			for (int i = 1; i < V + 1; i++) {
				adjList[i] = new ArrayList<>();
			}
			int[] landX = new int[V + 1];
			int[] landY = new int[V + 1];

			for (int i = 1; i < V + 1; i++) {
				landX[i] = sc.nextInt();
			}
			for (int i = 1; i < V + 1; i++) {
				landY[i] = sc.nextInt();
			}
			double tax = sc.nextDouble();
			int idx = 1;
			for (int i = 1; i < V; i++) {
				int diffX = 0;
				int diffY = 0;
				int dist = 0;
				double cost = 0;
				for (int j = i + 1; j < V + 1; j++) {
					diffX = landX[i] - landX[j];
					diffY = landY[i] - landY[j];
					dist = diffX * diffX + diffY * diffY;
					cost = dist * tax;
					adjList[idx].add(new Edge(i, j, cost));
				}
				idx++;
			}
			for (int j = 1; j < V; j++) {
				for (Edge e : adjList[j]) {
					System.out.println(e.toString());
				}
			}
			boolean[] visited = new boolean[V + 1];
			visited[1] = true;
			double ans = 0;
			int pick = 1;
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.addAll(adjList);

		}
	}
}