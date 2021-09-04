package kr.pe.gbpark.user.service;

import kr.pe.gbpark.user.entity.Certification;
import kr.pe.gbpark.user.entity.User;
import kr.pe.gbpark.user.entity.WaitingMail;
import kr.pe.gbpark.user.repository.UserRepository;
import kr.pe.gbpark.user.repository.WaitingMailRepository;
import kr.pe.gbpark.util.dto.MailDto;
import kr.pe.gbpark.util.service.MailService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
	final UserRepository userRepository;
	final WaitingMailRepository waitingMailRepository;
	final MailService mailService;

	public UserService(UserRepository userRepository, WaitingMailRepository waitingMailRepository, MailService mailService) {
		this.userRepository = userRepository;
		this.waitingMailRepository = waitingMailRepository;
		this.mailService = mailService;
	}

	public String  UserJoin(String mail, String name, String pw) {
		User user = new User(mail, name, pw);
		String result = "";
		Optional<WaitingMail> wMail = waitingMailRepository.findByMail(mail);

		if(wMail.isPresent()) {
			WaitingMail waitingMail = wMail.get();
			if((waitingMail.getCertification().equals(Certification.VERIFY.name()))) {
				userRepository.save(user);
				result = "회원 가입에 성공했습니다.";
			} else {
				result = "인증받지 않은 메일입니다.";
			}
		} else {
				result = "인증받지 않은 메일입니다.";
		}
		return  result;
	}

	// 회원가입 메일 인증 코드 전송
	public void sendCodeJoinMail(String mail) {
		String code = MailService.generateCode(6);
		WaitingMail waitingMail;
		MailDto mailDto = new MailDto();
		Optional<WaitingMail> wMail = waitingMailRepository.findByMail(mail);

		if (wMail.isPresent()) {
			waitingMail = wMail.get();
			waitingMail.changeCode(code);
		} else {
			waitingMail = new WaitingMail(mail, code);
		}

		mailDto.setAdder(mail);
		mailDto.setTitle("gbPark 회원가입 인증 코드 입니다.");
		mailDto.setMessage("<body><div class=\"head\" style=\"text-align: center;margin: 0 auto;width: 25vw;\">안녕하세요! gbPark입니다.</div>" +
				"<div class=\"body\" style=\"border: 4px solid #455d73;width: 25vw;height: 100px;font-size: 25px;border-radius: 15px;margin: 0 auto;\">" +
				"<p style=\"width: 100%; text-align: center;\">" + code + "</p>" +
				"</div><div class=\"tail\" style=\"text-align: center;margin: 0 auto;width: 25vw;\">해당 코드를 입력하세요</div>");
		mailService.sendMail(mailDto);
		waitingMail = new WaitingMail(mail, code);
		waitingMailRepository.save(waitingMail);
	}

	// 메일 인증
	public String verifyMail(String mail, String code) {
		Optional<WaitingMail> wMail = waitingMailRepository.findByMail(mail);
		String result = "fail";
		if(!wMail.isPresent()) {
			result = "메일 인증 실패";
		} else {
			WaitingMail waitingMail = wMail.get();
			String rightCode = waitingMail.getCode();
			if(rightCode.equals(code)) {
				waitingMail.changeStatus(Certification.VERIFY);
				waitingMailRepository.save(waitingMail);
				result = "인증성공";
			} else {
				waitingMail.wrongTry();
				waitingMailRepository.save(waitingMail);
				result = "인증 실패하셨습니다. 시도 횟수 " + waitingMail.getTries();
			}
		}
		return result;
	}
}
