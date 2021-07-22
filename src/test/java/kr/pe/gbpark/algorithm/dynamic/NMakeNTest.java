package kr.pe.gbpark.algorithm.dynamic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NMakeNTest {
	NMakeN makeN = new NMakeN();

	@Test
	void solution() {
		List<Object> N = new ArrayList<>();
		List<Object> number = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		N.add(5);
		N.add(2);

		number.add(12);
		number.add(11);

		answers.add(4);
		answers.add(3);

		int size = N.size();
		for (int i = 0; i < size; i++) {
			assertThat(makeN.solution((int) N.get(i), (int) number.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}