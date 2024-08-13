package doubly;


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
		// 0 이면 제일 앞에 삽입
		// size 면 제일 뒤에 삽입
		if (i < 0 || i > size) {
			System.out.println("삽입할 수 없는 범위입니다.");
			return;
		}
		size++;
		// 삽입하고자 하는 위치 앞의 노드를 찾는다..
		Node curr = head;
		for (int k = 0; k < i; k++) {
			curr = curr.next;
		}

		// 연결 관계를 재구성한다.

		// 1. 새 노드 만들기
		Node newNode = new Node();
		newNode.data = data;
		
		// 2. 새 노드 연결해주기
		newNode.next = curr.next;
		newNode.prev = curr;
		
		// 3. 기존 노드 연결 재구성
		curr.next.prev = newNode;
		curr.next = newNode;

	}
	// 삭제
	void removeData(int i) {
		// 0은 제일 앞의 데이터 삭제
		// size-1 은 제일 뒤의 데이터 삭제
		
		if( i < 0 || i>= size) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}
		size--;
		
		//삭제할 위치를 찾는다.
		Node rmNode = head.next;
		for (int k = 0; k < i; k++) {
			rmNode = rmNode.next;
		}
		rmNode.prev.next = rmNode.next;
		rmNode.next.prev = rmNode.prev;
	}
	
	void printReverse() {
		Node curr = tail.prev; //출력해야하니까 tail 이전 노드로 지정
		String str = "";
		while(curr != head) {
			str = "<-" + curr.data + str;  
			curr = curr.prev;
		}
		System.out.println(str);
	}
	
	

}

public class LinkedList_양방향연결리스트 {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.addData(0, "서울1반");
		list.addData(0, "서울2반");
		list.addData(0, "서울3반");
		list.addData(0, "서울4반");
		list.printReverse();
		
		list.removeData(1);
		list.removeData(1);
		list.printReverse();
		
		System.out.println(list.size);
	}

}
