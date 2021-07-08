package kr.pe.gbpark.algorithm.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

	PhoneBook phoneBook = new PhoneBook();
	@Test
	void solution() {
		String[] pb = {"119", "97674223", "1195524421"};
		String[] pb2 = {"123","456","789"};
		String[] pb3 = {"12","123","1235","567","88"};

		assertFalse(phoneBook.solution(pb));
		assertTrue(phoneBook.solution(pb2));
		assertFalse(phoneBook.solution(pb3));
	}
}