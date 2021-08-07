package kr.pe.gbpark.algorithm.weakly;

import java.util.*;

public class BriansWorry {
	public String solution(String sentence) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		final String INVALID = "invalid";
		int length = sentence.length();
		StringBuilder sb = new StringBuilder();
		String answer;

		// 각 소문자 좌표를 list에 저장
		for (int i = 0; i < length; i++) {
			int curr = sentence.charAt(i);
			if (curr > 96 && curr < 123) {
				List<Integer> list = map.containsKey(curr) ? map.get(curr) : new ArrayList<>();
				list.add(i);
				map.put(curr, list);
			} else if (curr < 65 || curr > 90) return INVALID;
		}

		// 각 소문자 list를 index 순으로 정렬
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.get(0)));
		for (List<Integer> integerList : map.values()) {
			pq.offer(integerList);
		}

		int index = 0;
		while(!pq.isEmpty()) {
			List<Integer> poll = pq.poll();
			int size = poll.size();
			int start = poll.get(0);
			if(start < index) return INVALID;

			// 좌표 갯수에 따라 규칙 검색
			if(size == 1) { // 1번규칙 AaA
				if(start == index || start == length - 1) return INVALID;	// aDWED 소문자 하나가 단어 끝에 존재

				if (start - 1 > index) sb.append(sentence.substring(index, start-1)).append(" "); // A AaAA
				sb.append(sentence.charAt(start-1)).append(sentence.charAt(start+1)).append(" ");
				index = start + 2;
			} else if(size == 2) { // J qOq A 되도록 2번룰 적용
				int last = poll.get(1);
				if(last - start < 2) return INVALID; // aa
				if(start > index) sb.append(sentence.substring(index, start)).append(" "); // AB aAbAbAa

				if(!pq.isEmpty() && pq.peek().get(0) < last) { // 1	번 2번 모두 적용인경우
					List<Integer> next = pq.poll();
					int nextSize = next.size();
					for (int i = 0; i < nextSize; i++) {
						if(next.get(i) - start != 2 * (i + 1)) return INVALID;
						sb.append(sentence.charAt(start + 1 + i * 2));
					}
					if(last -  next.get(nextSize-1) != 2) return INVALID;
					sb.append(sentence.charAt(last - 1));
				}  else { // aSDSDa 순수 2번 룰
					sb.append(sentence.substring(start + 1, last));
				}

				sb.append(" ");
				index = last +1;
			} else { // 1번규칙 AsBsAsAsA
				if(index == start) return INVALID;	// aDaWaE 소문자로 단어 시작
				for (int i = 1; i < size; i++) {
					if(poll.get(i) - start != 2 * i) return INVALID;
				}

				int last = poll.get(size-1);
				if (start - 1 > index) sb.append(sentence.substring(index, start-1)).append(" "); // A AaAaA
				sb.append(sentence.substring(start - 1,last + 2).replace(String.valueOf(sentence.charAt(start)), "")).append(" ");
				index = last + 2;
			}
		}

		if(index < length) answer = sb.append(sentence.substring(index, length)).toString();
		else answer = sb.toString().substring(0, sb.length()-1);
		return answer;
	}
}
