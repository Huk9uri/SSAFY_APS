package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree<E> { // 뭐가 들어갈 지 모르니 제너릭

	private Object[] nodes;
	private int lastIndex; // 마지막 노드의 인덱스
	private final int MAX_SIZE;

	public CompleteBinaryTree(int maxSize) {
		super();
		MAX_SIZE = maxSize;
		nodes = new Object[MAX_SIZE + 1]; // 노드 저장 인덱스 1부터 사용

	}

	public boolean isFull() {
		return lastIndex == MAX_SIZE;
	}

	public void add(E e) {
		if (isFull())
			throw new RuntimeException("트리가 노드로 가득 찼습니다.");

		nodes[++lastIndex] = e;
	}

	public void bfs() {
		// 1. 순서를 관리할 큐를 생성한다.
		// 1번 인덱스, 2번인덱스 인지 순서가 들어가므로 Integer
		Queue<Integer> queue = new ArrayDeque<>(); // 큐의 구현체로 ArrayDeque

		// 2. 처음 탐색이 될 대상을 큐에 넣기
		queue.offer(1); // 루트노드 인덱스 넣기

		// 3. 큐에 저장되어 있는 탐색 대상들을 차례대로 꺼내어 방문한다.
		while (!queue.isEmpty()) {
			// 4. 현재 탐색할 대상 꺼내기
			int cur = queue.poll();
			// 5. 탐색 대상 탐색하기 ( 대상으로 해야할 작업들 수행)
			System.out.print(nodes[cur] + " ");
			// 6. 탐색 대상과 관계를 맺고 있는 대상들을 다음에 방문하기 위해 순서를 결정하는 큐에 넣기
			// 완전이진트리 이므로
			if (cur * 2 <= lastIndex)
				queue.offer(cur * 2);// 왼쪽 노드 : cur * 2
			// 왼쪽 자식 노드가 트리의 마지막에 저장된 인덱스보다 작거나 같다면 존재한다는 것이므로 큐에 넣는다.
			if (cur * 2 + 1 <= lastIndex)
				queue.offer(cur * 2 + 1); // 오른쪽 자식 노드 :cur *2 +1

		}
	}

	public void bfs2() {
		// 1. 순서를 관리할 큐를 생성한다.
		// 1번 인덱스, 2번인덱스 인지 순서가 들어가므로 Integer
		Queue<int[]> queue = new ArrayDeque<>(); // 큐의 구현체로 ArrayDeque

		// 2. 처음 탐색이 될 대상과 너비를 큐에 넣기
		queue.offer(new int[] { 1, 0 }); // 루트노드 {인덱스, 너비} 넣기

		// 3. 큐에 저장되어 있는 탐색 대상들을 차례대로 꺼내어 방문한다.
		while (!queue.isEmpty()) {
			
			// 4. 현재 탐색할 대상 꺼내기
			int info[] = queue.poll();
			int cur = info[0]; // 탐색 인덱스
			int breadth = info[1]; // 너비
			
			// 5. 탐색 대상 탐색하기 ( 대상으로 해야할 작업들 수행)
			System.out.print(nodes[cur] + "(" + breadth + ") "); // 대상과 너비 같이 출력
			
			// 6. 탐색 대상과 관계를 맺고 있는 대상들을 다음에 방문하기 위해 순서를 결정하는 큐에 넣기
			// 완전이진트리 이므로
			if (cur * 2 <= lastIndex)
				queue.offer(new int[] { cur * 2, breadth + 1 });// 왼쪽 노드 : cur * 2
			// 왼쪽 자식 노드가 트리의 마지막에 저장된 인덱스보다 작거나 같다면 존재한다는 것이므로 큐에 넣는다.
			if (cur * 2 + 1 <= lastIndex)
				queue.offer(new int[] { cur * 2 + 1, breadth + 1 }); // 오른쪽 자식 노드 :cur *2 + 1
										//다음 탐색 노드 인덱스 , 너비 
		}
	}

}
