package SWEA_1209_Sum;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int x = sc.nextInt();
			int[][] map = new int[100][100];
			int[] arr = new int[202];

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 각 행의 합 구하기
			int index = 0;
			for (int i = 0; i < map.length; i++) {
				int sum = 0;
				for (int j = 0; j < map.length; j++) {
					sum += map[i][j];
				}
				arr[index] = sum;
				index++;
			}

			for (int j = 0; j < map.length; j++) {
				int sum = 0;
				for (int i = 0; i < map.length; i++) {
					sum += map[i][j];
				}
				arr[index] = sum;
				index++;
			}

			int crossSum1 = 0;
			for (int i = 0; i < map.length; i++) {
				int j = i;
				crossSum1 += map[i][j];
			}
			arr[index++] = crossSum1;

			int crossSum2 = 0;
			for (int i = 0; i < map.length; i++) {
				int j = 99 - i;
				crossSum2 += map[i][j];
			}
			arr[index++] = crossSum2;
			Arrays.sort(arr);
			System.out.println("#" + t + " " + arr[arr.length - 1]);
		}

	}
}