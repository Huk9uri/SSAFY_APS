package SWEA_1228_암호문1;

import java.util.Scanner;

class Node {
	String data;
	Node next;
}

class SinglyLinkedList {
	Node head;
	int size;

	SinglyLinkedList() {
		head = new Node();
	}

	void addData(int i, String data) {
		if (!(0 <= i && i <= size)) {
			System.out.println("삽입 범위 확인 필요");
			return;
		}
		size++;
		Node curr = head;
		for (int k = 0; k < i; k++) {
			curr = curr.next;
		}
		Node newNode = new Node();
		newNode.data = data;

		newNode.next = curr.next;
		curr.next = newNode;
	}

	void printAll() {
		Node curr = head.next;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	void print(int i) { // i 까지만 출력
		Node curr = head.next;
		for (int k = 0; k < i; k++) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			SinglyLinkedList list = new SinglyLinkedList();
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				list.addData(i, sc.next());
			}
			int orderCnt = sc.nextInt();
			for (int i = 0; i < orderCnt; i++) {
				sc.next(); // 삽입 명령어 . 필요없다.
				int idx = sc.nextInt();
				int addCnt = sc.nextInt();
				for (int k = 0; k < addCnt; k++) {
					list.addData(idx, sc.next());
					idx++;
				}
			}
			
			System.out.print("#" + test_case + " ");
			list.print(10);
		}
	}

}
