package SWEA_1231_중위순회;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for (int t = 1; t <= test_case; t++) {

			int n = sc.nextInt();
			String[][] str = new String[n][1];
			char[][] data = new char[n][3]; // char[i][0] 알파벳 , char[i][1] 왼쪽 자식 노드 번호 char[i][2] 오른쪽 자식 번호
			sc.nextLine();
			for (int i = 0; i < n; i++) {
				str[i]= sc.nextLine().split(" ");
			}
			System.out.println(Arrays.deepToString(str));
			

//			for (int i = 0; i < data.length; i++) {
//				for (int j = 0; j < data[0].length; j++) {
//					System.out.println(data[i][j] + " ");
//				}
//				System.out.println();
		}

	}
}
