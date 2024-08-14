package TEST;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt(); // n개의 숫자
			int k = sc.nextInt(); // 내림차순 후 k번째 수

			String[] num = new String[n];
			String s = sc.next();
			for (int j = 0; j < num.length; j++) {
				num[j] = String.valueOf(s.charAt(j));
			}

			System.out.println(Arrays.toString(num));

			Stack<String> stack = new Stack<>();

			for (int j = 0; j < num.length; j++) {
				stack.add(num[j]);
			}
			int size = num.length / 4; // size = 3

			String[][] cycle = new String[size][4];

			// String 2차원 배열 초기화.
			for (int x = 0; x < size; x++) { // size -1 회전
				for (int y = 0; y < cycle[0].length; y++) {
					cycle[x][y] = "";
				}
			}
			System.out.println("+".repeat(20));
			for (int x = 0; x < size; x++) { // cycle[0][0]
				for (int j = 0; j < num.length; j += size) {
					for (int y = 0; y < cycle[0].length; y++) {
						for (int p = 0; p < size; p++) {
							cycle[x][y] += num[j + p]; // cycle[0][0] = num 0, 1, 2
														// cycle[0][1] = num 3, 4, 5
														// cycle[0][2] = num 6, 7, 8
														// cycle[0][3] = num 9, 10, 11
						}
					}
				}
				
				
				System.out.println();
			}

			// 0회전
			String[] zero = { "", "", "", "" };
			int index = 0;
			for (int j = 0; j < num.length; j += size) {
				for (int p = 0; p < size; p++) {
					zero[index] += num[j + p];
				}
				index++;
			}
			System.out.println(Arrays.toString(zero));

			// 1회전 시키기
			String popItem = stack.pop();
			stack.add(0, popItem);

			// 1회전 시킨 queue를 one에 넣기
			Object[] oneList = stack.toArray();
			System.out.println(Arrays.toString(oneList)); //

			// 1회전
			String[] one = { "", "", "", "" };
			index = 0;
			for (int j = 0; j < oneList.length; j += size) {
				for (int p = 0; p < size; p++) {
					one[index] += oneList[j + p];
				}
				index++;
			}
			System.out.println(Arrays.toString(one));

			// 2회전 시키기
			popItem = stack.pop();
			stack.add(0, popItem);

			// 2회전 시킨 queue를 two에 넣기
			Object[] twoList = stack.toArray();
			System.out.println(Arrays.toString(twoList)); //

			// 2회전
			String[] two = { "", "", "", "" };
			index = 0;
			for (int j = 0; j < twoList.length; j += size) {
				for (int p = 0; p < size; p++) {
					two[index] += twoList[j + p];
				}
				index++;
			}
			System.out.println(Arrays.toString(two));

			// 3회전 시키기
			popItem = stack.pop();
			stack.add(0, popItem);

			// 3회전 시킨 queue를 three에 넣기
			Object[] threeList = stack.toArray();
			System.out.println(Arrays.toString(threeList)); //

			// 3회전
			String[] three = { "", "", "", "" };
			index = 0;
			for (int j = 0; j < threeList.length; j += size) {
				for (int p = 0; p < size; p++) {
					three[index] += threeList[j + p];
				}
				index++;
			}
			System.out.println(Arrays.toString(three));
		}
	}

}
