package kr.pe.gbpark.util.service;

import static org.assertj.core.api.Assertions.*;

import kr.pe.gbpark.util.dto.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
class MailServiceTest {

	@Autowired
	MailService mailService;

	@Test
	void sendMailTest() {
		MailDto mailDto = new MailDto();
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();

		mailDto.setTitle("mail test. It isn't supposed to display <div> tag");
		mailDto.setMessage("<div>it's mail test - " + localDate + " # " + localTime + "</div>");
		mailDto.setAdder("gbpark0524@gmail.com");

		mailService.sendMail(mailDto);
	}
	
	@Test
	void codeGenTest() {
		for (int i = 0; i < 100; i++) {
			String code = generateCode(3);
			if(code.length() < 3 || code.charAt(0) == '0')
			System.out.println("code = " + code);
		}
	}

	private String generateCode(double digit) {
		SecureRandom random = new SecureRandom ();
		StringBuilder code = new StringBuilder(String.valueOf(random.nextInt((int) Math.pow(10, digit))));
		int diff = (int)digit - code.length();
		for (int i = 0; i < diff; i++) {
			code.insert(0, "0");
		}
		return String.valueOf(code);
	}

}