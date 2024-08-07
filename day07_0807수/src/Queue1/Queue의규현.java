package Queue1;

import java.util.ArrayList;
import java.util.List;

public class Queue의규현 {

	List<Integer> list = new ArrayList<>();
	final int Max_listSize = 100;
	int front = -1;
	int rear = -1;
	int listSize = rear - front;

	void enQueue(int i) {
		list.add(i);
		rear++;
	}

	void deQueue() {
		list.remove(++front);
	}

	boolean isEmpty() {
		return listSize == 0;
	}

	boolean isFull() {
		return listSize == Max_listSize;
	}

}