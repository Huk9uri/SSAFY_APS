package DP;

import java.util.Scanner;

public class 거스름돈 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int money = sc.nextInt();
		int[] dp = new int[money + 1];

		// 1,4,6원 고민

		for (int i = 1; i <= money; i++) {
			int minCnt = 987654321;
			minCnt = Math.min(minCnt, dp[i - 1] + 1);

			if (i >= 4) {
				minCnt = Math.min(minCnt, dp[i - 4] + 1);
			}
			if (i >= 6) {
				minCnt = Math.min(minCnt, dp[i - 6] + 1);
			}
			dp[i] = minCnt;
		} // 동전 전부 고려
		
		System.out.println(dp[money]);
	}
}
