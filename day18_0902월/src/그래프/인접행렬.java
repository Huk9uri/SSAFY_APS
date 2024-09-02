package 그래프;

import java.util.Iterator;
import java.util.Scanner;

public class 인접행렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점의 갯수
		int E = sc.nextInt(); // 간선의 갯수

		int[][] adjArr = new int[V][V]; // 만약 시작 정점이 1이면 [V+1][V+1]

		for (int i = 0; i < E; i++) {
			// E 개의 간선을 입력 받는다.
			int A = sc.nextInt();
			int B = sc.nextInt(); // 2개의 정점이 주어진다.
//			int W = sc.nextInt(); // 가중치가 있다면 3개가 주어진다.
			
			adjArr[A][B] = 1; // 가중치가 없다면 1, 없다면 W;
			adjArr[B][A] = 1; // 만약 무향이라면 반대의 경우도 같이 저장해줘야 함!!!!
			
//			adjArr[A][B] = adjArr[B][A] = W;  // 한줄 작성
		}

	}
}
