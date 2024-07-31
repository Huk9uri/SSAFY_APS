package SWEA_1989_초심자의외문검사;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int i = 1; i <= testCase; i++) {
			String s = sc.next();
			char[] word = new char[s.length()];
			char[] reverseWord = new char[word.length];
			for (int j = 0; j < word.length; j++) {
				word[j] = s.charAt(j);
			}
			for (int j = 0; j < reverseWord.length; j++) {
				reverseWord[j] = word[reverseWord.length - 1 - j];
			}

			// System.out.println(Arrays.toString(word));
			// System.out.println(Arrays.toString(reverseWord));
			int cnt = 0;

			for (int j = 0; j < reverseWord.length; j++) {
				if (word[j] != reverseWord[j]) {
					cnt++;
					if (cnt == reverseWord.length) {
						System.out.println("#" + i + " " + 0);
					}
				} else { // 같다면
					cnt++;
					if (cnt == reverseWord.length) {
						System.out.println("#" + i + " " + 1);
					}
				}
			}

		}
	}
}