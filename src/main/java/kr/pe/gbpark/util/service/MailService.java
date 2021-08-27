package kr.pe.gbpark.util.service;

import kr.pe.gbpark.util.dto.MailDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class MailService {

	private final JavaMailSender mailSender;

	public MailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(MailDto mailDto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailDto.getAdder());
		message.setSubject(mailDto.getTitle());
		message.setText(mailDto.getMessage());

		mailSender.send(message);
	}

	private String generateCode(double digit) {
		SecureRandom random = new SecureRandom ();
		return String.valueOf(random.nextInt((int) Math.pow(10, digit)));
	}
}
