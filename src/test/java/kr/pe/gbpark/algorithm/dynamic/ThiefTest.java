package kr.pe.gbpark.algorithm.dynamic;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class ThiefTest {
	Thief thief = new Thief();

	@Test
	void solution() {
		List<Object> money = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		money.add(new int[] {1,2,3,1});

		answers.add(4);

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(thief.solution((int[]) money.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}