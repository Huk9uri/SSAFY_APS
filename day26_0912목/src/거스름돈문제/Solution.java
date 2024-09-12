package 거스름돈문제;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int money = sc.nextInt();
		int[] dp = new int[money + 1];

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
		}
		System.out.println(dp[money]);
	}
}