package kr.pe.gbpark.algorithm.hash;

import java.util.*;

public class MakeBestAlbum {

	public int[] solution(String[] genres, int[] plays) {
		int length = genres.length;
		HashMap<String, Integer> gChart = new HashMap<>();
		PriorityQueue<Album> pq = new PriorityQueue<>();
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			String g = genres[i];
			int p = plays[i];
			if (gChart.containsKey(g)) {
				gChart.put(g, gChart.get(g) + p);
			} else {
				gChart.put(g, p);
			}
		}

		for (int i = 0; i < length; i++) {
			pq.add(new Album(i, gChart.get(genres[i]), plays[i], genres[i]));
		}

		String cur = "";
		int counts = 0;
		while (!pq.isEmpty()) {
			Album album = pq.poll();
			String genre = album.getGenre();

			if(!cur.equals(genre)) {
				cur = genre;
				counts = 0;
			}

			switch (counts){
				case 2:
					continue;
				case 1:
				case 0:
					list.add(album.getId());
					counts++;
					break;
			}
		}

		int[] answer = new int[list.size()];
		int answerLength = answer.length;
		for (int i = 0; i < answerLength; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}

class Album implements Comparable<Album> {
	private final int id;
	private final int gPoints;
	private final int plays;
	private final String genre;

	@Override
	public int compareTo(Album o) {
		if (!(this.gPoints == o.gPoints)){
			return o.gPoints - this.gPoints;
		} else if (!(this.plays == o.plays)) {
			return o.plays - this.plays;
		} else{
			return this.id - o.id;
		}
	}

	public Album(int id, int gPoints, int plays, String genre) {
		this.id = id;
		this.gPoints = gPoints;
		this.plays = plays;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public int getgPoints() {
		return gPoints;
	}

	public int getPlays() {
		return plays;
	}

	public String getGenre() {
		return genre;
	}
}

