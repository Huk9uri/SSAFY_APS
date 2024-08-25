package SWEA_4613_러시아국기같은깃발;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			char[][] map = new char[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
			}

			int minChanges = 2501;

			// 흰색
			for (int w = 1; w < N - 1; w++) {
				// 파란색
				for (int b = w + 1; b < N; b++) {
					int changes = 0;

					for (int i = 0; i < w; i++) {
						changes += countChanges(map[i], 'W');
					}

					for (int i = w; i < b; i++) {
						changes += countChanges(map[i], 'B');
					}

					for (int i = b; i < N; i++) {
						changes += countChanges(map[i], 'R');
					}

					if (changes < minChanges) {
						minChanges = changes;
					}
				}
			}

			System.out.println("#" + test_case + " " + minChanges);
		}
	}

	static int countChanges(char[] row, char color) {
		int count = 0;
		for (char c : row) {
			if (c != color) {
				count++;
			}
		}
		return count;
	}
}
