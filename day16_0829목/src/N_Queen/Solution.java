package N_Queen;

import java.util.Scanner;

public class Solution {
	static int N;
	static boolean[][] canBeAttacked;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			canBeAttacked = new boolean[N][N];
		}
	}
	
	static void queen(int depth) {
		//기저조건
		if( depth == N) return;
		
		if()
		//재귀
	}

}