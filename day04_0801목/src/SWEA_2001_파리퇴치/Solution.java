package SWEA_2001_파리퇴치;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int i = 1; i <= testCase; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt(); // 파리채 크기 M x M
			int[][] map = new int[N][N];
			// 각 칸마다 파리 마릿수 입력
			fillPari(sc, map);

			int maxParis = maxParis(map, N, M);
			System.out.println("#" + i + " " + maxParis);
		}
	}

	static void fillPari(Scanner sc, int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	}

	static int maxParis(int[][] map, int N, int M) {
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
		return sumList[sumList.length - 1];
	}

}
