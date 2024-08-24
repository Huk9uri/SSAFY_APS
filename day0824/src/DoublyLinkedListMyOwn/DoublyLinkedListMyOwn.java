package DoublyLinkedListMyOwn;

class Node {
	String data;
	Node prev;
	Node next;
}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;

	DoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	// 삽입
	void addData(int i, String data) {
		if (!(0 <= i && i <= size)) {
			System.out.println("삽입 범위 확인 ");
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
		newNode.prev = curr;

		curr.next.prev = newNode;
		curr.next = newNode;
	}

	void removeData(int i) {
		if (!(0 <= i && i < size)) {
			System.out.println("삭제 범위 확인");
			return;
		}
		size--;
		// 삭제할 노드 찾기
		Node rmNode = head.next;
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
			str = " <-- " + curr.data + str;
			curr = curr.prev;
		}
		System.out.println(str);
	}
}

public class DoublyLinkedListMyOwn {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();

		list.addData(0, "A");
		list.addData(0, "B");
		list.addData(0, "C");
		list.addData(0, "D");
		list.addData(0, "E");
		list.addData(0, "F");
		list.printReverse();
		
		list.removeData(0);
		list.printReverse();
		
		list.removeData(list.size-1);
		list.printReverse();
		
		
		
	}
}






