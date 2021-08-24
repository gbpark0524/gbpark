package kr.pe.gbpark.user.repository;

import kr.pe.gbpark.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
