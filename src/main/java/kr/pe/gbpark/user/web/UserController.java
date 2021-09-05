package kr.pe.gbpark.user.web;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class UserController {
	final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/user/join")
	public String rootMain(Model model) {
		return "/user/join";
	}
}
