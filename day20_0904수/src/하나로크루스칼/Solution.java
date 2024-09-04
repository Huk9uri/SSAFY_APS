package 하나로크루스칼;

import java.util.Arrays;
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
	}
	static int N;
	static int R = 2;
	static int[] output = new int[2];
	static boolean[] visited;
	static int[] landNum;
	static int[][] land;
	static double tax;
	static int cnt = 0;
	static int idx;
	static double cost;
	static Edge[] edges;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 섬의 개수
			cnt = N * (N - 1) / 2;
			idx = 0;
			visited = new boolean[N + 1];
			land = new int[N + 1][2]; // [0] : x좌표 [1]: y좌표
			landNum = new int[N + 1];
			for (int i = 1; i < N + 1; i++) {
				land[i][0] = sc.nextInt();
				landNum[i] = i;
			}
			for (int i = 1; i < N + 1; i++) {
				land[i][1] = sc.nextInt();
			}
			tax = sc.nextDouble();
			edges = new Edge[cnt];
			combination(0, 1);
			Arrays.sort(edges);
//			for (int i = 0; i < cnt; i++) {
//				System.out.println(edges[i]);
//			}
			p = new int[N + 1];

			for (int i = 1; i < N + 1; i++) {
				p[i] = i;
			}
			double ans = 0;
			int pick = 0;
			for (int i = 0; i < cnt; i++) {
				int px = findSet(edges[i].A);
				int py = findSet(edges[i].B);
				if (px != py) {
					union(px, py);
					ans += edges[i].W;
					pick++;
				}
				if (pick == N - 1)
					break;
			}
			System.out.println("#" + tc + " " + Math.round(ans));

		}
	}
//
//	static void makeSet(int x) {
//		p[x] = x;
//	}

	static int findSet(int x) {
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

	static void union(int x, int y) {
		p[y] = x;
	}

	static void combination(int depth, int start) {
		// 기저
		if (depth == R) {
			calculate();
			edges[idx++] = new Edge(output[0], output[1], cost);
			return;
		}
		// 재귀
		for (int i = start; i < landNum.length; i++) {
			if (!visited[i]) {
				output[depth] = landNum[i];
				combination(depth + 1, i + 1);
			}
		}
	}

	static void calculate() {
		int x1 = land[output[0]][0];
		int y1 = land[output[0]][1];

		int x2 = land[output[1]][0];
		int y2 = land[output[1]][1];

		long distanceX = (long) Math.pow(x2-x1, 2);
		long distanceY =(long) Math.pow(y2-y1, 2);

		long L = distanceX + distanceY;
		cost = tax * L;

	}
}