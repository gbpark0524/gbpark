package kr.pe.gbpark.algorithm.dynamic;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class WayToSchoolTest {
	WayToSchool wts = new WayToSchool();
	WayToSchool2 wts2 = new WayToSchool2();

	@Test
	void solution() {
		// 4	3	[[2, 2]]
		// 7, 4, [[2, 1], [2, 2], [2, 3], [4, 2], [4, 3], [4, 4], [6, 2], [6, 3]]), 0
		List<Object> m = new ArrayList<>();
		List<Object> n = new ArrayList<>();
		List<Object> puddles = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		m.add(4);
		m.add(7);

		n.add(3);
		n.add(4);

		puddles.add(new int[][] {{2,2}});
		puddles.add(new int[][] {{2, 1}, {2, 2}, {2, 3}, {4, 2}, {4, 3}, {4, 4}, {6, 2}, {6, 3}});

		answers.add(4);
		answers.add(0);

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(wts2.solution((int) m.get(i),(int) n.get(i), (int[][]) puddles.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}