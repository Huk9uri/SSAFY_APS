package 병합정렬;

import java.util.Arrays;

public class 병합정렬_myOwn {
	static int[] arr = { 7, 5, 13, 2, 79, 12, 35, 42 };
	static int N = arr.length;
	static int[] tmp = new int[N];
	// 추가 공간이 필요함

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			mergeSort(0, N-1);
			System.out.println(Arrays.toString(arr));
	}

	// left : 구간의 시작 위치 // right : 구간의 끝
	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽 구간의 시작 포인터
		int R = mid + 1; // 오른쪽 구간의 시작 포인터
		int idx = left; // tmp 배열의 인덱스.

		while (L <= mid && R <= right) { // 아직 정렬할 것이 남아있다면
	 		if (arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			}
		}
		// while문 이후 어느 한 쪽 구간에서 정렬 되지 않은 원소가 존재
		if (L <= mid) { // 왼쪽 구간에 값이 남았다면
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		} 
		else { // 오른쪽 구간에 값이 남았다면
			for (int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		//원본 배열에 반영하기
		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
	}

}
