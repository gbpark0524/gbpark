package kr.pe.gbpark.user.repository;

import kr.pe.gbpark.user.entity.WaitingMail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WaitingMailRepository extends JpaRepository<WaitingMail, Long> {
	Optional<WaitingMail> findByMail(String mail);
}
