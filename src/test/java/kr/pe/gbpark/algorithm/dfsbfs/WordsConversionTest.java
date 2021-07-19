package kr.pe.gbpark.algorithm.dfsbfs;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class WordsConversionTest {
	WordsConversion wc = new WordsConversion();

	@Test
	void solution() {
		List<Object> begin = new ArrayList<>();
		List<Object> target = new ArrayList<>();
		List<Object> words = new ArrayList<>();
		List<Object> answers = new ArrayList<>();

		begin.add("hit");
		begin.add("hit");

		target.add("cog");
		target.add("cog");

		words.add(new String[] {"hot", "dot", "dog", "lot", "log", "cog"});
		words.add(new String[] {"hot", "dot", "dog", "lot", "log"});

		answers.add(4);
		answers.add(0);

		int size = begin.size();
		for (int i = 0; i < size; i++) {
			assertThat(wc.solution((String) begin.get(i), (String) target.get(i), (String[]) words.get(i)))
					.isEqualTo(answers.get(i));
		}
	}

}