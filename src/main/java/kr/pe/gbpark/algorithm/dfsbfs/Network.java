package kr.pe.gbpark.algorithm.dfsbfs;

import kr.pe.gbpark.util.entity.BaseTimeEntity;

import java.util.HashSet;

public class Network extends BaseTimeEntity {
	public int solution(int n, int[][] computers) {
		int answer = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(i);
		}

		while(!set.isEmpty()) {
			dfs(computers,set.iterator().next() ,set);
			answer++;
		}

		return answer;
	}

	private void dfs(int[][] computers, int nowIndex, HashSet<Integer> remainNode) {
		int length = computers[0].length;
		remainNode.remove(nowIndex);
		for (int i = 0; i < length; i++) {
			if(!remainNode.contains(i) || computers[nowIndex][i] == 0) continue;
			remainNode.remove(i);
			dfs(computers, i, remainNode);
		}
	}
}
	

