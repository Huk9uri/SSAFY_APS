package SWEA_1224_계산기3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {

			sc.nextInt(); // 테스트 케이스의 길이는 필요없음.
			String expression = sc.next();
			String postFix = infixToPostfix(expression);
			int result = evalPostfix(postFix);
			System.out.println("#"+ i + " " + result);
		}

	}

	static Map<Character, Integer> map = new HashMap<>();

	static { // 우선순위를 부여하기 위해
		map.put('(', 0);
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
	}

	static String infixToPostfix(String infix) {

		String postfix = "";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if (c >= '0' && c <= '9') { // 피연산자일때
				postfix += c;
			} else if (c == '(') { // 여는 괄호라면
				stack.push(c); // 스택에 넣고
			} else if (c == ')') { // 닫는 괄호라면
				char popItem = stack.pop(); 
				while (popItem != '(') { // 여는 괄호가 나올 때 까지 팝을 해준다.
					postfix += popItem;  // 여는 괄호가 아니라면 연산자이다.
					popItem = stack.pop();
				}
			} else {
				// 토큰 연산자의 우선순위가 top 연산자의 우선순위보다
				// 높을때까지
				while (!stack.isEmpty() && stack.peek() != '(' && map.get(c) <= map.get(stack.peek())) {
					char popItem = stack.pop();
					postfix += popItem;
				}
				stack.push(c);
			}
		}

		return postfix;
	}

	static int evalPostfix(String postfix) {

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < postfix.length(); i++) {

			char c = postfix.charAt(i);

			if (c >= '0' && c <= '9') {
				stack.push(c - '0');
			} else {
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
				stack.push(result);
			}
		}
		return stack.pop();
	}
}