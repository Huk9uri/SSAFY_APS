package SWEA_1860_진기의최고급붕어빵;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
	static List<String> list = new ArrayList<>();
	static int front = -1;
	static int rear = -1;
	static int listSize = rear - front;

	static void enQueue(String bread) {
		list.add(bread);
		rear++;
	}

	static String deQueue() {
		String popItem = list.remove(++front);
		return popItem;
	}

	static boolean isEmpty() {
		if (listSize == 0) {
			return true;
		} else
			return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int i = 1; i <= testCase; i++) {
			int people = sc.nextInt(); // 손님 수
			int time = sc.nextInt(); // 걸리는 시간
			int bread = sc.nextInt(); // 시간 후 나오는 붕어빵 갯수
			// 매 초를 인덱스로 갖고, 요소는 손님의 수
			int[] arr = new int[11111 + 1];

			for (int j = 0; j < people; j++) {
				int eta = sc.nextInt();
				arr[eta]++;
			}
			// 첫 사이클 돌리기도 전에 손님이 온 경우
			for (int j = 0; j < time; j++) {
				if (arr[j] > 0) {
					System.out.println("#" + i + " Impossible");
					break;
				}
			}
			for (int j = time; j < arr.length; j++) {
				if (j % time == 0) {
					for (int k = 0; k < bread; k++) {
						enQueue("boong"); // 붕어빵 갯수만큼 빵 넣기
					}
				} else {
					for (int k = 0; k < arr[j]; k++) {
						deQueue();
					}
					if (isEmpty()) { // 빵이 비어있으면
						System.out.println("#" + i + " Impossible");
						break;
					}
				}
			}
			if (!isEmpty()) {
				System.out.println("#" + i + " Possible");
			}

		}
	}
}