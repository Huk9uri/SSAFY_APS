package SWEA_1209_Sum;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	
	static void fillNum(int[][]map, Scanner sc) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	}
	
	static void getRowSum(int[][] map, int[] arr) {
		int index = 0;
		for (int i = 0; i < map.length; i++) {
			int sum = 0;
			for (int j = 0; j < map.length; j++) {
				sum += map[i][j];
			}
			arr[index] = sum;
			index++;
		}
	}
	
	static void getColSum(int[][] map, int[] arr) {
		int index = 100;
		for (int j = 0; j < map.length; j++) {
			int sum = 0;
			for (int i = 0; i < map.length; i++) {
				sum += map[i][j];
			}
			arr[index] = sum;
			index++;
		}
	}
	
	static void getDiaSum(int[][] map, int[] arr) {
		int crossSum1 = 0;
		for (int i = 0; i < map.length; i++) {
			int j = i;
			crossSum1 += map[i][j];
		}
		arr[200] = crossSum1;
		
		int crossSum2 = 0;
		for (int i = 0; i < map.length; i++) {
			int j = 99 - i;
			crossSum2 += map[i][j];
		}
		arr[201] = crossSum2;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int x = sc.nextInt();
			int[][] map = new int[100][100];
			int[] arr = new int[202];
			
			fillNum(map, sc);

			getRowSum(map, arr);
			getColSum(map, arr);
			getDiaSum(map, arr);
			
			Arrays.sort(arr);
			System.out.println("#" + t + " " + arr[arr.length - 1]);
		}

	}
}