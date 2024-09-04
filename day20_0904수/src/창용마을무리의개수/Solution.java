package 창용마을무리의개수;

import java.util.Scanner;

public class Solution {
//	static class Edge{
//		int A,B,W;
//
//		public Edge(int a, int b, int w) {
//			super();
//			A = a;
//			B = b;
//			W = w;
//		}
//
//		@Override
//		public String toString() {
//			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
//		}
//		
//	}
//	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.println();
			int V = sc.nextInt(); // 정점 개수
			int E = sc.nextInt(); // 간선 개수

			int[][] adj = new int[V + 1][V + 1];

			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();

				adj[from][to] = adj[to][from] = 1;

			}
			for (int i = 0; i < adj.length; i++) {
				for (int j = 0; j < adj.length; j++) {
					System.out.print(adj[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	static String input = "2\r\n"
			+ "6 5\r\n"
			+ "1 2\r\n"
			+ "2 5\r\n"
			+ "5 1\r\n"
			+ "3 4\r\n"
			+ "4 6\r\n"
			+ "6 8\r\n"
			+ "1 2\r\n"
			+ "2 5\r\n"
			+ "5 1\r\n"
			+ "3 4\r\n"
			+ "4 6\r\n"
			+ "5 4\r\n"
			+ "2 4\r\n"
			+ "2 3";
}