package BOJ_1158_요세푸스;

import java.util.Scanner;

public class BOJ_1158 {
	static int front;
	static int rear;
	static int size;

	static void enQueue(int[] queue, int num) {
		if(isEmpty(queue)) {
			return;
		}
		queue[++rear] = num;
		size++;
	}

	static int deQueue(int[] queue) {
		if(isEmpty(queue)) {
			return -1;
		}
		int popNum = queue[++front];
		size--;
		return popNum;
	}
	
	static boolean isEmpty(int[] queue) {
		return size == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] queue = new int[n];
		
		while(n>0) {
			
		}
	}

}
