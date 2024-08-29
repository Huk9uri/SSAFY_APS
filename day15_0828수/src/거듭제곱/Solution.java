package 거듭제곱;

import java.util.Scanner;

public class Solution {

	static int jeGob(int N, int M) {
		if (M <= 0) {
			return 1;
		}
		return N * jeGob(N, M - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int t = sc.nextInt();

			int N = sc.nextInt();
			int M = sc.nextInt();

			int result = jeGob(N, M);
			System.out.println("#" + i + " " + result);

		}
	}
}