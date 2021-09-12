package kr.pe.gbpark.algorithm.weakly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ReportUser {

	public int[] solution(String[] id_list, String[] report, int k) {
		int length = id_list.length;
		int[] answer = new int[length];
		int[] reportCounts = new int[length];
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, Integer> idIndex = new HashMap<>();
		Set<String> logSet = new HashSet<>(Arrays.asList(report));

		for (int i = 0; i < length; i++) {
			idIndex.put(id_list[i], i);
		}

		for (String log : logSet) {
			String[] split = log.split(" ");
			reportCounts[idIndex.get(split[1])] += 1;
		}

		for (int i = 0; i < length; i++) {
			if(reportCounts[i] >= k) map.put(id_list[i], i);
		}

		for (String log : logSet) {
			String[] split = log.split(" ");
			if(map.containsKey(split[1])) {
				answer[idIndex.get(split[0])] += 1;
			}
		}

		System.out.println("map = " + map);
		System.out.println("logSet = " + logSet);
		System.out.println("reportCounts = " + Arrays.toString(reportCounts));


		return answer;
	}
}
