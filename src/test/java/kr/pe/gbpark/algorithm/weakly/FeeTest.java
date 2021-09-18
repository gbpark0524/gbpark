package kr.pe.gbpark.algorithm.weakly;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FeeTest {
	Fee fee = new Fee();

	@Test
	void solution() {
		List<Object> fees = new ArrayList<>();
		List<Object> records = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		/*fees.add(new int[] {180, 5000, 10, 600});
		fees.add(new int[] {120, 0, 60, 591});*/
		fees.add(new int[] {1, 461, 1, 10});


//		records.add(new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
//		records.add(new String[] {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"});
		records.add(new String[] {"00:00 1234 IN"});


//		answers.add(new int[] {14600, 34400, 5000});
//		answers.add(new int[] {0, 591});
		answers.add(new int[] {14841});

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(fee.solution(((int[])fees.get(i)),((String[]) records.get(i))))
					.isEqualTo(answers.get(i));
		}
	}
}