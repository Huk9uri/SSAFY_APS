package 햄버거다이어트;

import java.util.Scanner;

public class Solution {
	static int N, L; // N: 재료 개수, L : 제한칼로리
	static int[] cals;
	static int[] scores;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			L = sc.nextInt();
			scores = new int[N];
			cals = new int[N];
			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			} // input
			ans = 0;
			makeBurger(0, 0, 0);
			System.out.println("#" + test_case+ " " + ans);
		} // test_case
	}// main
		//

	static void makeBurger(int idx, int sumScore, int sumCal) {
		// 백트래킹 .
		if (sumCal > L) // idx-1까지 고려 다 하고, idx 를 하려 했는데
			return;		// 제한 칼로리를 넘으면 더이상 할 필요가 없다.
			

		// 기저 조건
		if (idx == N) {
			// 모든 재료를 전부 다 고려했다.
			if (sumScore > ans) {
				ans = sumScore;
			}
			return;
		}

		// 재귀
		// 이번에 idx번째 재료를 사용했다..
		makeBurger(idx + 1, sumScore + scores[idx], sumCal + cals[idx]);
		// idx 번째 재료를 사용하지 않았다.
		makeBurger(idx + 1, sumScore, sumCal);
	}
}