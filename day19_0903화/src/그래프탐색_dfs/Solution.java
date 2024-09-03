package 그래프탐색_dfs;

import java.util.Scanner;

public class Solution {
	static int V, E;
	static int[][] adj;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		E = sc.nextInt();

		adj = new int[V + 1][V + 1];
		visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adj[from][to] = adj[to][from] = 1; // 무향 = 양방향 이동 가능
		} // 간선 입력 완료
		dfs(1);
	}

	// v: 현재 정점
	static void dfs(int v) {
		visited[v] = true;
		System.out.println(v);

		// 나와 인접하면서 방문하지 않은 정점 방문
		for (int i = 1; i <= V; i++) {
		    	// 방문 X    &&    인접하는지
			if (!visited[i] && adj[v][i] == 1) { 
				dfs(i);
			}
		}

	}

	static String input = "7 9\r\n" + "1 2\r\n" + "1 3\r\n" + "1 6\r\n" + "2 4\r\n" + "2 7\r\n" + "3 4\r\n" + "4 7\r\n"
			+ "5 6\r\n" + "5 7";

}