package kr.pe.gbpark.algorithm.graph;

import java.util.*;

public class MovingNNRooms {
	public int solution(int[][] land, int height) {
		int answer = 0;
		int length = land.length;
		int[][] visited = new int[length][length];
		Queue<int[]> dfsQ = new LinkedList<>();
		PriorityQueue<int[]> minCost = new PriorityQueue<>(Comparator.comparingInt(a -> ((int[]) a)[2]));
		dfsQ.offer(new int[] {length/2,length/2});
		int visitedN = 0;

		while(visitedN < length*length) {
			if(!dfsQ.isEmpty()) {
				int[] curr = dfsQ.poll();
				int x = curr[0];
				int y = curr[1];

				if(visited[x][y] == 0){
					visited[x][y] = 1;
					visitedN++;
				} else {
					continue;
				}

				Stack<int[]> adjacent = adjacent(x, y, length, visited);
				while(!adjacent.isEmpty()) {
					int[] search = adjacent.pop();
					int xSearch = search[0];
					int ySearch = search[1];
					int diff = Math.abs(land[x][y] - land[xSearch][ySearch]);

					if(diff > height) {
						minCost.add(new int[] {xSearch,ySearch,diff});
					} else {
						dfsQ.offer(new int[] {xSearch,ySearch});
					}
				}
			}

			if(dfsQ.isEmpty()) {
				while(!minCost.isEmpty()) {
					int[] min = minCost.poll();
					int xMin = min[0];
					int yMin = min[1];

					if(visited[xMin][yMin] == 0) {
						answer += min[2];
						dfsQ.add(new int[] {xMin, yMin});
						break;
					}
				}
			}
		}

		return answer;
	}

	Stack<int[]> adjacent(int x, int y, int length, int[][] visited) {
		Stack<int[]> result = new Stack<>();
		if(x > 0 && visited[x-1][y] == 0) result.push(new int[] {x-1,y});
		if(y > 0 && visited[x][y-1] == 0) result.push(new int[] {x,y-1});
		if(x + 1 < length && visited[x+1][y] == 0) result.push(new int[] {x+1,y});
		if(y + 1 < length && visited[x][y+1] == 0) result.push(new int[] {x,y+1});
		return  result;
	}
}


/*
N x N 크기인 정사각 격자 형태의 지형이 있습니다. 각 격자 칸은 1 x 1 크기이며, 숫자가 하나씩 적혀있습니다.
격자 칸에 적힌 숫자는 그 칸의 높이를 나타냅니다.

이 지형의 아무 칸에서나 출발해 모든 칸을 방문하는 탐험을 떠나려 합니다.
칸을 이동할 때는 상, 하, 좌, 우로 한 칸씩 이동할 수 있는데, 현재 칸과 이동하려는 칸의 높이 차가 height 이하여야 합니다.
높이 차가 height 보다 많이 나는 경우에는 사다리를 설치해서 이동할 수 있습니다.
이때, 사다리를 설치하는데 두 격자 칸의 높이차만큼 비용이 듭니다.
따라서, 최대한 적은 비용이 들도록 사다리를 설치해서 모든 칸으로 이동 가능하도록 해야 합니다.
설치할 수 있는 사다리 개수에 제한은 없으며, 설치한 사다리는 철거하지 않습니다.

각 격자칸의 높이가 담긴 2차원 배열 land와 이동 가능한 최대 높이차 height가 매개변수로 주어질 때,
모든 칸을 방문하기 위해 필요한 사다리 설치 비용의 최솟값을 return 하도록 solution 함수를 완성해주세요.

제한사항
land는 N x N크기인 2차원 배열입니다.
land의 최소 크기는 4 x 4, 최대 크기는 300 x 300입니다.
land의 원소는 각 격자 칸의 높이를 나타냅니다.
격자 칸의 높이는 1 이상 10,000 이하인 자연수입니다.
height는 1 이상 10,000 이하인 자연수입니다.

입출력 예
land																height	result
[[1, 4, 8, 10], [5, 5, 5, 5], [10, 10, 10, 10], [10, 10, 10, 20]]	3		15
[[10, 11, 10, 11], [2, 21, 20, 10], [1, 20, 21, 11], [2, 1, 2, 1]]	1		18
*/


/* 0 0 시작 보다 가운데서 시작이 평균적으로 더 짧음
테스트 1 〉	통과 (2.64ms, 57.7MB)
테스트 2 〉	통과 (2.73ms, 58.3MB)
테스트 3 〉	통과 (2.13ms, 58MB)
테스트 4 〉	통과 (3.06ms, 58.1MB)
테스트 5 〉	통과 (2.86ms, 57.4MB)
테스트 6 〉	통과 (3.21ms, 56.8MB)
테스트 7 〉	통과 (2.47ms, 59.7MB)
테스트 8 〉	통과 (2.24ms, 58.2MB)
테스트 9 〉	통과 (3.05ms, 58.4MB)
테스트 10 〉	통과 (9.56ms, 57.3MB)
테스트 11 〉	통과 (8.94ms, 58.5MB)
테스트 12 〉	통과 (2.90ms, 58.5MB)
테스트 13 〉	통과 (2.12ms, 67.4MB)
테스트 14 〉	통과 (5.70ms, 57.5MB)
테스트 15 〉	통과 (8.80ms, 57.6MB)
테스트 16 〉	통과 (19.01ms, 70.1MB)
테스트 17 〉	통과 (135.64ms, 61.8MB)
테스트 18 〉	통과 (101.12ms, 76.7MB)
테스트 19 〉	통과 (40.96ms, 59.9MB)
테스트 20 〉	통과 (101.21ms, 74.5MB)
테스트 21 〉	통과 (99.33ms, 78.5MB)
테스트 22 〉	통과 (132.82ms, 104MB)
테스트 23 〉	통과 (170.36ms, 96MB)
테스트 24 〉	통과 (63.71ms, 78.9MB)
테스트 25 〉	통과 (133.56ms, 82MB)
테스트 26 〉	통과 (145.00ms, 81.9MB)
테스트 27 〉	통과 (132.47ms, 80MB)
테스트 28 〉	통과 (153.40ms, 99.7MB)
테스트 29 〉	통과 (169.85ms, 102MB)
테스트 30 〉	통과 (160.85ms, 100MB)*/
