package kr.pe.gbpark.algorithm.weakly;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FriendsSichuanTest {
	FriendsSichuan friendsSichuan = new FriendsSichuan();

	@Test
	void solution() {
		List<Object> m = new ArrayList<>();
		List<Object> n = new ArrayList<>();
		List<Object> board = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		m.add(3);
		m.add(2);
		m.add(4);
		m.add(2);
		m.add(5);

		n.add(3);
		n.add(4);
		n.add(4);
		n.add(2);
		n.add(5);

		board.add(new String[] {"DBA", "C*A", "CDB"});
		board.add(new String[] {"NRYN", "ARYA"});
		board.add(new String[] {".ZI.", "M.**", "MZU.", ".IU."});
		board.add(new String[] {"AB", "BA"});
		board.add(new String[] {"FGHEI", "BAB..", "D.C*.", "CA..I", "DFHGE"});

		answers.add("ABCD");
		answers.add("RYAN");
		answers.add("MUZI");
		answers.add("IMPOSSIBLE");
		answers.add("ABCDFHGIE");

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(friendsSichuan.solution((int) m.get(i), (int) n.get(i),(String[]) board.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}