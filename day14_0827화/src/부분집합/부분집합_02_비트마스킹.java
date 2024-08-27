package 부분집합;

public class 부분집합_02_비트마스킹 {
	static String[] elements = { "단무지", "햄", "오이", "시금치" };
	static int N = 4; // 재료의 개수
	static int[] sel = new int[N];// 해당 인덱스의 재료를 사용 여부 저장하는 배열

	public static void main(String[] args) {
		// 2**N만큼 반복
		for (int i = 0; i < (1 << N); i++) {
			// 재료 확인 for 문 필요
			// J = 재료의 인덱스
			String tmp = "";
			for (int j = 0; j < N; j++) {
				if ((i & (i << j)) > 0) {
					tmp += elements[j];
				}
			}
			System.out.println(tmp);
		}

	}
}