package kr.pe.gbpark;

import kr.pe.gbpark.util.service.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@EnableJpaAuditing
@SpringBootApplication
public class GbparkApplication extends SpringBootServletInitializer {

	@Autowired
	HttpServletRequest request;

	public static void main(String[] args) {
		SpringApplication.run(GbparkApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(GbparkApplication.class);
	}

	@Bean
	public AuditorAware<String> auditorProvider() {
		return () -> Optional.of(UserUtil.getIP(request));
	}
}
