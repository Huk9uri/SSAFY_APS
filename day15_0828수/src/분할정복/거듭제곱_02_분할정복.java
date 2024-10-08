package 분할정복;

public class 거듭제곱_02_분할정복 {
	public static void main(String[] args) {
		int C = 2;
		int N = 10;
	}

	static int pow(int C, int N) {
		if (N == 1)
			return C;

		if (N % 2 == 0) {
			return pow(C, N / 2) * pow(C, N / 2);
		} else {
			return pow(C, (N - 1) / 2) * pow(C, (N - 1) / 2) * C;
		}
	}

	static int pow2(int C, int N) {
		if (N == 1)
			return C;

		if (N % 2 == 0) {
			int tmp = pow2(C, N / 2);
			return tmp * tmp;
		} else {
			int tmp = pow2(C, (N - 1) / 2);
			return tmp * tmp * C;
		}
	}

}