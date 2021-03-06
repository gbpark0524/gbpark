package kr.pe.gbpark.project.web;

import kr.pe.gbpark.main.service.ToMeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class ProjectController {
	final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@GetMapping("/project")
	public String goProject() {
		return "project/project";
	}
}
