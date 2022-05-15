package kr.pe.gbpark.project.service;

import kr.pe.gbpark.project.entity.Project;
import kr.pe.gbpark.project.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {
	final Logger logger = LoggerFactory.getLogger(ProjectService.class);
	final ProjectRepository projectRepository;
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public boolean saveProject(Project project) {
		if (project.isBlank()) return false;
		try {
			projectRepository.save(project);
		} catch (Exception e) {
			logger.error("save Project fail :" + e.getMessage());
			return false;
		}
		return true;
	}

}
