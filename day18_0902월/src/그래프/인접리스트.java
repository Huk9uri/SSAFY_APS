package 그래프;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점의 갯수
		int E = sc.nextInt(); // 간선의 갯수

		List<Integer>[] adjList = new ArrayList[V];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			//가중치를 같이 저장하고 싶다면 1. 클래스를 정의해서 넣는다 2. int[]에 넣는다.
			adjList[A].add(B);
			adjList[B].add(A);
			
			// 인접 행렬 vs 인접 리스트의 (장단점 정도만 알고있자)
		}

	}
}
