package kr.pe.gbpark.web.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String rootMain() {
		return "main/main";
	}

	@RequestMapping("/main")
	public String main() {
		return "main/main";
	}
}
