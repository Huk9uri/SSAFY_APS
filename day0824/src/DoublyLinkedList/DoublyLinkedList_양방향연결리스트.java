package DoublyLinkedList;

class Node {
	String data;
	Node prev;
	Node next;
}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;

	public DoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	// 삽입
	void addData(int i, String data) {
		// 0이면 제일 앞에 삽입
		// size면 제일 뒤에 삽입
		if (!(0 <= i && i <= size)) {
			System.out.println("삽입 범위 확인");
			return;
		}
		size++;
		Node curr = head;
		// 삽입 위치 앞의 노드 찾기
		for (int k = 0; k < i; k++) {
			curr = curr.next;
		}
		Node newNode = new Node();
		newNode.data = data;

		// 새 노드 먼저 연결해주기
		newNode.next = curr.next;
		newNode.prev = curr;

		// 기존 노드 연결 재구성
		curr.next.prev = newNode;
		curr.next = newNode;
	}

	void removeData(int i) {
		// 0 은 제일 앞 데이터 삭제
		// size -1 은 제일 뒤 데이터 삭제
		if (!(0 <= i && i < size)) {
			System.out.println("삭제 범위 확인");
			return;
		}
		size--;
		// 삭제할 위치 찾기
		Node rmNode = head.next; // 시작 위치를 head.next로 한번 옮겨주거나 for문을 한 번 더 돌도록 하거나 둘 중 하나 선택
		for (int k = 0; k < i; k++) {
			rmNode = rmNode.next;
		}
		rmNode.prev.next = rmNode.next;
		rmNode.next.prev = rmNode.prev;

	}

	void printReverse() {
		Node curr = tail.prev;
		String str = "";
		while (curr != head) {
			str = "<-" + curr.data + str;
			curr = curr.prev;
		}
		System.out.println(str);
	}

}

public class DoublyLinkedList_양방향연결리스트 {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.addData(0, "A");
		list.addData(0, "B");
		list.addData(0, "C");
		list.addData(0, "D");
		list.printReverse();
		list.addData(0, "E");
		list.addData(0, "F");
		list.addData(0, "G");
		list.printReverse();
		list.removeData(0);
		System.out.println("삭제");
		list.printReverse();
		list.addData(0, "H");
		list.printReverse();
	}
}
