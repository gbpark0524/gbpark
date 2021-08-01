package kr.pe.gbpark.web.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
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
