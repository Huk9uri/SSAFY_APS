import java.util.Iterator;
import java.util.Scanner;

public class Algo1_서울_7반_최혁규 {
	static int T;
	static int N;
	static boolean[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new boolean[N][N];
			String s = sc.next();
			System.out.println(s);
			int[] count = new int[N];
			for (int i = 0; i < s.length(); i++) {
				count[s.charAt(i)-'0']++; // 각 세로열에 배치 될 횟수 카운트
			}

			// 2차원 boolean배열 생성 후, * 이 들어가는 배열에 true.
			// 같은 행의 모든 열이 true 라면 카운트 배열의 모든 값들을 1씩 줄인다.

			for (int i = 0; i < s.length(); i++) {
				if (map[N - 1][s.charAt(i)] == false) {
					map[N - 1][s.charAt(i)] = true;
				} else {
					int k = 1;
					while ((N - 1 - k > 0) && map[N - 1 - k][s.charAt(i)] == true) {
						k++;
					}
					map[N - 1 - k][s.charAt(i)] = true;
				}
				int cnt = 0;
				for (int j = 0; j < map.length; j++) {
					if (map[N - 1][j]) { // 한 행의 열들을 순회하면서 true면 cnt++
						cnt++;
					}
					if (cnt == N - 1) { // 같은 행의 모든 칸이 true로, N-1과 cnt값이 같다면
						for (int k = 0; k < count.length; k++) {
							count[k]--; // 모든 카운팅 배열 원소를 1 줄인다.
						}
					}
				}
			}
			// 별을 출력할 새로운 2차원배열을 생성한 후
			char[][] result = new char[N][N];
			// count[i]의 갯수에 맞게 별을 채우고 출력한다.
			for (int j = 0; j < result.length; j++) {
				for (int i = 0; i < count[j]; i++) {
					result[i][j] = '*';
				}
			}
			
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result.length; j++) {
					System.out.print(result[i][j] + "");
				}System.out.println();
			}

		}

	}

}
