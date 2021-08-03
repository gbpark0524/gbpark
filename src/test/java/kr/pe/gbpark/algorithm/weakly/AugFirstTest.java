package kr.pe.gbpark.algorithm.weakly;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class AugFirstTest {
	AugFirst augFirst = new AugFirst();

	@Test
	void solution() {
		List<Object> price = new ArrayList<>();
		List<Object> money = new ArrayList<>();
		List<Object> count = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		price.add(3);

		money.add(20);

		count.add(4);

		answers.add((long)10);

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(augFirst.solution((int) price.get(i), (int) money.get(i),(int) count.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}