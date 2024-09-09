package 위상정렬_Stack;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
	static int V,E;
	static int[][] adjArr; //인접 행렬
	static int[] degree; // 진입차수 저장할 배열
	static boolean[] visited; // 방문 체크
	static Stack<Integer> ans; // 
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt(); // 정점
		E = sc.nextInt(); // 간선
		
		StringBuffer sb = new StringBuffer();
		adjArr = new int[V+1][V+1]; 
		degree = new int[V+1]; // 진입차수를 저장할 배열
		visited =new boolean[V+1];
		
		ans = new Stack<>();
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjArr[from][to] = 1; // 가중치는 따로 없으므로 1로 표기;
			// 유향 이므로 adjArr[to][from] 바꿔서 저장 안해도 됨.
			// to의 진입차수 증가시키기 
			degree[to]++;
		}// 입력 완료.
		
		for (int i = 1; i < V+1; i++) {
			if(degree[i] == 0) {
				dfs(i);
			}
		}
		
		while(!ans.isEmpty()) {
			sb.append(cook[ans.pop()]).append(" ");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int curr) {
		visited[curr] = true; // 방문했다
		//오해 포인트 . 방문을 했다고 해서 무조건 출력을 해서는 안된다.
		// 아직 선행 조건이 남아 있을 수 있다.
		for (int i = 1; i < V+1; i++) {
			//간선이 연결되어 있고, 방문하지 않았다면 
			if(adjArr[curr][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
		ans.push(curr); // 연결 되어 있는 모든 정점을 다녀왔다면
	}

	static String input = "9 9\r\n"
			+ "	1 4\r\n"
			+ "	1 8\r\n"
			+ "	2 3\r\n"
			+ "	4 3\r\n"
			+ "	8 5\r\n"
			+ "	3 5\r\n"
			+ "	5 6\r\n"
			+ "	9 6\r\n"
			+ "	6 7\r\n"
			+ "";

}
