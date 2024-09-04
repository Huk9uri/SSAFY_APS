package 그래프최소비용;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 크루스칼 {
	static class Edge implements Comparable<Edge> {
		int A, B, W;

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

		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
		}

	}

	static int[] p; // 대표자 저장 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점 개수
		int E = sc.nextInt(); // 간선 개수

		Edge[] edges = new Edge[E];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			edges[i] = new Edge(A, B, W);
		}
		// 1. 가중치 순으로 정렬
		Arrays.sort(edges);

		for (Edge e : edges) {
			System.out.println(e);
		}

		// 2. V-1개의 간선을 뽑아라. (단 사이클이 발생하지 않도록)
		// 상호배타집합 (서로소 집합, 유니온파인드)
		p = new int[V]; // 정점 번호 시작이 0이므로 V, 1이면 V+1 ..

		// makeSet으로 자신을 대표로 만드는 작업 수행하기
		for (int i = 0; i < V; i++) {
			p[i] = i;
		}
		int ans = 0; // 최소비용 저장을 위한 변수
		int pick = 0; // 내가 뽑은 간선의 개수
		for (int i = 0; i < E; i++) {
//			int x = edges[i].A;
//			int y = edges[i].B;
//
//			// 사이클이 발생하는지 검사.
//			if (findSet(x) != findSet(y)) {
//				// 해당 블록에 들어왔다면 사이클이 아니다 .
//				union(x, y);
//				ans += edges[i].W;
//				pick++;
//			}

			int px = findSet(edges[i].A);
			int py = findSet(edges[i].B);
			if (px != py) {
				union(px, py);
				ans += edges[i].W;
				pick++;
			}

			if (pick == V - 1)
				break;
		} // 간선의 총 개수만큼 돌면서
		System.out.println(ans);
	}

	static void makeSet(int x) {
		p[x] = x;
	}

	static int findSet(int x) {
//		if (x == p[x])
//			return x;
//		else
//			return findSet(p[x]);
//		위 코드는 똑같은 작업을 또 할 수 있어서 효율 down

		// 패스 컴프레숀을 적용한 코드
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

	static void union(int x, int y) {
		// x와 y가 대표자 여야 한다.
//		p[findSet(y)] = findSet(x); // x그룹에 y그룹을 넣는 것.
		// 애초에 x, y를 대표를 내려보내면
		p[y] = x;
	}

	static String input = "7 11\r\n" 
	+ "0 1 32\r\n" 
	+ "0 2 31\r\n" 
	+ "0 5 60\r\n" 
	+ "0 6 51\r\n" 
	+ "1 2 21\r\n"
	+ "2 4 46\r\n"
	+ "2 6 25\r\n" 
	+ "3 4 34\r\n"
	+ "3 5 18\r\n"
	+ "4 5 40\r\n"
	+ "4 6 51\r\n";

}
