package singly;

class Node {
	String data;
	Node link;
}

class SinglyLinkedList {
	Node head;
	int size;

	SinglyLinkedList() {
		head = new Node();
	}

	// 삽입 size++; 노드의 사이 사이를 가리키도록
	void addData(int i, String data) { // i 가 가르키는 인덱스에 새로운 데이터를 넣겠다.
		// 0이면 제일 앞에 추가
		// size와 같으면 제일 뒤에 추가
		// i 범위 췤
		if (i < 0 || i > size) {
			System.out.println("삽입할 범위를 확인해주세요.");
			return;
		}
		size++;

		// 새 노드 생성
		Node newNode = new Node();
		newNode.data = data;

		// 삽입할 위치 앞에 있는 노드 찾기

		Node cur = head;
		for (int k = 0; k < i; k++) {
			cur = cur.link;
		}
		// 새 노드부터 연결
		newNode.link = cur.link;
		cur.link = newNode;
	}

	// 삭제 size --; 노드 인덱스 직접 가리키기
	void removeData(int i) {
		// 0번 : 제일 앞에 있는 데이터 삭제
		// size-1 : 마지막 데이터 삭제

		if (i < 0 || i >= size) {
			System.out.println("삭제할 범위를 확인해주세요.");
			return;
		}
		size--;
		// 시작할 위치는 헤드로 지정
		Node cur = head;

		// 지우고자 하는 노드 앞으로 이동
		for (int k = 0; k < i; k++) {
			cur = cur.link;
		}
		// ㅁ A B C 에서 ㅁ A ㅁ C 연결을 위해 링크의 링크
		cur.link = cur.link.link;

	}

	void printAll() {
		Node cur = head.link;
		while (cur != null) {
			System.out.print(cur.data + " - > ");
			cur = cur.link;
		}
		System.out.println();
	}
}

public class LinkedList_단순연결리스트 {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addData(0, "서울1반");
		list.printAll();
		list.addData(0, "서울2반");
		list.addData(0, "서울3반");
		list.printAll();
		list.addData(0, "서울4반");
		list.addData(0, "서울5반");
		list.addData(0, "서울6반");
		list.printAll();
		list.removeData(0);
		list.removeData(0);
		list.printAll();
	}
}