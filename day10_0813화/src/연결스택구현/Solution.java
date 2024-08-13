package 연결스택구현;

class Node {
	String data;
	Node link;
}

class LinkedStack {
	int size;
	Node top; // 리스트의 마지막 노드 변수
	final int MAX_SIZE = 10;

	public LinkedStack() {
		top = null;
	}

	// 삽입
	void push(String data) {
		if (isFull()) {
			System.out.println("스택이 가득 찼습니다.");
			return;
		}
		Node newNode = new Node();
		newNode.data = data;
		newNode.link = top;
		top = newNode;
		size++;
	}

	String pop() {
		if (top == null) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		String popData = top.data;
		top = top.link;
		size--;
		return popData;
	}

	boolean isEmpty() {
		return size == 0;
	}

	boolean isFull() {
		return size == MAX_SIZE;
	}

	void printStack() {
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return;
		}
		Node cur = top;
		while (cur != null) {
			String str = "";
			System.out.print("<=" + cur.data + str);
			cur = cur.link;
		}
		System.out.println();
	}

}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedStack stack = new LinkedStack();

		stack.push("서울7반 최혁규");
		stack.push("서울7반 배장한");
		stack.push("서울7반 김소현");
		stack.push("서울7반 손진호");
		stack.push("서울7반 최보성");
		stack.push("서울7반 배현수");
		stack.push("서울7반 김서현");
		stack.push("서울7반 이지운");
		stack.push("서울7반 김혜민");
		stack.push("서울7반 이재현");
		stack.printStack();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println("pop 메서드 3회 실행 후 ");
		stack.printStack();
	}

}
