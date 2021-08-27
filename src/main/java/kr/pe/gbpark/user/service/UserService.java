package kr.pe.gbpark.user.service;

import kr.pe.gbpark.user.entity.User;
import kr.pe.gbpark.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void sendValidMail(String email) {

		// TODO 공통 메일 전송 util
		// util.sendMail(email, str);
	}

	public void UserJoin(String email, String name, String pw) {
		User user = new User(email, name, pw);
		userRepository.save(user);
	}
}
