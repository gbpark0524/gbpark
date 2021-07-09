package kr.pe.gbpark.algorithm.hash;

import java.util.HashMap;

public class SpyDisguise {

	// 종류별 옷을 조합하는 경우의수 구하기, 종류별로 안입는것 가능. 최소 한개만 걸치면 됨
	public int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> closet = new HashMap<>();
		for (String[] clothe : clothes) {
			String type = clothe[1];
			if(closet.containsKey(type)) {
				closet.put(type,closet.get(type) + 1);
			}else {
				closet.put(type, 1);
			}
		}

		// 종류별 경우의수, 선택하지 않을 경우도 선택
		for (Integer value : closet.values()) {
			answer = answer * (value + 1);
		}

		return --answer;
	}
}
