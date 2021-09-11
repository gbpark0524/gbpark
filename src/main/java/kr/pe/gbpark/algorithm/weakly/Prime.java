package kr.pe.gbpark.algorithm.weakly;

public class Prime {
	public int solution(int n, int k) {
		int answer = 0;
		StringBuilder num = new StringBuilder();

		while (n >= k) {
			int d = n % k;
			if(d != 0) num.insert(0, d);
			else{
				if(num.length() != 0 && checkPrime(Long.parseLong((String.valueOf(num))))) answer++;
				num = new StringBuilder();
			}

			n = n / k;
		}
		num.insert(0, n);
		if(num.length() != 0 && checkPrime(Long.parseLong(String.valueOf(num)))) answer++;

		return answer;
	}

	boolean checkPrime(Long num) {
		if(num == 2 ) return true;
		if(num < 2 || num % 2 == 0) return false;
		int index = 3;
		int max = (int)Math.sqrt(num);

		while(index <= max) {
			if(num % index == 0) {
				return false;
			}
			index += 2;
		}
		return true;
	}
}
