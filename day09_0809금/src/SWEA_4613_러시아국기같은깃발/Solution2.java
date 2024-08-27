package SWEA_4613_러시아국기같은깃발;

import java.util.Scanner;

public class Solution2 {
	static int N;
	static int M;
	static char map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();

			map = new char[N][M];
			// 배열 입력
			for (int i = 0; i < map.length; i++) {
				map[i] = sc.next().toCharArray();
			}

			int min = 2501;

			for (int w = 0; w < N - 2; w++) {
				for (int b = w + 1; b < N - 1; b++) {
					int change = 0;
					for (int i = 1; i < w; i++) {
						change += countChange(i, 'W');
					}
					for (int i = w; i < b; i++) {
						change += countChange(i, 'B');
					}
					for (int i = b; i < N; i++) {
						change += countChange(i, 'R');
					}
					if (change < min) {
						min = change;
					}
				}
			}
			System.out.println("#" + test_case + " " + min);

		}
	}

	static int countChange(int row, char color) {
		int cnt = 0;
		for (int c = 0; c < M; c++) {
			if (map[row][c] != color) {
				cnt++;
			}
		}
		return cnt;
	}
}
