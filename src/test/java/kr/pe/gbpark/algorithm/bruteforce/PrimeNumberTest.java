package kr.pe.gbpark.algorithm.bruteforce;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class PrimeNumberTest {
	PrimeNumber pn = new PrimeNumber();

	@Test
	void solution() {
		List<Object> qList = new ArrayList<>();
		List<Object> aList = new ArrayList<>();

		qList.add("17");
		qList.add("011");
		qList.add("7843");

		aList.add(3);
		aList.add(2);
		aList.add(12);

		for (int i = 0; i < qList.size(); i++) {
			assertThat(pn.solution((String)qList.get(i))).isEqualTo(aList.get(i));
		}
	}

	@Test
	void checkPrime() {
		String num = "425";
		pn.doPermutation(num, 0);
		System.out.println("pn = " + pn.set.toString());
	}
}