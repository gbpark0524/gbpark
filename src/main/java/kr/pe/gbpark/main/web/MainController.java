package kr.pe.gbpark.main.web;

import kr.pe.gbpark.main.dto.NotionDto;
import kr.pe.gbpark.main.dto.ToMeDto;
import kr.pe.gbpark.main.service.NotionService;
import kr.pe.gbpark.main.service.ToMeService;
import kr.pe.gbpark.util.enums.results.LogicResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
public class MainController {
	final Logger logger = LoggerFactory.getLogger(MainController.class);
	final ToMeService toMeService;
	final NotionService notionService;

	public MainController(ToMeService toMeService, NotionService notionService) {
		this.toMeService = toMeService;
		this.notionService = notionService;
	}

	@RequestMapping("/")
	public String rootMain(Model model) {
		return "main/main";
	}

	@PostMapping("/tome")
	@ResponseBody
	public String saveToMe(@RequestParam String title, @RequestParam String message) {
		LogicResult logicResult = toMeService.ToMeSave(title, message);
		return logicResult.getMessage();
	}

	@GetMapping("/notion")
	@ResponseBody
	public String getNotion(@RequestParam(required = false) int pageSize, @RequestParam(required = false) String next) {
		return notionService.getNewNotionList(pageSize, next);
	}
}
