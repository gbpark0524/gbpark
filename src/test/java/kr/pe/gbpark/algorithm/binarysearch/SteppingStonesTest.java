package kr.pe.gbpark.algorithm.binarysearch;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SteppingStonesTest {
	SteppingStones ss = new SteppingStones();

	@Test
	void solution() {
		List<Object> distance = new ArrayList<>();
		List<Object> rocks = new ArrayList<>();
		List<Object> n = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		distance.add(25);

		rocks.add(new int[] {2, 14, 11, 21, 17});

		n.add(2);

		answers.add(4);

		int size = n.size();
		for (int i = 0; i < size; i++) {
			assertThat(ss.solution((int) distance.get(i), (int[]) rocks.get(i), (int) n.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}