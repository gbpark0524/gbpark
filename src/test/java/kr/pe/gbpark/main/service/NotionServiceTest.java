package kr.pe.gbpark.main.service;

import static org.assertj.core.api.Assertions.*;

import kr.pe.gbpark.main.dto.NotionDto;
import org.junit.jupiter.api.AfterAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.List;

@SpringBootTest
@Transactional
class NotionServiceTest {
	@Autowired
	NotionService notionService;

	@Test
	void getNewNotionList() {
		List<NotionDto> newNotionList = notionService.getNewNotionList();
		String url = String.valueOf(newNotionList.get(0).getUrl());
		String parent = String.valueOf(newNotionList.get(0).getParent().getPage_id());
		String plain = String.valueOf(newNotionList.get(0).getProperties().getPropertiesTitle().getTitle().get(0).getPlain_text());
		assertThat(url).isEqualTo("https://www.notion.so/Enum-results-log-17e06422cc68464498582e7de09968ff");
		assertThat(parent).isEqualTo("c1a4bc22-f33e-416a-850d-9e1fe06e4e53");
		assertThat(parent).isEqualTo("Enum results - log");
		assertThat(newNotionList).isNotEmpty();
	}
}