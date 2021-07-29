package kr.pe.gbpark.algorithm.graph;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class RankBoxerTest {
	RankBoxer rb = new RankBoxer();

	@Test
	void solution() {
		List<Object> n = new ArrayList<>();
		List<Object> result = new ArrayList<>();
		List<Object> answers = new ArrayList<>();


		n.add(5);

		result.add(new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});

		answers.add(2);

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(rb.solution((int) n.get(i), (int[][]) result.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}