package Queue2;

import java.util.Arrays;

public class Solution {
	// 원형큐 구현
	// 배열크기가 4 ==> 데이터를 3개 담을 수 있다.첫번째칸은 항상 비워둬야하므로
	static String[] queue = new String[4];
	static int front, rear;// 0으로 초기화하므로 선언만 해도 초기값 0
	static int N = queue.length;
	static int size;

	public static void main(String[] args) {
		
		enQueue("루나");
		enQueue("데이지");
		enQueue("맥스");
		enQueue("강기훈");
		
		System.out.println(size());
		System.out.println(Arrays.toString(queue));
		deQueue();
		deQueue();
		deQueue();
		deQueue();
		enQueue("강기훈1");
		enQueue("소남주1");
		enQueue("지유림1");
		System.out.println(Arrays.toString(queue));
	}

	// 포화상태 확인
	static boolean isFull() {
		// return front - rear == 1; front와 rear가 역전됐을때 예외됨
		return (N + front - rear) % N == 1; // 4 = n
		// 모듈러 연산에서 나눠지는 값이 음수일 경우, 자바에서는 음수 나눗셈을 지원하지 않으므로
		// 그 값에 n을 더해주고 실행한다.
	}

	static boolean isEmpty() {
		return front == rear;
	}

	static void enQueue(String item) {
		// queue[++rear] = item; 선형 큐
		if(isFull()) {
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
		rear = (rear + 1) % N;
		queue[rear] = item;
		size ++;
	}

	static String deQueue() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		// return queue[++front]; 선형 큐

		size--;
		front = (front + 1) % N;
		return queue[front];
	}

	static String Qpeek() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		// return queue[front+1] 선형큐
		return queue[(front + 1) % N];
	}

	static int size() {
		return size;
		// return (N + rear - front) % N; 가능
	}

}
