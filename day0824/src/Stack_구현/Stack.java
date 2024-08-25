package Stack_구현;

import java.util.Arrays;

public class Stack {
	static String[] stack = new String[100];
	static int top = -1;

	static void push(String s) {
		if (isFull()) {
			System.out.println("스택이 가득 찼습니다.");
			return;
		}
		stack[++top] = s;
	}

	static String pop() {
		if (isEmpty()) {
			System.out.println("스택이 모두 비어있습니다.");
			return null;
		}
		String popItem = stack[top];
		stack[top--] = null;
		return popItem;
	}

	static boolean isEmpty() {
		return top == -1;
	}

	static boolean isFull() {
		return top == stack.length - 1;
	}

	static void printAll() {
		for (int i = 0; i <= top; i++) {
			System.out.print(stack[i]);
		}
		System.out.println();
	}

	static void popAll() {
		while (!isEmpty()) {
			System.out.print(pop());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push("A");
		push("B");
		push("C");
		push("Y");
		push("y");
		push("z");
		printAll();
		System.out.println(top);
		System.out.println(isEmpty());
		System.out.println(isFull());
		popAll();

	}

}
