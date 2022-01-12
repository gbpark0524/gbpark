package kr.pe.gbpark.main.repository;

import kr.pe.gbpark.main.entity.ToMe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToMeRepository extends JpaRepository<ToMe, Long>, ToMeRepositoryCustom {

}
