package SWEA_1206_View;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int buildings = sc.nextInt();
			int[] arr = new int[buildings + 4];
			arr[0] = 0;
			arr[1] = 0;
			arr[arr.length - 2] = 0;
			arr[arr.length - 1] = 0;
			for (int j = 2; j <= buildings + 1; j++) {
				arr[j] = sc.nextInt();
			}
			// System.out.println(Arrays.toString(arr));
			int sum = 0;
			for (int j = 2; j <= buildings + 1; j++) {
				int[] side = new int[4];
				if (arr[j] > arr[j + 1] && arr[j] > arr[j + 2] && arr[j] > arr[j - 1] && arr[j] > arr[j - 2]) {
					side[0] = arr[j - 2];
					side[1] = arr[j - 1];
					side[2] = arr[j + 1];
					side[3] = arr[j + 2];

					Arrays.sort(side);
					int cnt = arr[j] - side[3];
					sum += cnt;
				}
			}
			System.out.println("#" + i + " " + sum);

		}
		sc.close();

	}

}
