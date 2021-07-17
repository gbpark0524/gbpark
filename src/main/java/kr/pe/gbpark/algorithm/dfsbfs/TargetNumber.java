package kr.pe.gbpark.algorithm.dfsbfs;

import kr.pe.gbpark.util.entity.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;


public class TargetNumber extends BaseTimeEntity {
	public int solution(int[] numbers, int target) {
		int answer = 0;
		List<Integer> answerList = new ArrayList<>();

		search(numbers, 0, 0, answerList, target);

		return answerList.size();
	}

	private void search(int[] numbers, int index, int sum, List<Integer> answerList, int target) {
		if(index == numbers.length) {
			if(sum == target) {
				answerList.add(1);
			}
			return;
		}
		search(numbers, index + 1, sum - numbers[index], answerList, target);
		search(numbers, index + 1, sum + numbers[index], answerList, target);
	}
}
	

