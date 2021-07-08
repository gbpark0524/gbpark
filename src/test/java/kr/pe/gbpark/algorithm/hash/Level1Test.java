package kr.pe.gbpark.algorithm.hash;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Level1Test {

	Participant participant = new Participant();

	@Test
	void runnerSolution() {
		List<String[]> parList = new ArrayList<>();
		List<String[]> comList = new ArrayList<>();
		List<String> answer = new ArrayList<>();

		parList.add(new String[] {"leo", "kiki", "eden", "eden"});
		comList.add(new String[] {"kiki", "eden", "eden"});
		answer.add("leo");

		parList.add(new String[] {"marina", "josipa", "nikola", "vinko", "filipa", "vinko"});
		comList.add(new String[] {"marina", "josipa", "nikola", "filipa", "vinko"});
		answer.add("vinko");

		for (int i = 0; i < 2; i++) {
			assertEquals(answer.get(i), participant.runnerSolution(parList.get(i), comList.get(i)));
		}
	}

}