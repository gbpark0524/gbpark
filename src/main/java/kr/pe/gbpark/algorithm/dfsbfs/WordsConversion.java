package kr.pe.gbpark.algorithm.dfsbfs;

import kr.pe.gbpark.util.entity.BaseTimeEntity;

import java.util.*;

/*두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

		1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
		2. words에 있는 단어로만 변환할 수 있습니다.
		예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.

		두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

		제한사항
		각 단어는 알파벳 소문자로만 이루어져 있습니다.
		각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
		words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
		begin과 target은 같지 않습니다.
		변환할 수 없는 경우에는 0를 return 합니다.*/

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
	

