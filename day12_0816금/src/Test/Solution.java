package Test;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스의 수

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt(); // 학생 수
			int min = sc.nextInt(); // 분반 별 최소 인원 수
			int max = sc.nextInt(); // 분반 별 최대 인원 수

			int[] score = new int[N];
			int[] cntScore = new int[101];
			for (int i = 0; i < score.length; i++) {
				score[i] = sc.nextInt();
			}
			Arrays.sort(score);
			System.out.println(Arrays.toString(score));

			for (int i = 0; i < score.length; i++) {
				cntScore[score[i]]++;
			}
			System.out.println(Arrays.toString(cntScore));
			int cnt = 0;
			for (int i = 0; i < cntScore.length; i++) {
				if (cntScore[i] != 0)
					cnt++;
			}
			System.out.println(cnt);

		}
	}
}
