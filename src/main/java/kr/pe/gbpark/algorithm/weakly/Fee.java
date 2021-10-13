package kr.pe.gbpark.algorithm.weakly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Fee {
	public int[] solution(int[] fees, String[] records) {
		int basicTime = fees[0];
		int basicFee = fees[1];
		int unitTime = fees[2];
		int unitFee = fees[3];
		HashMap<String, Integer> logCars = new HashMap<>();
		HashMap<String, Integer> feeCounter = new HashMap<>();

		for (String record : records) {
			String[] split = record.split(" ");
			int time = Integer.parseInt(split[0].split(":")[1])
					+ Integer.parseInt(split[0].split(":")[0]) * 60;
			String num = split[1];
			if(split[2].equals("IN")) feeCounter.put(num, time);
			else if(split[2].equals("OUT")) {
				Integer oldTime = feeCounter.remove(num);
				if(!logCars.containsKey(num)) logCars.put(num, time-oldTime);
				else {
					int before = logCars.get(num);
					logCars.put(num, time-oldTime + before);
				}
			}
		}

		for (String key : feeCounter.keySet()) {
			Integer oldTime = feeCounter.get(key);
			int before = logCars.getOrDefault(key, 0);
			logCars.put(key, (23*60+59) - oldTime + before);
		}

		int size = logCars.size();
		int[] answer = new int[size];
		List<String> nums = new ArrayList<>(logCars.keySet());
		Collections.sort(nums);

		for (int i = 0; i < size; i++) {
			Integer wholeTime = logCars.get(nums.get(i));
			if(wholeTime <= basicTime) answer[i] = basicFee;
			else answer[i] = basicFee + (int)Math.ceil((wholeTime - basicTime) / (double)unitTime) * unitFee;
		}

		return answer;
	}
}
