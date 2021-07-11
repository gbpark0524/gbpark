package kr.pe.gbpark.repository.main;

import kr.pe.gbpark.domain.main.ToMe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToMeRepository extends JpaRepository<ToMe, Long> {

}
