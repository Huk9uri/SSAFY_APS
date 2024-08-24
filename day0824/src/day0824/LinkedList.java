package day0824;

class Node {
	String data;
	Node link;
}

class SinglyLinkedList {
	Node head;
	int size;

	SinglyLinkedList() {
		head = new Node(); // 헤드에 새로운 노드 할당 .. 더미 노드
	}
	// 삽입

	void addData(int i, String data) { // index i에 새로운 데이터 추가하기
		// 0이면 제일 앞, size와 같으면 제일 뒤
		if (!(0 <= i && i <= size)) {
			System.out.println("삽입할 범위를 확인해주세여");
			return;
		}

		Node newNode = new Node();
		newNode.data = data;

		size++;
		// 삽입할 위치 앞에 있는 노드 찾기
		Node curr = head; // 헤드에서 출발
		for (int k = 0; k < i; k++) {
			curr = curr.link;
		} // index i번째에 삽입이므로 for문을 다 돌았을 때, 삽입 위치 비로 앞의 노드를 만난다.
			// 새 노드부터 연결
		newNode.link = curr.link;
		curr.link = newNode;
	}

	// 삭제
	void removeData(int i) {
		// 0번 : 제일 앞의 데이터 삭제
		// size -1 : 마지막 데이터 삭제
		if (!(0 <= i && i < size)) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}
		size--;

		// 헤드 노드에서 출발
		Node curr = head;
		// 삭제할 노드의 앞 노드로 이동
		for (int k = 0; k < i; k++) {
			curr = curr.link;
		}
		curr.link = curr.link.link;

	}

	// 조회
	void printAll() {
 		Node curr = head.link;
		while(curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.link;
		}
		System.out.println();
	}
}

public class LinkedList {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addData(0, "A");
		list.printAll();
		list.addData(0, "B");
		list.addData(0, "C");
		list.printAll();
		list.addData(0, "D");
		list.addData(0, "F");
		list.addData(0, "G");
		list.printAll();
		
		

	}

}
