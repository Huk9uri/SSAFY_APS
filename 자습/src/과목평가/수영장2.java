package 과목평가;

import java.util.Scanner;

public class 수영장2 {
	static int min;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[] price = new int[4];
			int[] useCnt = new int[13];
			for (int i = 0; i < price.length; i++) {
				price[i] = sc.nextInt();
			}
			int daySum = 0;
			for (int i = 1; i < useCnt.length; i++) {
				useCnt[i] = sc.nextInt();
				daySum += useCnt[i];
			}
			min = Math.min(daySum * price[0], price[3]); // all 1일 vs 1년권 비교
			dfs(0, useCnt, price, 0);
			System.out.println("#" + tc + " " + min	);
		}

	}

	public static void dfs(int month, int[] useCnt, int[] price, int sum) {
		if (sum > min) {
			return;
		}

		if (month > 12) {
			min = Math.min(min, sum);
			return;
		}

		if (useCnt[month] == 0) {
			dfs(month + 1, useCnt, price, sum);
		} else {
			// 일일권
			dfs(month + 1, useCnt, price, sum + useCnt[month] * price[0]);
			// 한달권
			dfs(month + 1, useCnt, price, sum + price[1]);
			// 3달권
			dfs(month + 3, useCnt, price, sum + price[2]);
		}
	}
}
