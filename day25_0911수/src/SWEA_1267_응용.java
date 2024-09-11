import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1267_응용 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= 10; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			int[][] adjArr = new int[V + 1][V + 1];
			// 인접리스트 만들어 저장
			List<Integer>[] list = new ArrayList[V + 1];
			// V+1 길이인 것 별표

			for (int i = 1; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}
			// 진입차수 배열
			int[] degree = new int[V + 1];
			int[] depth = new int[V + 1];
			for (int i = 0; i < E; i++) {
				// 시작 노드
				int from = sc.nextInt();
				// 끝노드
				int to = sc.nextInt();
				// 끝 노드의 진입차수 증가시키기.
				degree[to]++;
				list[from].add(to);
			} // 그래프 만들기 끝

			// 탐색 시작 큐
			Queue<Integer> queue = new LinkedList();

			// 각 테스트 케이스 정답

			// 위상정렬 start.
			// 1. 우선 진입차수가 0인 노드를 queue에 ADD
			for (int i = 1; i < degree.length; i++) {
				if (degree[i] == 0) {
					queue.add(i);
					depth[i] = 1;
				}
			}
			// 2. queue가 빌떄까지 반복
			int maxDepth = 0;
			while (!queue.isEmpty()) {
				// 큐에서 하나를 뽑는다.
				int curr = queue.poll();
				maxDepth = Math.max(maxDepth, depth[curr]);

				// 그 다음 뽑힌 노드와 연결된 다른 노드의 진입차수를 1 감소 시킨다.
				// 1 감소 했을 때 0이 되면 queue에 추가
				for (int next : list[curr]) {
					degree[next]--;
					if(degree[next] ==0) {
						queue.add(next);
						depth[next] = depth[curr] + 1;
					}
				}
			}
			// 위상정렬 end
			System.out.println("#" + tc + " " + maxDepth);
		}

	}

}
