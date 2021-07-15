package kr.pe.gbpark.algorithm.bruteforce;

import java.util.HashSet;
import java.util.Set;

public class Carpet {
	public int[] solution(int brown, int yellow) {
		int max = (int)Math.sqrt(yellow);
		int[] answer = {};

		for (int i = 1; i <= max ; i++) {
			if(yellow % i == 0 && isRectangle(i, yellow/i, brown)) {
				answer = new int[] {yellow / i + 2, i + 2};
				break;
			}
		}

		return answer;
	}

	boolean isRectangle(int column, int row, int brown) {
		return column * 2 + row * 2 + 4 == brown;
	}
}
