package SWEA_2001_파리퇴치;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution2 { // 달팽이처럼 풀 수 있을 것 같은데
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		int x = 0;
		int y = 0;

		int direction = 0;
		// 우 하 좌 상
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 }; // map[x][y]

		int nx = x + dx[direction];
		int ny = y + dy[direction];

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
			int cnt = 0;
			int[] sumList = new int[(N - M + 1) * (N - M + 1)];
			for (int j = 0; j < (N - M + 1) * (N - M + 1); j++) {
				int sum = 0;
				while (cnt <= M * M) {
					sum += map[x][y];
					if(nx>=0 && nx<= M)
				}

			}
		}
	}

}
