package 그래프;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 간선배열 {

	static class Edge {
		int A, B, W; // 시작 끝 가중치

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점의 갯수
		int E = sc.nextInt(); // 간선의 갯수

		Edge[] edges = new Edge[E];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();

			edges[i] = new Edge(A, B, W);

		}
		//
		List<Edge> edges2 = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			edges2.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}

		int[][] edges3 = new int[E][3];// [0] 시작 [1] 도착 [2] 가중치

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			edges3[i][0] = A;
			edges3[i][1] = B;
			edges3[i][2] = W;

		}

	}
}
