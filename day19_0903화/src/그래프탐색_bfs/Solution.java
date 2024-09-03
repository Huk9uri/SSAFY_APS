package 그래프탐색_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int V, E;
	static List<Integer>[] adj;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		E = sc.nextInt();

		adj = new ArrayList[V + 1];// 배열만 만들고 리스트는 생성된 것이 아님
		visited = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adj[from].add(to); // 무향 = 양방향 이동 가능
			adj[to].add(from); // 무향 = 양방향 이동 가능
		} // 간선 입력 완료
		bfs(1);
	}

	// v: 현재 정점

	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(v);
		visited[v] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll(); // 큐에서 정점 하나 꺼냄
			System.out.println(curr);

			// curr에 인접하면서 방문하지 않은 정점들을 queue에 넣는다.
			for (int w : adj[curr]) {
				if (!visited[w]) {
					queue.add(w);
					visited[w] = true;
				}
			}
		}

	}

	static String input = "7 9\r\n" + "1 2\r\n" + "1 3\r\n" + "1 6\r\n" + "2 4\r\n" + "2 7\r\n" + "3 4\r\n" + "4 7\r\n"
			+ "5 6\r\n" + "5 7";

}