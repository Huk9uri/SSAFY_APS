package 조합;

import java.util.Arrays;

public class 조합_02_재귀함수_반복문 {
	static String[] elements = {"상추","패티","토마토","치즈"};
	static int N, R; // N : 재료의 수 / R : 내가 뽑고 싶은 재료의  수
	//nCr
	static String[] sel ; // 뽑은 재료를 저장할 배열
	
	public static void main(String[] args) {
		N = 4;
		R = 2;
		sel = new String[R];
		combination(0, 0);
	}
	
	//idx : 재료의 인덱스 , sidx : 뽑은 재료의 인덱스
	static void combination(int idx, int sidx) {
		//기저조건 : 
		if( sidx == R) {
			// 모든 재료를 전부 다 뽑았다.
			System.out.println(Arrays.toString(sel));
			return;
		}
		//재귀부분 : 
		for (int i = idx; i <elements.length; i++) {
			sel[sidx] = elements[i]; // 뽑았다.
			combination(i + 1, sidx + 1);
		}
	}

	
}
