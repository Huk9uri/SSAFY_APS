package 순열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 순열04_비트마스킹 {
	static int[] nums;
	static int N;
	static List<int[]> list = new ArrayList<>();
	static int[] result;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		result = new int[N];
		perm(0, 0);
		
		for (int[] arr : list) {
			System.out.println(Arrays.toString(arr));
		}
	}// main

	// idx :결과 배열에 저장할 위치. 재귀의 깊이 depth
	static void perm(int idx, int visited) {
		// 기저조건
		if (idx == N) {
			// 모두 고려.
			System.out.println(Arrays.toString(result));
			list.add(result);
			return;
		}

		// 재귀
		for (int i = 0; i < N; i++) {
			// 사용하지 않은 원소를 가지고 만들어야한다.
			// 1. 사용했으면 넘어간다. continue
			if ((visited & (1 << i)) != 0)
				continue;
			result[idx] = nums[i];
			perm(idx + 1, visited | (1 << i));
			// 2. 사용하지 않았다면 if() { }

		}
	}
}