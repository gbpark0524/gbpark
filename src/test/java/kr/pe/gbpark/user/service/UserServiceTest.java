package kr.pe.gbpark.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

	@Autowired
	UserService userService;

	@Test
	void sendCodeJoinMail() {
		userService.sendCodeJoinMail("gbpark0524@gmail.com");
	}

	@Test
	void verifyMailTest() {
		String s = userService.verifyMail("gbpark0524@gmail.com", "997613");
		System.out.println("s = " + s);
	}
}