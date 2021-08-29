package kr.pe.gbpark.util.service;

import kr.pe.gbpark.util.dto.MailDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.security.SecureRandom;

@Service
public class MailService{

	private JavaMailSender mailSender;

	public MailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	// 공통 메일 전송
	public void sendMail(MailDto mailDto) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"utf-8");
			helper.setText(mailDto.getMessage(), true);
			helper.setTo(mailDto.getAdder());
			helper.setSubject(mailDto.getTitle());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		mailSender.send(mimeMessage);
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
