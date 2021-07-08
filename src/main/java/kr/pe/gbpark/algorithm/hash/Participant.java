package kr.pe.gbpark.algorithm.hash;

import java.util.Arrays;
import java.util.HashSet;

public class Participant {

	// 참여자중 1명의 비완주자 찾기
	public String runnerSolution(String[] participant, String[] completion) {
		String answer;
		HashSet<String> set = new HashSet<>();

		for (String p : participant) {
			while (!set.add(p)) {
				p = p + "1";
			}
		}

		for (String s : completion) {
			while(!set.remove(s)){
				s = s + "1";
			};
		}

		answer = set.stream().findFirst().orElse("");
		answer = answer.replaceAll("1", "");
		return answer;
	}
}
