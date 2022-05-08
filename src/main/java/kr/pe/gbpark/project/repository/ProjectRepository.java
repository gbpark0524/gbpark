package kr.pe.gbpark.project.repository;

import kr.pe.gbpark.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
