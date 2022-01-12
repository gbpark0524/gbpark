package kr.pe.gbpark.main.service;

import static org.assertj.core.api.Assertions.*;

import kr.pe.gbpark.util.enums.results.LogicResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

@SpringBootTest
@Transactional
class ToMeServiceTest {
	@Autowired
	ToMeService toMeService;

	@Test
	void toMeSave() {

		LogicResult logicResult = toMeService.ToMeSave("ts", "010XXXX", "retestst");
		if(!logicResult.isSuccess()) fail(logicResult.getMessage());

		System.out.println("logicResult.getMessage() = " + logicResult.getMessage());
	}
}