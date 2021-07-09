package kr.pe.gbpark.algorithm.hash;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class SpyDisguiseTest {
	SpyDisguise spy = new SpyDisguise();

	@Test
	void solution() {
		List<Object> qList = new ArrayList<>();
		List<Object> aList = new ArrayList<>();

		qList.add(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
		qList.add(new String[][] {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}});

		aList.add(5);
		aList.add(3);

		for (int i = 0; i < qList.size(); i++) {
			assertThat(spy.solution((String[][]) qList.get(i))).isEqualTo(aList.get(i));
		}
	}


}