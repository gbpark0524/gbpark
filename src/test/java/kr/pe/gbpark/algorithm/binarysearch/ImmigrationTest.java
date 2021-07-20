package kr.pe.gbpark.algorithm.binarysearch;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ImmigrationTest {
	Immigration immigration = new Immigration();

	@Test
	void solution() {
		List<Object> n = new ArrayList<>();
		List<Object> times = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		n.add(6);
		n.add(2);

		times.add(new int[] {10,7});
		times.add(new int[] {1,2});

		answers.add((long)28);
		answers.add((long)2);

		int size = n.size();
		for (int i = 0; i < size; i++) {
			assertThat(immigration.solution((int) n.get(i), (int[]) times.get(i)))
					.isEqualTo(answers.get(i));
		}
	}

	@Test
	void maxPeople() {
		int a = 5;
		int b = 2;
		int result = a/b;
		assertThat(result).isEqualTo(2);
	}
}