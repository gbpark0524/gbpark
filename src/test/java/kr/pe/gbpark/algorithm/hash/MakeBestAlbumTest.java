package kr.pe.gbpark.algorithm.hash;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MakeBestAlbumTest {
	MakeBestAlbum m = new MakeBestAlbum();

	@Test
	void solution() {
		List<Object> qList = new ArrayList<>();
		List<Object> qList2 = new ArrayList<>();
		List<Object> aList = new ArrayList<>();

		qList.add(new String[] {"classic", "pop", "classic", "classic", "pop"});

		qList2.add(new int[] {500, 600, 150, 800, 2500});

		aList.add(new int[] {4,1,3,0});

		for (int i = 0; i < qList.size(); i++) {
			assertThat(m.solution((String[])qList.get(i), (int[])qList2.get(i))).isEqualTo(aList.get(i));
		}
	}

}