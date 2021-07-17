package kr.pe.gbpark.algorithm.dfsbfs;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TargetNumberTest {

	TargetNumber tn = new TargetNumber();

	@Test
	void solution() {
		List<Object> qList1 = new ArrayList<>();
		List<Object> qList2 = new ArrayList<>();
		List<Object> aList = new ArrayList<>();

		qList1.add(new int[] {1,1,1,1,1});
		qList1.add(new int[] {1,2,2});

		qList2.add(3);
		qList2.add(1);

		aList.add(5);
		aList.add(2);

		int size = qList1.size();
		for (int i = 0; i < size; i++) {
			assertThat(tn.solution((int[]) qList1.get(i),(int)qList2.get(i))).isEqualTo(aList.get(i));
		}
	}
}