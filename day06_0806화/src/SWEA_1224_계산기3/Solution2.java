package SWEA_1224_계산기3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int trash = sc.nextInt();

			String infix = sc.next();

			String postFix = postFix(infix);
			int result = evalPostFix(postFix);
			System.out.println("#" + i + " " + result);
		}
	}

	static Map<Character, Integer> map = new HashMap<>();

	static {
		map.put('(', 0);
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
	}

	static String postFix(String infix) {

		Stack<Character> stack = new Stack<>();
		String postFix = "";
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if ('0' <= c && c <= '9') {
				postFix += c;
			} else if (c == '(') { // 여는 괄호는 무조건 푸쉬
				stack.push(c);
			} else if (c == ')') { // 닫는 괄호면, 여는 괄호가 나올 때 까지 pop을 하고 출력, 여는 괄호를 만나면 pop하고 출력은 X
				char popItem = stack.pop();
				while (popItem != '(') {
					postFix += popItem;
					popItem = stack.pop();
				}
			} else {
				// 괄호가 아닌 연산자
				// 토큰 연산자의 우선순위가 top에 있는 연산자의 우선순위보다 높을때까지
				while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {
					char popItem = stack.pop();
					postFix += popItem;
				}
				stack.push(c);
			}
		}

		return postFix;
	}

	static int evalPostFix(String postFix) {

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < postFix.length(); i++) {
			char c = postFix.charAt(i);
			if ('0' <= c && c <= '9') { // 숫자일때는 int 스택에 넣고
				stack.push(c - '0'); // char --> int로 변환은 아스키코드 값을 빼주면 된다.
			} else { // 연산자 일때는 필요한 갯수만큼의 숫자를 스택에서 pop 한 후에 연산 실행
				int num1 = stack.pop();
				int num2 = stack.pop();
				int result = 0;
				if (c == '+') {
					result = num2 + num1;
				} else if (c == '-') {
					result = num2 - num1;
				} else if (c == '*') {
					result = num2 * num1;
				} else {
					result = num2 / num1;
				}
				stack.push(result); // 계산 완료된 값을 바로 빼낼 수 없으므로
									// 스택에 넣어 놓은 다음에
			}
		} // pop으로 빼내와서 최종 리턴 해준다.
		return stack.pop();
	}

}
