package kr.pe.gbpark.main.service;

import kr.pe.gbpark.main.dto.NotionDto;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class NotionServiceTest {
	@Autowired
	NotionService notionService;

	@Test
	void getNewNotionList() throws Exception {
		NotionDto notionDto = notionService.getNewNotionList(10);
		assertThat(notionDto.getObject()).isEqualTo("list");
		assertThat(notionDto.getResults().size()).isEqualTo(10);
	}
}