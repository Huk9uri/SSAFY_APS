package 병합정렬;

import java.util.Arrays;

public class 병합정렬_myOwn2 {
	static int[] arr = { 7, 5, 13, 2, 79, 12, 35, 42 };
	static int N = arr.length;
	static int[] tmp = new int[N];
	// 추가 공간이 필요함

	public static void main(String[] args) {
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void mergeSort(int left, int right) {
		
		if(left< right) { 
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽 구간의 시작 위치 포인터
		int R = mid + 1; // 오른쪽 구간의 시작 위치 포인터
		int idx = left; // 임시 배열에 정렬시켜 놓을 인덱스	
		
		while(L <= mid && R <= right) {
			if(arr[L] >= arr[R]) {
				tmp[idx++] = arr[R++]; // 임시 배열 인덱스에 더 작은 값을 넣기 
			}else {
				tmp[idx++] = arr[L++];
			}
		}
		//While문 이후에도, 왼쪽이나 오른쪽 구간에 아직 정렬되지 않은 원소들이 존재할 수 있다.
			
		if( L <= mid ) {
			for (int i = L ; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		}else {
			for (int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		// 정렬을 모두 실행했다면 . 임시배열에 저장한 값을 그대로 원본 배열에 덮어씌워주기
		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
		
	}
	

}
