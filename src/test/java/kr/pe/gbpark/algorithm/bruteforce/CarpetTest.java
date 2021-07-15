package kr.pe.gbpark.algorithm.bruteforce;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CarpetTest {
	Carpet carpet = new Carpet();

	@Test
	void solution() {
		List<Object> qList = new ArrayList<>();
		List<Object> qList2 = new ArrayList<>();
		List<Object> aList = new ArrayList<>();

		qList.add(10);
		qList.add(8);
		qList.add(24);

		qList2.add(2);
		qList2.add(1);
		qList2.add(24);

		aList.add(new int[] {4,3});
		aList.add(new int[] {3,3});
		aList.add(new int[] {8,6});

		for (int i = 0; i < qList.size(); i++) {
			assertThat(carpet.solution((int)qList.get(i), (int)qList2.get(i))).isEqualTo(aList.get(i));
		}
	}
}