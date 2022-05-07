package kr.pe.gbpark.main.service;

import kr.pe.gbpark.util.enums.results.LogicResult;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ToMeLogicResult implements LogicResult {
	SUCCESS	(true	,"글 저장이 완료 되었습니다"),
	EMPTY	(false	,"입력되지 않은 값이 있습니다"),
	FAIL	(false	,"글 저장에 실패하였습니다");

	private boolean result;
	private String message;

	@Override
	public boolean isSuccess() {
		return result;
	}

	@Override
	public String getMessage() {
		return message;
	}

}

