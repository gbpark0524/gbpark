package kr.pe.gbpark.algorithm.heap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static java.lang.Integer.parseInt;

public class DoublePriorityQueue {

//	테스트 1 〉	통과 (0.47ms, 53.2MB)
//	테스트 2 〉	통과 (0.45ms, 52.4MB)
//	테스트 3 〉	통과 (0.53ms, 51.9MB)
//	테스트 4 〉	통과 (0.11ms, 51.9MB)
//	테스트 5 〉	통과 (0.53ms, 53.4MB)
//	테스트 6 〉	통과 (0.44ms, 53MB)
	// avg - ( 0.4216...)
	public int[] solution(String[] operations) {
		int[] answer = {};
		LinkedList<Integer> list = new LinkedList<>();

		for (String str : operations) {
			String firstOper = str.substring(0, 1);
			int secondOper = parseInt(str.substring(2));

			if(firstOper.equals("I")) {
				list.add(secondOper);
				Collections.sort(list);
			}else {
				switch (secondOper) {
					case 1:
						list.pollLast();
						break;
					case -1:
						list.poll();
				}
			}
		}

		answer = list.isEmpty() ? new int[]{0, 0} : new int[]{list.peekLast(), list.peek()};

		return answer;
	}

//	테스트 1 〉	통과 (0.53ms, 53.1MB)
//	테스트 2 〉	통과 (0.47ms, 52.9MB)
//	테스트 3 〉	통과 (0.54ms, 52.6MB)
//	테스트 4 〉	통과 (0.09ms, 52.6MB)
//	테스트 5 〉	통과 (0.58ms, 54.1MB)
//	테스트 6 〉	통과 (0.34ms, 52.9MB)
//	avg = 0.425.....
	public int[] solution2(String[] operations) {
		int[] answer = {};
		PriorityQueue<Integer> minPq = new PriorityQueue<>();
		PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

		for (String str : operations) {
			String firstOper = str.substring(0, 1);
			int secondOper = parseInt(str.substring(2));

			if(firstOper.equals("I")) {
				minPq.offer(secondOper);
				maxPq.offer(secondOper);
			}else {
				switch (secondOper) {
					case 1:
						maxPq.poll();
						break;
					case -1:
						minPq.poll();
				}
			}
		}

		if (minPq.isEmpty() || maxPq.isEmpty()) {
			answer = new int[] {0,0};
		} else {
			int min = minPq.poll();
			int max = maxPq.poll();

			if(min > max) {
				answer = new int[] {0,0};
			} else {
				answer = new int[] {max,min};
			}
		}

		return answer;
	}
}
