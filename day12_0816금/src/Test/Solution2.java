package Test;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스의 수

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt(); // 학생 수
			int min = sc.nextInt(); // 분반 별 최소 인원 수
			int max = sc.nextInt(); // 분반 별 최대 인원 수

			int[] best = new int[max];
			int[] soso = new int[max];
			int[] bad = new int[max];

			int[] score = new int[N];
			for (int i = 0; i < score.length; i++) {
				score[i] = sc.nextInt();
			}
			Arrays.sort(score);
			System.out.println(Arrays.toString(score));
		}
	}
}