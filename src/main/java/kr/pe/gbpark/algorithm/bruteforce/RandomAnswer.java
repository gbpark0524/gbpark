package kr.pe.gbpark.algorithm.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class RandomAnswer {
	public int[] solution(int[] answers) {
		int length = answers.length;
		int[] p1 = new int[] {1, 2, 3, 4, 5};
		int[] p2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
		int[] p3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;

		for (int i = 0; i < length; i++) {
			int ans = answers[i];
			a1 += ans == p1[i%p1.length] ? 1 : 0;
			a2 += ans == p2[i%p2.length] ? 1 : 0;
			a3 += ans == p3[i%p3.length] ? 1 : 0;
		}
		int max = Math.max(Math.max(a1, a2), a3);
		List<Integer> list = new ArrayList<>();

		if(max == a1) list.add(1);
		if(max == a2) list.add(2);
		if(max == a3) list.add(3);

		int[] returnArr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			returnArr[i] = list.get(i);
		}
		return returnArr;
	}
}
