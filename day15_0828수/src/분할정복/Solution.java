package 분할정복;

public class Solution {
	public static void main(String[] args) {
		int C = 2;
		int N = 10;
		int result = pow(C, N);
		System.out.println(result);
	}

	static int pow(int C, int N) {
		if (N == 1) {
			return C;
		}

		if (N % 2 == 0) {
			int temp = pow(C, N / 2);
			return temp * temp;
		} else {
			int temp = pow(C, (N - 1) / 2);
			return temp * temp * C;
		}
	}
}