package kr.pe.gbpark.user.service;

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

	public UserService(UserRepository userRepository, WaitingMailRepository waitingMailRepository) {
		this.userRepository = userRepository;
		this.waitingMailRepository = waitingMailRepository;
	}

	public void sendValidMail(String email) {

		// TODO 공통 메일 전송 util
		// util.sendMail(email, str);
	}

	public void UserJoin(String email, String name, String pw) {
		User user = new User(email, name, pw);
		userRepository.save(user);
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
				"<div class=\"body\" style=\"border: 4px solid #455d73;width: 25vw;height: 100px;display: flex;justify-content: center;align-items: center;font-size: 25px;border-radius: 15px;margin: 10 auto;\">"
				+ code + "</div><div class=\"tail\" style=\"text-align: center;margin: 0 auto;width: 25vw;\">해당 코드를 입력하세요</div>");
		MailService.sendMail(mailDto);
		waitingMailRepository.save(waitingMail);
	}
}
