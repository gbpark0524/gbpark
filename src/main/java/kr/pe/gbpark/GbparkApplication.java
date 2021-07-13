package kr.pe.gbpark;

import kr.pe.gbpark.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
public class GbparkApplication {

	final
	HttpServletRequest request;

	public GbparkApplication(HttpServletRequest request) {
		this.request = request;
	}

	public static void main(String[] args) {
		SpringApplication.run(GbparkApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorProvider() {
		return () -> Optional.of(UserUtil.getIP(request));
	}
}
