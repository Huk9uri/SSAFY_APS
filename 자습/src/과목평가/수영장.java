package 과목평가;

import java.util.Scanner;

public class 수영장 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[] price = new int[4];
			int[] useCnt = new int[13];
			int[] dp = new int[13];
			for (int i = 0; i < price.length; i++) {
				price[i] = sc.nextInt();
			}
			for (int i = 1; i < useCnt.length; i++) {
				useCnt[i] = sc.nextInt();
			}

			for (int i = 1; i < dp.length; i++) {
				// i-1 달 + 일일권  vs ㅑ-1 달 + 한달권
				dp[i] = Math.min(dp[i - 1] + useCnt[i] * price[0], dp[i - 1] + price[1]);

				if (i >= 3) {
					dp[i] = Math.min(dp[i], dp[i - 3] + price[2]);
				}
			}
			int result = Math.min(dp[12], price[3]);
			System.out.println("#" + tc + " " + result);
		}
	}

}
