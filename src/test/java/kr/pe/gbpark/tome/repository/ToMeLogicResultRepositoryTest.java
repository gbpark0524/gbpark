package kr.pe.gbpark.tome.repository;

import static org.assertj.core.api.Assertions.*;

import kr.pe.gbpark.main.entity.ToMe;
import kr.pe.gbpark.main.repository.ToMeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.List;

@SpringBootTest
@Transactional
class ToMeLogicResultRepositoryTest {
	@Autowired
	ToMeRepository toMeRepository;

	@Test
	void toMeRepositoryTest() {
		ToMe tome = new ToMe("tomeTest", "It's test");
		ToMe save = toMeRepository.save(tome);

		List<ToMe> all = toMeRepository.findAll();

		assertThat(all.size()).isGreaterThan(0);
		ToMe gotTome = all.get(all.size() - 1);

		assertThat(tome).isEqualTo(gotTome);
	}
}