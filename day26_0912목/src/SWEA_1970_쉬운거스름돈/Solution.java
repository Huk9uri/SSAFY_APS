package SWEA_1970_쉬운거스름돈;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] coins = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int money = sc.nextInt();

		int[] dp = new int[money + 1];

		// 50000, 10000, 5000, 1000, 500, 100, 50, 10
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < coins.length; i++) {
			int coin = coins[i];
			for (int j = coin; j <= money; j++) {
				if (dp[j - coin] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
				}
			}
		}
		
		
	}
}