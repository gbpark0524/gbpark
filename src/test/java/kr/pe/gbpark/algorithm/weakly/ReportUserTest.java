package kr.pe.gbpark.algorithm.weakly;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReportUserTest {
	ReportUser n = new ReportUser();

	@Test
	public void test() {
		List<Object> id_list = new ArrayList<>();
		List<Object> report = new ArrayList<>();
		List<Object> k = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		id_list.add(new String[] {"muzi", "frodo", "apeach", "neo"});
		id_list.add(new String[] {"con", "ryan"});

		report.add(new String[] {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"});
		report.add(new String[] {"ryan con", "ryan con", "ryan con", "ryan con"});

		k.add((Integer) 2);
		k.add((Integer) 3);

		answers.add(new int[] {2, 1, 1, 0});
		answers.add(new int[] {0, 0});

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(n.solution(((String[])id_list.get(i)),((String[]) report.get(i)) ,(int) k.get(i)))
					.isEqualTo(answers.get(i));
		}
	}

}