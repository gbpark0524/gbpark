package kr.pe.gbpark.web.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping("/")
	public String rootMain() {
		return "main/main";
	}

	@RequestMapping("/main")
	public String main() {
		return "main/main";
	}
}
