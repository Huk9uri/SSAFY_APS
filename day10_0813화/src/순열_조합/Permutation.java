package 순열_조합;

public class Permutation {
	static int[] arr = { 1, 2, 3 }; // 원소를 저장한 배열
	static boolean[] visited = new boolean[arr.length]; // 각 원소가 이미 사용되었는지를 체크하는 배열
	static int[] output = new int[arr.length];// 순열 결과를 저장할 배열
	static int r = 2;// 선택할 원소의 개수

	public static void main(String[] args) {
		// 순열 생성 함수 호출: 깊이(depth)는 0부터 시작
		perm(arr, output, visited, 0, r);
	}

	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int r) {
		// 종료 조건: depth가 r에 도달하면 현재까지 선택한 원소들로 순열을 완성한 것임
		if (depth == r) {
			// 현재까지 선택된 원소들을 출력
			for (int i = 0; i < r; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}

		// 모든 원소를 대상으로 순열 생성 시도
		for (int i = 0; i < arr.length; i++) {
			// 현재 원소가 이미 선택되었는지 확인
			if (!visited[i]) {
				// 현재 원소를 선택함으로 표시 (방문 여부 업데이트)
				visited[i] = true;
				// 현재 깊이 위치에 현재 원소를 저장
				output[depth] = arr[i];
				// 다음 깊이로 재귀 호출 (현재 원소를 선택한 상태로 나머지 원소들로 순열 생성)
				perm(arr, output, visited, depth + 1, r);
				// 백트래킹: 원상태로 복구하여 다른 선택지를 탐색할 수 있도록 함
				visited[i] = false;
			}
		}
	}
}