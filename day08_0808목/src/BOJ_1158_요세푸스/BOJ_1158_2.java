package BOJ_1158_요세푸스;

public class BOJ_1158_2 {
	static int front;
	static int rear;
	static int size;

	static void enQueue(int[] queue, int num) {
		if (size == queue.length - 1) { // 큐가 가득 찼을 때
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
		rear = (rear + 1) % queue.length;
		queue[rear] = num;
		size++;
	}

	static int deQueue(int[] queue) {
		if (isEmpty()) {
			System.out.println("큐가 비어 있습니다.");
			return -1;
		}
		front = (front + 1) % queue.length;
		int popNum = queue[front];
		size--;
		return popNum;
	}

	static boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		int n = 7;  // 테스트 케이스 n = 7
		int k = 3;  // 테스트 케이스 k = 3

		int[] queue = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			enQueue(queue, i);
		}

		System.out.print("<");

		while (!isEmpty()) {
			for (int i = 1; i < k; i++) {
				enQueue(queue, deQueue(queue));
			}
			System.out.print(deQueue(queue));
			if (!isEmpty()) {
				System.out.print(", ");
			}
		}
		System.out.println(">");
	}
}
