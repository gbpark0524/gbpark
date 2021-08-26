package kr.pe.gbpark.util.service;

import static org.assertj.core.api.Assertions.*;

import kr.pe.gbpark.util.dto.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

@SpringBootTest
class MailServiceTest {

	@Autowired
	MailService mailService;

	@Test
	void sendMail() {
		MailDto mailDto = new MailDto();
		mailDto.setAdder("gbpark0524@gmail.com");
		mailDto.setTitle("testmail");
		mailDto.setMessage("it's message");
		mailService.sendMail(mailDto);
	}
}