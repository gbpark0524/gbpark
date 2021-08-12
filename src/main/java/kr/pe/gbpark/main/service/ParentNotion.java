package kr.pe.gbpark.main.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum ParentNotion {
	ISSUE("c1a4bc22-f33e-416a-850d-9e1fe06e4e53","issue"),
	DATA_STRUCTURE("b4f06456-0343-42cb-8b36-b2bd1e8b8062","structure"),
	MAC("6ac1f9b5-8d11-4888-af8e-2c938debc3a2","mac"),
	DEFAULT("","default");

	private String id;
	private String className;

	private static final Map<String, ParentNotion> parentNotionMap =
			Collections.unmodifiableMap(Stream.of(values())
					.collect(Collectors.toMap(ParentNotion::getId, Function.identity())));

	public static ParentNotion getParentNotion(String temptId) {
		return parentNotionMap.getOrDefault(temptId, DEFAULT);
	}
}
