package kr.pe.gbpark.algorithm.heap;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;


class DoublePriorityQueueTest {

	DoublePriorityQueue dpq = new DoublePriorityQueue();

	@Test
	void solution() {
		List<Object> qList = new ArrayList<>();
		List<Object> aList = new ArrayList<>();

		qList.add(new String[] {"I 16","D 1"});
		qList.add(new String[] {"I 7","I 5","I -5","D -1"});

		aList.add(new int[] {0,0});
		aList.add(new int[] {7,5});

		for (int i = 0; i < qList.size(); i++) {
			assertThat(dpq.solution((String[]) qList.get(i))).isEqualTo(aList.get(i));
		}
	}

	@Test
	void solution2() {
		List<Object> qList = new ArrayList<>();
		List<Object> aList = new ArrayList<>();

		qList.add(new String[] {"I 16","D 1"});
		qList.add(new String[] {"I 7","I 5","I -5","D -1"});

		aList.add(new int[] {0,0});
		aList.add(new int[] {7,5});

		for (int i = 0; i < qList.size(); i++) {
			assertThat(dpq.solution2((String[]) qList.get(i))).isEqualTo(aList.get(i));
		}
	}
}