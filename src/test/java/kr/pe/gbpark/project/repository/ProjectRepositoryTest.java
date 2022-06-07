package kr.pe.gbpark.project.repository;

import static org.assertj.core.api.Assertions.*;

import kr.pe.gbpark.project.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.List;

@SpringBootTest
@Transactional
class ProjectRepositoryTest {
	@Autowired
	ProjectRepository repository;

	@Test
	void projectTest() {

	}

}