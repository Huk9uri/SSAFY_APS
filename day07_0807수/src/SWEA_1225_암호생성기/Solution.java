package SWEA_1225_암호생성기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

// 리스트 만들어서 queue 메소드 구현하고 다시 하기.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			List<Integer> secret = new ArrayList<>();
			int trash = sc.nextInt();
			int cnt = 1;
			for (int j = 0; j < 8; j++) {
				enQueue(secret, sc.nextInt());
				System.out.println(size());
			}
			System.out.println(Arrays.toString(secret));
			int newNum = deQueue(secret) - cnt;
			cnt++;
			System.out.println(newNum);
			while (newNum > 0) {
				enQueue(secret, newNum);
				newNum = deQueue(secret) - cnt;
				cnt++;
				System.out.println(cnt);
				System.out.println(Arrays.toString(secret));
			}
		}
	}
}