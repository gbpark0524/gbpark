package kr.pe.gbpark.algorithm.dfsbfs;

import kr.pe.gbpark.util.entity.BaseTimeEntity;

import java.util.*;

public class WordsConversion extends BaseTimeEntity {
	public int solution(String begin, String target, String[] words) {
		int answer = 0;
		Queue<WordNode> queue = new LinkedList<>();
		int length = words.length;
		boolean existTarget = false;

		// 최적화를 위해 target 부터 탐색
		for (int i = 0; i < length; i++) {
			if(words[i].equals(target)) {
				existTarget = true;
				Set<Integer> start = new HashSet<>();
				start.add(i);
				queue.offer(new WordNode(i, 0, start));
			}
		}

		if(!existTarget) return 0;
		if(isConnectedWords(begin, target)) return 1;

		while(!queue.isEmpty()) {
			WordNode node = queue.poll();
			String currword = words[node.getIndex()];
			for (int i = 0; i < length; i++) {
				String searchWord = words[i];
				if(isConnectedWords(currword, searchWord) && !node.getVisited().contains(i)) {
					if(isConnectedWords(searchWord, begin)) return node.depth + 2;
					Set<Integer> visited = new HashSet<>(node.getVisited());
					visited.add(i);
					queue.offer(new WordNode(i, node.getDepth() + 1, visited));
				}
			}
		}

		return answer;
	}

	private boolean isConnectedWords(String word1, String word2) {
		int length = word1.length();
		int returnNum = 0;

		for (int i = 0; i < length; i++) {
			if(returnNum > 1) return false;
			if(word1.charAt(i) != word2.charAt(i)) returnNum++;
		}

		return (returnNum == 1);
	}

	private static class WordNode {
		private final int index;
		private final int depth;
		private final Set<Integer> visited;

		public WordNode(int index, int depth, Set<Integer> visited) {
			this.index = index;
			this.depth = depth;
			this.visited = visited;
		}

		public int getIndex() {
			return index;
		}

		public int getDepth() {
			return depth;
		}

		public Set<Integer> getVisited() {
			return visited;
		}
	}
}
	

