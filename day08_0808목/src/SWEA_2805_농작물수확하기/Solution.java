package SWEA_2805_농작물수확하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int i = 1; i <= testCase; i++) {
			StringBuilder sb = new StringBuilder();
			int n = sc.nextInt();

			int[][] map = new int[n][n];
			
			
			for (int j = 0; j < n; j++) {
				String s = sc.next();
				sb.append(s);
			}
			System.out.println(sb);
			
			
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map.length; k++) {
					map[j][k] = sc.nextInt();
				}
			}
			
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map.length; k++) {
					System.out.print(map[j][k]);
				}System.out.println();
			}

			
			int sum = 0;
			for (int j = 0; j < n / 2; j++) {
				for (int k = n / 2 - j; k <= n / 2 + j; k++) {
					sum += map[j][k];
				}
			}

			for (int j = n / 2; j < n / 2 + 1; j++) {
				for (int k = 0; k < map.length; k++) {
					sum += map[j][k];
				}
			}

			for (int j = n / 2 + 1; j < map.length; j++) {
				for (int k = n / 2 - (n - 1 - j); k <= n / 2 + (n - 1 - j); k++) {
					sum += map[j][k];
				}
			}
			
			System.out.println(sum);
		}

	}
}