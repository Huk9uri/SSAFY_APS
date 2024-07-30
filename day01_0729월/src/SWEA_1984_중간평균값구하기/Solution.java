package SWEA_1984_중간평균값구하기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		int[] arr = new int[10];
		
		for (int i = 1; i <= t; i++) {
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			Arrays.sort(arr);
			sum = sum - (arr[0]+arr[arr.length-1]);
			double avg = (double)sum / 8;
			
			System.out.println("#"+ i+ " " + Math.round(avg));
		}

	}
}