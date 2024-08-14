package TEST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution2 {

	// 스택으로 마지막거를 빼서 add로 맨 앞에 놓는다.
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();

		for (int T = 1; T <= test_case; T++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int size = n / 4;
			String[] str = sc.next().split("");
			Stack<String> stack = new Stack<>();

			List<String> list = new ArrayList<>();

			for (int i = 0; i < str.length; i++) {
				stack.push(str[i]);
			}
			System.out.println(stack.toString());
			String[] zero = { "", "", "", "" };
			int index = 0;
			for (int j = 0; j < stack.size(); j += size) {
				for (int p = 0; p < size; p++) {
					zero[index] += str[j + p];
				}
				index++;
			}
			System.out.println("0회전  " + Arrays.toString(zero));

			String[][] cycle = new String[size - 1][4]; // 1회전 부터 size-1 회전까지

			for (int i = 1; i <= size - 1; i++) { // i회전
				String popItem = stack.pop(); // 맨뒤 숫자를 빼내고
				stack.add(0, popItem); // 맨 앞에 넣어준다.
				// String 2차원 배열 초기화.
				for (int x = 0; x < size - 1; x++) { // size -1 회전
					for (int y = 0; y < cycle[0].length; y++) {
						cycle[x][y] = "";
					}
				}
				Object[] afterCycle = stack.toArray();
				System.out.println(i + "회전 후 " + Arrays.toString(afterCycle));
				for (int x = 0; x < cycle.length; x++) {
					// cycle[0][0] = num 0, 1, 2
					// cycle[0][1] = num 3, 4, 5
					// cycle[0][2] = num 6, 7, 8
					// cycle[0][3] = num 9, 10, 11
					index = 0;
					for (int j = 0; j < stack.size(); j += size) {

						for (int p = 0; p < size; p++) {
							cycle[x][index] += afterCycle[j + p];
						}
						index++;

					}
				}
				for (int x = 0; x < cycle.length; x++) {
					for (int y = 0; y < cycle[x].length; y++) {
						if (!list.contains(cycle[x][y])) {
							list.add(cycle[x][y]);
						}
					}
				}

//				for (int j = 0; j < cycle.length; j++) {
//					for (int l = 0; l < cycle[0].length; l++) {
//						System.out.print(cycle[j][l] + " ");
//					}
//					System.out.println();
//				}

			}
			for (int i = 0; i < zero.length; i++) {
				if (!list.contains(zero[i])) {
					list.add(zero[i]);
				}
			}
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j) + " ");
			}
			//16진수 어떻게 바꿔요...??????????
										
		}
	}

}
