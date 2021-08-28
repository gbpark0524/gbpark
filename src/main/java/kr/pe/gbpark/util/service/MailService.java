package kr.pe.gbpark.util.service;

import kr.pe.gbpark.util.dto.MailDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class MailService {

	// 공통 메일 전송
	public static void sendMail(MailDto mailDto) {
		JavaMailSender mailSender = new JavaMailSenderImpl();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailDto.getAdder());
		message.setSubject(mailDto.getTitle());
		message.setText(mailDto.getMessage());

		mailSender.send(message);
	}

	public static String generateCode(double digit) {
		SecureRandom random = new SecureRandom ();
		StringBuilder code = new StringBuilder(String.valueOf(random.nextInt((int) Math.pow(10, digit))));
		int diff = (int)digit - code.length();
		for (int i = 0; i < diff; i++) {
			code.insert(0, "0");
		}
		return String.valueOf(code);
	}
}
