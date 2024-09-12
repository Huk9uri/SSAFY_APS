package 배낭문제;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 물건 개수
		int W = sc.nextInt(); // 배낭의 무게

		int[] weights = new int[N + 1]; // 물건들의 무게를 저장할 배열
		int[] costs = new int[N + 1]; // 물건들의 가격을 저장할 배열

		for (int i = 1; i <=N; i++) {
			weights[i] = sc.nextInt();
			costs[i] = sc.nextInt();
		} // 입력 끝

		int[][] dp = new int[N + 1][W + 1];

		for (int i = 1; i <= N; i++) {
			for (int w = 0; w <= W; w++) {
				//내가 고려할 물건의 무게가, 임시 무게보다 작다면
				//지금 물건을 가방에 담을 수 있다면
				if(weights[i] <= w) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]] + costs[i]);
				}else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		System.out.println(dp[N][W]);
	}
}