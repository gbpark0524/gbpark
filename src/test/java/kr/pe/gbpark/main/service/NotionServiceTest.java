package kr.pe.gbpark.main.service;

import kr.pe.gbpark.main.dto.NotionDto;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class NotionServiceTest {
	@Autowired
	NotionService notionService;

	@Test
	void getNewNotionList() throws Exception {
//		NotionDto notionDto = notionService.getNewNotionList(4, "52ab76b0-05d5-4af7-971b-243ec522a2dc");
//		assertThat(notionDto.getObject()).isEqualTo("list");
//		assertThat(notionDto.getResults().size()).isEqualTo(4);
//		System.out.println("notionDto = " + notionDto.toString());
	}
}