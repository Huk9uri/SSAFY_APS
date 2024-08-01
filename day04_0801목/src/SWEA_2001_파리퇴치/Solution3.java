package SWEA_2001_파리퇴치;

import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int i = 1; i <= testCase; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt(); // 파리채 크기 M x M
			int[][] map = new int[N][N];
			// 각 칸마다 파리 마릿수 입력
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map.length; k++) {
					map[j][k] = sc.nextInt();
				}
			}
			int[] sumList = new int[(N - M + 1) * (N - M + 1)];
			int index = 0;
			for (int k = 0; k < N - M + 1; k++) {
				for (int r = 0; r < N - M + 1; r++) {
					int sum = 0;
					for (int j = 0; j < M; j++) {
						for (int l = 0; l < M; l++) {
							sum += map[j + r][k + l];
						}
					}
					sumList[index++] = sum;
				}
			}
			Arrays.sort(sumList);
			System.out.println("#" + i + " " + sumList[sumList.length-1]);
		}
	}

}
