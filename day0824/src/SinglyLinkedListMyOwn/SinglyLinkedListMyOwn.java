package SinglyLinkedListMyOwn;

// 노드를 정의해준다.
class Node {
	// 노드는 데이터 필드와, 링크 필드로 구성되어 있다.
	String data;
	Node link;
}

class SinglyLinkedList {
	Node head;
	int size;

	SinglyLinkedList() {
		head = new Node();
	}

	// 삽입
	void addData(int i, String data) {
		if (!(0 <= i && i <= size)) {
			System.out.println("삽입 가능 범위가 아닙니다.");
			return;
		}
		// 새로운 노드 생성 후, 데이터 넣어주기
		Node newNode = new Node();
		newNode.data = data;

		size++;
		// 헤드 노드에서 출발
		Node curr = head;
		// 삽입 위치 한칸 전의 노드 찾기
		for (int k = 0; k < i; k++) {
			curr = curr.link;
		}
		newNode.link = curr.link;
		curr.link = newNode;
	}

	void removeData(int i) {
		if (!(0 <= i && i < size)) {
			System.out.println("삭제 가능 범위가 아닙니다.");
			return;
		}
		size--;
		Node curr = head;
		for (int k = 0; k < i; k++) {
			curr = curr.link;
		}
		curr.link = curr.link.link;

	}

	void printAll() {
		Node curr = head.link;
		while (curr != null) {
			System.out.print(curr.data + "-->");
			curr = curr.link;
		}
		System.out.println();
	}
}

public class SinglyLinkedListMyOwn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
