package SWEA_2001_파리퇴치;

import java.util.Arrays;
import java.util.Scanner;

public class Solution4 {
	static int n;
	static int m;
	static int[][] map;
	static int[] cntList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt(); //
			m = sc.nextInt(); // 스프레이 세기
			map = new int[n + 2 * (m - 1)][n + 2 * (m - 1)];
			cntList = new int[n * n * 2];
			for (int i = m - 1; i < map.length - m + 1; i++) {
				for (int j = m - 1; j < map.length - m + 1; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			nozlePlus();
			nozleX();
			Arrays.sort(cntList);
			System.out.println("#" + test_case + " " + cntList[cntList.length - 1]);
		}
	}

	static void nozlePlus() {
		int index = 0;
		for (int i = m - 1; i < map.length - m + 1; i++) {
			for (int j = m - 1; j < map.length - m + 1; j++) {
				int sum = 0;
				for (int k = 1; k < m; k++) {
					sum += map[i][j + k] + map[i][j - k] + map[i + k][j] + map[i - k][j];
				}
				cntList[index++] = sum + map[i][j];
			}
		}
	}

	static void nozleX() {
		int index = n * n;
		for (int i = m - 1; i < map.length - m + 1; i++) {
			for (int j = m - 1; j < map.length - m + 1; j++) {
				int sum = 0;
				for (int k = 1; k < m; k++) {
					sum += map[i + k][j + k] + map[i - k][j - k] + map[i + k][j - k] + map[i - k][j + k];
				}
				cntList[index++] = sum + map[i][j];
			}
		}
	}
}