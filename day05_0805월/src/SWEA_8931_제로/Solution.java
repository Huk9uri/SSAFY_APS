package SWEA_8931_제로;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
 //1234
		//123
		for (int i = 1; i <= testCase; i++) {
			int lines = sc.nextInt();
			int sum = 0;
			int lastIndex = -1;
			int[] list = new int[lines];
			for (int j = 0; j < lines; j++) {
				int money = sc.nextInt();
				if( money != 0) {
					list[++lastIndex] = money;
				}else {
					list[lastIndex--] = 0;
				}
			}
			for (int j = 0; j < list.length; j++) {
				sum += list[j];
			}
			System.out.println("#" + i + " " + sum);
			
		}
	}
}