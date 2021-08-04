package kr.pe.gbpark.algorithm.dfsbfs;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class HighPitchedTest {
	HighPitched highPitched = new HighPitched();

	@Test
	void solution() {
		List<Object> n = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		n.add(15);
		n.add(24);
		n.add(41);
		n.add(2147483647);

		answers.add(1);
		answers.add(0);
		answers.add(2);
		answers.add(1735);

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(highPitched.solution((int) n.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}