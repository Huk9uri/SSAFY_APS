import java.util.Arrays;
import java.util.Scanner;

public class Algo2_서울_7반_최혁규 {
	static int T;
	static int N;
	static int M;
	static int K;
	static int[] backNumbers;
	static int[] output;
	static int cnt;
	static boolean[] isUsed;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			long A = System.nanoTime();
			N = sc.nextInt(); // 총 선수
			M = sc.nextInt(); // 뽑을 선수의 수
			K = sc.nextInt(); // 등번호의 합.
			cnt = 0;

			backNumbers = new int[N]; // 등번호 배열 생성, 초기화
			for (int i = 0; i < N; i++) {
				backNumbers[i] = sc.nextInt();
			}
			isUsed = new boolean[N];
			output = new int[M];
			perm(0, 0);
			if (cnt > 0) {
				// 등번호 배열의 순서가 다르면 서로 다른 경우이므로
				// 각 원소의 자리가 섞이는 경우를 곱하면
				// 모든 경우의 수가 나온다.
				cnt *= factorial(M);
				System.out.println("#" + tc + " " + cnt);
			} else {
				System.out.println("#" + tc + " -1");
			}
			long B = System.nanoTime();
			System.out.println(B-A);
		}
	}

	static void perm(int depth, int start) {
		if (depth == M) { // 순열에 원소를 다 넣었다면
			int sum = 0;
			for (int i = 0; i < output.length; i++) {
				sum += output[i]; // 합을 구하고
			}
			if (sum == K) // K와 같을 때
				cnt++; // cnt 증가
			return;
		}

		for (int i = start; i < N; i++) {
			if (!isUsed[i]) { // 등번호 중복 방지
				output[depth] = backNumbers[i]; // 사용되지 않은 번호를 순열 depth 번째 인덱스에 저장
				isUsed[i] = true; // 등번호 사용 표시
				perm(depth + 1, i); // 다음 depth 
			}
			isUsed[i] = false; // 
		}
	}

	static int factorial(int k) {
		if (k == 1) {
			return 1;
		}
		return k * factorial(k - 1);

	}

}
