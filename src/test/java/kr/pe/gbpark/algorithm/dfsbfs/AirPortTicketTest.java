package kr.pe.gbpark.algorithm.dfsbfs;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.*;

class AirPortTicketTest {
	AirPortTicket at = new AirPortTicket();

	@Test
	void solution() {
		List<Object> tickets = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

//		tickets.add(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
//		tickets.add(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
//		tickets.add(new String[][] {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}});
//		tickets.add(new String[][] {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}});
		tickets.add(new String[][] {{"ICN","A"},{"A","B"},{"A","C"},{"C","A"},{"B","D"}});

//		answers.add(new String[] {"ICN", "JFK", "HND", "IAD"});
//		answers.add(new String[] {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"});
//		answers.add(new String[] {"ICN", "SFO", "ICN", "SFO", "QRE"});
//		answers.add(new String[] {"ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"});
		answers.add(new String[] {"ICN", "A", "C", "A", "B", "D"});

		int size = tickets.size();
		for (int i = 0; i < size; i++) {
			assertThat(at.solution((String[][]) tickets.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}