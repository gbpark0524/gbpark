package kr.pe.gbpark.algorithm.graph;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;

class CountRoomsTest {
	CountRooms countRooms = new CountRooms();

	@Test
	void solution() {
		List<Object> arrows = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		arrows.add(new int[] {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0});

		answers.add(3);

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(countRooms.solution((int[]) arrows.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}