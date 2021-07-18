package kr.pe.gbpark.algorithm.dfsbfs;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class NetworkTest {
	Network network = new Network();

	@Test
	void solution() {
		List<Object> qList1 = new ArrayList<>();
		List<Object> qList2 = new ArrayList<>();
		List<Object> aList = new ArrayList<>();

		qList1.add(3);
		qList1.add(3);

		qList2.add(new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
		qList2.add(new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});

		aList.add(2);
		aList.add(1);

		int size = qList1.size();
		for (int i = 0; i < size; i++) {
			assertThat(network.solution((int) qList1.get(i),(int[][])qList2.get(i))).isEqualTo(aList.get(i));
		}
	}
}