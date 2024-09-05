package 프림;

import java.util.Arrays;
import java.util.Scanner;

public class 프림01_반복문 {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점 . 정점의 번호가 0부터 시작함
		int E = sc.nextInt(); // 간선의 수

		int[][] adjArr = new int[V][V];

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int W = sc.nextInt();

			adjArr[from][to] = adjArr[to][from] = W;
		}

		// 방문 췤
		boolean[] visited = new boolean[V]; // 해당 정점 뽑았어
		int[] p = new int[V]; // 부모 저장 배열
		int[] dist = new int[V]; // 간선 가중치 .. key

		// 프림 제 1장 : 초기화를 시켜라
		for (int i = 0; i < V; i++) {
			p[i] = -1;
			dist[i] = INF;
		}
//		Arrays.fill(dist, INF);

		// 프림 제 2장 : 시작 정점 결정하기 / 시작 정점의 key를 0으로
		dist[0] = 0; // 0번 정점부터 시작하겠다.

		// 프림 제 3장: 가중치 배열을 돌면서 값이 가장 낮은것을 골라 방문 체크 하고 갱신한다.

		for (int i = 0; i < V - 1; i++) {
			int min = INF;
			int idx = -1;
			// 방문하지 않았으면서 가장 작은 값
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			} // idx = j, min = dist[j];
			visited[idx] = true; // 방문처리

			// 방문하지 않았고, 갱신 가능하면 갱신하기
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < V; i++) {
			ans += dist[i];
		}
		System.out.println(ans);

	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n";
}
