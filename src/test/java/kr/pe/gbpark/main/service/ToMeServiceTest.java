package kr.pe.gbpark.main.service;

import kr.pe.gbpark.util.enums.results.LogicResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

@SpringBootTest
@Transactional
class ToMeServiceTest {
	@Autowired
	ToMeService toMeService;

	@Test
	void toMeSave() {

		LogicResult logicResult = toMeService.ToMeSave("ts", "retestst");
		Model model = new ConcurrentModel();
		if(logicResult.isSuccess()) ;

		model.addAttribute("msg",logicResult.getMessage() );
	}
}