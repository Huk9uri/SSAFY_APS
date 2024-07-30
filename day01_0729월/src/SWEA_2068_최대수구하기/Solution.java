package SWEA_2068_최대수구하기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		int[] arr = new int[10];

		for (int i = 1; i <= t; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr);

			System.out.println("#" + i + " " + arr[arr.length - 1]);
		}
	}

}
