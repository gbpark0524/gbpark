package kr.pe.gbpark.algorithm.heap;

import static org.assertj.core.api.Assertions.*;

import kr.pe.gbpark.algorithm.heap.ThanksgivingTraffic;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ThanksgivingTrafficTest {
	ThanksgivingTraffic thanksgivingTraffic = new ThanksgivingTraffic();

	@Test
	void solution() {
		List<Object> lines = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		lines.add(new String[] {
				"2016-09-15 01:00:04.001 2.0s",
				"2016-09-15 01:00:07.000 2s"
		});
		lines.add(new String[] {
				"2016-09-15 01:00:04.002 2.0s",
				"2016-09-15 01:00:07.000 2s"
		});
		lines.add(new String[] {
				"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"
		});

		answers.add(1);
		answers.add(2);
		answers.add(7);

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(thanksgivingTraffic.solution((String[]) lines.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}