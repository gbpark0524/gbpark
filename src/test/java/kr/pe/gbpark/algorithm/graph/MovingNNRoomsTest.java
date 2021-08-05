package kr.pe.gbpark.algorithm.graph;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MovingNNRoomsTest {
	MovingNNRooms movingNNRooms = new MovingNNRooms();

	@Test
	void solution() {
		List<Object> land = new ArrayList<>();
		List<Object> height = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		land.add(new int[][] {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}});
		land.add(new int[][] {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}});

		height.add(3);
		height.add(1);

		answers.add(15);
		answers.add(18);

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(movingNNRooms.solution((int[][]) land.get(i),(int) height.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}