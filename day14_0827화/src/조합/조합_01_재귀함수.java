package 조합;

import java.util.Arrays;

public class 조합_01_재귀함수 {
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
		if (idx == N) {
			return;
		}
		//재귀부분 : 
		
		//해당 idx 번째 재료를 사용했는지 안했는지 
		sel[sidx] = elements[idx];
		combination(idx + 1, sidx + 1);
		
//		sel[sidx] = null; // 재료를 사용하지 않음 . : 나중에 덮어 써버림
		combination(idx+1, sidx);
	}

	
}
