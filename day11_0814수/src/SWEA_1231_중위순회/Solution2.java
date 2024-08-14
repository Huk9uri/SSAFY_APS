package SWEA_1231_중위순회;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for (int t = 1; t <= test_case; t++) {

			int n = sc.nextInt();
			String[] word = new String[n];
			sc.nextLine();
			char[][] data = new char[n][3]; //
			for (int i = 0; i < n; i++) {
				String[] str = sc.nextLine().split(" "); // [1,W,2,3]
				System.out.println(Arrays.toString(str));
				for (int j = 0; j < str[i].length(); j++) {
					data[i][j] = str[j].charAt(j+1);
				}
//				data[i][0] = str[1];
//				data[i][1] = str[2];
//				data[i][2] = str[3];
//			
			}

			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[0].length; j++) {
					System.out.print(data[i][j] + " ");
				}
				System.out.println();
			}

//			for (int i = 0; i < word.length; i++) {
//				word[i]
//			}

		}
	}
}
