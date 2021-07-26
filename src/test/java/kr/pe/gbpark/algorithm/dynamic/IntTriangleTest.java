package kr.pe.gbpark.algorithm.dynamic;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class IntTriangleTest {
	IntTriangle2 it = new IntTriangle2();

	@Test
	void solution() {
		List<Object> triangle = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		triangle.add(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});

		answers.add(30);

		int size = triangle.size();
		for (int i = 0; i < size; i++) {
			assertThat(it.solution((int[][]) triangle.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}