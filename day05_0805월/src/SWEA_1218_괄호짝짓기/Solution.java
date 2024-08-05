package SWEA_1218_괄호짝짓기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
//1234
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int size = sc.nextInt();
			String[] arr = new String[size];
			int lastIndex = -1;
			for (int j = 0; j < arr.length; j++) {
				String s = sc.next();
				if (s.equals("(") || s.equals("{") || s.equals("[") || s.equals("<")) {
					arr[++lastIndex]= s;
				}
			}

		}
	}
}