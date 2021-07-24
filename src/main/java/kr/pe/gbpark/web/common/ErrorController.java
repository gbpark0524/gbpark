package kr.pe.gbpark.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping("/error")
	public String error() {
		return "common/error";
	}
}
