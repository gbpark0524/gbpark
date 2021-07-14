package kr.pe.gbpark.algorithm.bruteforce;

import java.util.HashSet;

public class PrimeNumber {
	HashSet<Integer> set = new HashSet<>();


	public int solution(String numbers) {
		set.clear();
		int answer = 0;

		doPermutation(numbers, 0);

		for (Integer num : set) {
			if(checkPrime(num)) answer++;
		}

		return answer;
	}

	boolean checkPrime(int num) {
		if(num == 1 || num == 0) return false;
		if(num == 2 ) return true;
		int index = 2;
		int max = num;
		while(index <= max) {
			if(num % index == 0) {
				return false;
			}
			index++;
			max = num/index;
		}
		return true;
	}

	void doPermutation(String num, int result) {
		int length = num.length();
		if(length != 1) {
			for (int i = 0; i < length; i++) {
				int temptResult = result*10 + ((int)num.charAt(i) - 48);
				String temptNum = num.substring(0,i) + num.substring(i+1);
				set.add(temptResult);
				doPermutation(temptNum, temptResult);
			}
		}else {
			result = result*10 + Integer.parseInt(num);
			set.add(result);
		}
	}
}
