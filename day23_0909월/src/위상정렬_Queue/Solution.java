package 위상정렬_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // 정점
		int E = sc.nextInt(); // 간선
		
		
		int[][] adjArr = new int[V+1][V+1]; 
		int[] degree = new int[V+1]; // 진입차수를 저장할 배열
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjArr[from][to] = 1; // 가중치는 따로 없으므로 1로 표기;
			// 유향 이므로 adjArr[to][from] 바꿔서 저장 안해도 됨.
			// to의 진입차수 증가시키기 
			degree[to]++;
		}// 입력 완료.
		
		// 위상정렬 큐 제 1장 : 진입차수가 0인 친구들을 몽땅 넣는다.
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 9; i >0; i--) {
			if(degree[i] == 0) {
				queue.add(i);
			}
		}
		StringBuffer sb = new StringBuffer();
		//제 2장: 큐가 공백이 될 떄까지 진행
		//간선을 제거하고, 진입차수가 0이 된 정점들의 번호를 큐에 새로 넣는다.
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(cook[curr]).append("\n");
			for (int i = 1; i < V+1; i++) {
				if(adjArr[curr][i] == 1) {
					degree[i]--; // 진입차수 1개 깎는다.
					adjArr[curr][i] = 0; // 이거 사실 안해도 괜찮음. 문제에 따라 해야될 수도
					//이번에 정점 i의 진입차수가 0이 되었다면 ? queue에 넣는다.
					if(degree[i] == 0) {
						queue.add(i);
					}
				}
			}
		}
		// 밑에서 한번에 출력하고 싶다. 2가지 방식 존재 .
		//정점을 저장해놓기 / 스트링빌더.
		System.out.println(sb.toString());
		
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