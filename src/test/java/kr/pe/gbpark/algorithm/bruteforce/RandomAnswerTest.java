package kr.pe.gbpark.algorithm.bruteforce;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class RandomAnswerTest {
	RandomAnswer ra = new RandomAnswer();

	@Test
	void solution() {
		List<Object> qList = new ArrayList<>();
		List<Object> aList = new ArrayList<>();

		qList.add(new int[] {1,2,3,4,5});
		qList.add(new int[] {1,3,2,4,2});

		aList.add(new int[] {1});
		aList.add(new int[] {1,2,3});

		for (int i = 0; i < qList.size(); i++) {
			assertThat(ra.solution((int[]) qList.get(i))).isEqualTo(aList.get(i));
		}
	}
}