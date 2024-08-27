package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt(); // 노선 갯수
			int[][] bus = new int[n][]; // [노선번호][정류장]
			for (int i = 0; i < n; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				int[] busStop = new int[end - start + 1];
				int index = 0;
				for (int j = start; j <= end; j++) {
					busStop[index++] = j;
				}
				bus[i] = busStop;
			}
//			for (int i = 0; i < bus.length; i++) {
//				for (int j = 0; j < bus[i].length; j++) {
//					System.out.print(bus[i][j] + " ");
//				}
//				System.out.println();
//			}
			int C = sc.nextInt();
			int[] result = new int[C + 1];
			for (int i = 0; i < bus.length; i++) {
				for (int j = 0; j < bus[i].length; j++) {
					result[bus[i][j]]++;
				}
			}
			System.out.print("#" + test_case + " ");
			for (int i = 1; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
		}
	}

}
