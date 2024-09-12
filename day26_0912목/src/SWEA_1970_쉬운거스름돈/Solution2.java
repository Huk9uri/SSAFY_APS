package SWEA_1970_쉬운거스름돈;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	static int[] coins = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int money = sc.nextInt();
			int[] counts = new int[coins.length];
			
			for (int i = 0; i < counts.length; i++) {
				counts[i] = money / coins[i];
				money = money % coins[i];
			}
			System.out.println("#" + tc);
			for (int i : counts) {
				System.out.print( i + " ");
			}


		}

	}
}