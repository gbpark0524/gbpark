package kr.pe.gbpark.repository.main;
import kr.pe.gbpark.domain.main.ToMe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ToMeRepositoryTest {
	@Autowired
	ToMeRepository toMeRepository;

	@Test
	void saveToMeTest() {
		ToMe tm = new ToMe("test", "it's contents", "127.0.0.1");
		ToMe saved = toMeRepository.save(tm);

		assertThat(saved.getTitle()).isEqualTo(tm.getTitle());
	}
}