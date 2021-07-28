package kr.pe.gbpark.algorithm.graph;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class FurthestNodeTest {
	FurthestNode fn = new FurthestNode();

	@Test
	void solution() {
		List<Object> n = new ArrayList<>();
		List<Object> edge = new ArrayList<>();
		List<Object> answers = new ArrayList<>();


		n.add(6);
		n.add(8);

		edge.add(new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
		edge.add(new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2},{4,7},{5,8}});

		answers.add(3);
		answers.add(2);

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(fn.solution((int) n.get(i), (int[][]) edge.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}