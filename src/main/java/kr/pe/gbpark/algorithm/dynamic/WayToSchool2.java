package kr.pe.gbpark.algorithm.dynamic;

import java.util.Arrays;

public class WayToSchool2 {
	public int solution(int m, int n, int[][] puddles) {
		int[][] ways = new int[m+1][n+1];
		int length = puddles.length;
		Arrays.sort(puddles, (o1, o2) -> {
			if (o1[0] != o2[0]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});
		int puddleIndex = 0;
		if(Arrays.equals(puddles[0], new int[]{1, 1})) {
			return 0;
		}
		ways[1][1] = 1;

		for (int j = 2; j <= n; j++) {
			if(puddles[puddleIndex][0] == 1 && puddles[puddleIndex][1] == j) {
				puddleIndex++;
				break;
			}
			ways[1][j] = 1;
		}

		while(puddleIndex < puddles.length) {
			if(puddles[puddleIndex][0] == 1) {
				puddleIndex++;
			}else {
				break;
			}
		}

		for (int i = 2; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(puddleIndex < length && puddles[puddleIndex][0] == i && puddles[puddleIndex][1] == j) {
					puddleIndex++;
					continue;
				}

				ways[i][j] = ways[i][j-1] + ways[i-1][j];
				if(ways[i][j] > 1000000007)
					ways[i][j] = ways[i][j]%1000000007;
			}
		}

		return ways[m][n];
	}
}

/*
			통과 (3.99ms, 52.4MB)
테스트 2 〉	통과 (1.01ms, 52.4MB)
테스트 3 〉	통과 (1.14ms, 52.7MB)
테스트 4 〉	통과 (1.30ms, 52.7MB)
테스트 5 〉	통과 (1.17ms, 52.6MB)
테스트 6 〉	통과 (1.53ms, 51.7MB)
테스트 7 〉	통과 (1.02ms, 53.3MB)
테스트 8 〉	통과 (1.31ms, 52.9MB)
테스트 9 〉	통과 (1.34ms, 52.1MB)
테스트 10 〉통과 (0.94ms, 52.1MB)*/
