package kr.pe.gbpark.algorithm.weakly;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GivingGradesTest {
	GivingGrades gg = new GivingGrades();

	@Test
	void solution() {
		List<Object> score = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		score.add(new int[][] {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}});
		score.add(new int[][] {{50,90},{50,87}});
		score.add(new int[][] {{70,49,90},{68,50,38},{73,31,100}});

		answers.add("FBABD");
		answers.add("DA");
		answers.add("CFD");

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(gg.solution((int[][]) score.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}