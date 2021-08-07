package kr.pe.gbpark.algorithm.weakly;

import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BrianAdsTest {
	BrianAds brianAds = new BrianAds();
	BriansWorry briansWorry = new BriansWorry();

	@Test
	void solution() {
		List<Object> sentence = new ArrayList<>();
		List<Object> answers = new ArrayList<>();
		
		sentence.add("HaEaLaLaObWORLDb"); //HELLO WORLD 
		sentence.add("SpIpGpOpNpGJqOqA"); //SIGONG JOA
		sentence.add("A"); //A
		sentence.add("HELLOWORLD"); //HELLOWORLD
		sentence.add("aHbEbLbLbOacWdOdRdLdDc"); //HELLO WORLD
		sentence.add("HaEaLaLObWORLDb"); //HELL O WORLD
		sentence.add("AAA"); //AAA
		sentence.add("aHELLOWORLDa"); //HELLOWORLD
		sentence.add("AAAaBaAbBBBBbCcBdBdBdBcCeBfBeGgGGjGjGRvRvRvRvRvR"); //AA ABA BBBB C BBBB C BB GG GGG RRRRRR
		sentence.add("aIaAM"); //I AM
		sentence.add("bAaOb"); //AO
		sentence.add("AxAxAxAoBoBoB"); //invalid
		sentence.add("a"); //invalid
		sentence.add("Aa"); //invalid
		sentence.add("aA"); //invalid
		sentence.add("HaEaLaLaOWaOaRaLaD"); //invalid
		sentence.add("abHELLObaWORLD"); //invalid
		sentence.add("aHELLOa bWORLDb"); //invalid
		sentence.add("TxTxTxbAb"); //invalid
		sentence.add("bTxTxTaTxTbkABaCDk"); //invalid
		sentence.add("baHELLOabWORLD"); //invalid
		sentence.add("AxAxAxABcBcBcB"); //AAAA BBBB
		sentence.add("A B"); //invalid
		sentence.add("oBBoA"); //BB A
		sentence.add("AxAxAxA"); //AAAA
		sentence.add("aBcAadDeEdvAvlElmEEEEm"); //BA DE A E EEEE
		sentence.add("AcAcABaBaB"); //A A AB B B
		sentence.add("aGbWbFbDakGnWnLk"); //GWFD GWL
		sentence.add("aCaCa"); //invalid


		answers.add((String) "HELLO WORLD");
		answers.add((String) "SIGONG J O A");
		answers.add((String) "A");
		answers.add((String) "HELLOWORLD");
		answers.add((String) "HELLO WORLD");
		answers.add((String) "HELL O WORLD");
		answers.add((String) "AAA");
		answers.add((String) "HELLOWORLD");
//		answers.add((String) "AA ABA BBBB C BBBB C BB GG GGG RRRRRR");
		answers.add((String) "AAA B A BBBB C BBBB C BB GG G G G RRRRRR");
		answers.add((String) "I AM");
		answers.add((String) "AO");
		answers.add((String) "invalid");
		answers.add((String) "invalid");
		answers.add((String) "invalid");
		answers.add((String) "invalid");
		answers.add((String) "invalid");
		answers.add((String) "invalid");
		answers.add((String) "invalid");
		answers.add((String) "invalid");
		answers.add((String) "invalid");
		answers.add((String) "invalid");
		answers.add((String) "AAAA BBBB");
		answers.add((String) "invalid");
		answers.add((String) "BB A");
		answers.add((String) "AAAA");
		answers.add((String) "BA DE A E EEEE");
//		answers.add((String) "AAA BBB");
		answers.add((String) "A A AB B B");
		answers.add((String) "GWFD GWL");
		answers.add((String) "invalid");

		int size = answers.size();
		for (int i = 0; i < size; i++) {
			assertThat(briansWorry.solution((String) sentence.get(i)))
					.isEqualTo(answers.get(i));
		}
	}
}