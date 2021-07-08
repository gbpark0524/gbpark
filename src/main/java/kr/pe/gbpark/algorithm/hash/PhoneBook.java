package kr.pe.gbpark.algorithm.hash;

import java.util.*;

public class PhoneBook {
	public boolean solution(String[] phone_book) {
		HashSet<String> set = new HashSet<>(Arrays.asList(phone_book));

		for (String num : phone_book) {
			for (int i = 0; i < num.length(); i++) {
				if(set.contains(num.substring(0,i))) {
					return false;
				}
			}
		}

		return true;
	}
}
