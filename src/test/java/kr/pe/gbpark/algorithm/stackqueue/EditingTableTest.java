package kr.pe.gbpark.algorithm.stackqueue;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class EditingTableTest {
	EditingTable editingTable = new EditingTable();

	@Test
	void solution() {
		List<Object> n = new ArrayList<>();
		List<Object> k = new ArrayList<>();
		List<Object> cmd = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		n.add(8);
		n.add(8);

		k.add(2);
		k.add(2);

		cmd.add(new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
		cmd.add(new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"});


		answers.add("OOOOXOOO");
		answers.add("OOXOXOOO");

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(editingTable.solution((int) n.get(i), (int) k.get(i), (String[]) cmd.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}