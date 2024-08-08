package SWEA_1860_진기의최고급붕어빵;

import java.util.Scanner;

public class Solution {
	// 원형 큐 구현
	private String[] queue;
	private int front;
	private int rear;
	private int size;

	public Solution(int capacity) {
		queue = new String[capacity];
		front = 0;
		rear = 0;
		size = 0;
	}

	public void enQueue(String item) {
		if (size == queue.length) {
			return;
		}
		queue[rear] = item;
		rear = (rear + 1) % queue.length;
		size++;
	}

	public String deQueue() {
		if (size == 0) {
			return null;
		}
		front = (front + 1) % queue.length;
		size--;
		return queue[front];
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return size;
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

			Solution queue = new Solution(11111);

			boolean possible = true;

			for (int j = time; j < arr.length; j++) {
				if (j % time == 0 && j != 0) {
					for (int k = 0; k < bread; k++) {
						queue.enQueue("bread"); // 붕어빵 갯수만큼 빵 넣기
					}
				}
				while (arr[j] > 0) { // 손님이 있을 때
					if (queue.isEmpty()) { // 붕어빵이 비어있으면
						possible = false;
						break;
					}
					queue.deQueue();
					arr[j]--;
				}
				// 첫 사이클 돌리기도 전에 손님이 온 경우
				if (j < time && arr[j] > 0) {
					possible = false;
					break;
				}
			}

			if (possible == true) {
				System.out.println("#" + i + " Possible");
			} else {
				System.out.println("#" + i + " Impossible");
			}
		}
	}
}