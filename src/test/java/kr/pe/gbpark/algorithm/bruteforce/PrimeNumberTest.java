package kr.pe.gbpark.algorithm.bruteforce;

import kr.pe.gbpark.algorithm.weakly.Prime;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeNumberTest {
	Prime pn = new Prime();

	@Test
	void solution() {
		List<Object> qList = new ArrayList<>();
		List<Object> q2List = new ArrayList<>();
		List<Object> aList = new ArrayList<>();

		qList.add(437674);
		qList.add(110011);

		q2List.add(3);
		q2List.add(10);

		aList.add(3);
		aList.add(2);

		for (int i = 0; i < qList.size(); i++) {
			assertThat(pn.solution((int)qList.get(i), (int)q2List.get(i))).isEqualTo(aList.get(i));
		}
	}

	@Test
	void checkPrime() {
//		String num = "425";
//		pn.doPermutation(num, 0);
//		System.out.println("pn = " + pn.set.toString());
	}
}