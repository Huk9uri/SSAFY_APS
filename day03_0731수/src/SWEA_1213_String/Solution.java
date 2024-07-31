package SWEA_1213_String;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int u = 1; u <= 10; u++) {
			int testCase = sc.nextInt();
			String s = sc.next(); // ti
			String t = sc.next(); // asdastitsfdsditititasdasklgdstudjaskftiong

			char[] Word = new char[s.length()];
			char[] Sentence = new char[t.length()];
			int index = 0;
			for (int i = 0; i < Word.length; i++) {
				Word[i] = s.charAt(i);
			}
			for (int i = 0; i < Sentence.length; i++) {
				Sentence[i] = t.charAt(i);
			}

			for (int i = 0; i < Sentence.length; i++) {
				while (index <= Word.length) {
					
					if (Sentence[i] == Word[index]) {
						index++;
					}
				}
			}
			System.out.println(Arrays.toString(Word));
			System.out.println(Arrays.toString(Sentence));

		}

	}
}