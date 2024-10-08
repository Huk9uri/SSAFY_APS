package SWEA_1954_달팽이숫자;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int i = 1; i <= testCase; i++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];

			int x = 0;
			int y = 0;
			int direction = 0;
			// 우 : 0 하 : 1 좌 : 2 상 : 3
			int[] dx = { 0, 1, 0, -1 };
			int[] dy = { 1, 0, -1, 0 };

			int num = 1;
			while (num <= n * n) {
				map[x][y] = num;
				num++;

				int nx = x + dx[direction];
				int ny = y + dy[direction];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0) {
					x = nx;
					y = ny;
				} else {
					direction = (direction + 1) % 4;
					x = x + dx[direction];
					y = y + dy[direction];
				}
			}
			System.out.println("#" + i);
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					System.out.print(map[j][k] + " ");
				}
				System.out.println();
			}
		}
	}
}
