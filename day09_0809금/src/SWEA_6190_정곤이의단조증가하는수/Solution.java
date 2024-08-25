package SWEA_6190_정곤이의단조증가하는수;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			int max = -1;
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int result = arr[i] * arr[j];
					if(checkDanjo(result)) {
						max = Math.max(max, result);
					}
				}
			}
			System.out.println("#" + test_case + " " + max);

		}
	}

	static boolean checkDanjo(int result) {
		int prevDigit = 10;
		while (result > 0) {
			int currDigit = result % 10;
			if (currDigit > prevDigit)
				return false;
			prevDigit = currDigit;
			result /= 10;
		}
		return true;
	}
}