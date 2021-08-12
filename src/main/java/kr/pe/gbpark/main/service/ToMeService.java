package kr.pe.gbpark.main.service;

import kr.pe.gbpark.main.entity.ToMe;
import kr.pe.gbpark.main.repository.ToMeRepository;
import kr.pe.gbpark.util.enums.results.LogicResult;
import kr.pe.gbpark.util.service.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ToMeService {
	final Logger logger = LoggerFactory.getLogger(ToMeService.class);
	final UserUtil userUtil;
	final ToMeRepository toMeRepository;

	public ToMeService(UserUtil userUtil, ToMeRepository toMeRepository) {
		this.userUtil = userUtil;
		this.toMeRepository = toMeRepository;
	}

	public LogicResult ToMeSave(String title, String message) {
		if(title.isEmpty() || message.isEmpty()) return ToMeLogicResult.EMPTY;

		ToMe tome = new ToMe(title, message);
		try {
			toMeRepository.save(tome);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ToMeLogicResult.FAIL;
		}
		return ToMeLogicResult.SUCCESS;
	}
}
