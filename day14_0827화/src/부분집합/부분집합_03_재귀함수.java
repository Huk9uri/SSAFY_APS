package 부분집합;

public class 부분집합_03_재귀함수 {
	static String[] elements = { "단무지", "햄", "오이", "시금치" };
	static int N = 4; // 재료의 개수
	static boolean[] sel;


	public static void main(String[] args) {
		N = 4;
		sel = new boolean[N];
		powerSet(0);

	}
	
	static void powerSet(int idx) {
		//기저조건 : 재귀를 빠져나가는 조건 
		if(idx >= N) {
			String tmp = "김밥 : ";
			for (int i = 0; i < N; i++) {
				if(sel[i])
					tmp+=elements[i];
			}
			System.out.println(tmp);
			return;
		}
		
		//재귀부분 : 나 자신을 다시 호출하는 부분
		
		sel[idx] = true ;  // 해당 위치의 재료를 사용 했다.
		powerSet(idx+1);
		sel[idx] = false ; // 해당 위치의 재료 사용 X
		powerSet(idx+1);
		
	}
}