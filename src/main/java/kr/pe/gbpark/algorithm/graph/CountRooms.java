package kr.pe.gbpark.algorithm.graph;

import java.util.*;

public class CountRooms {
	public int solution(int[] arrows) {
		int answer = 0;
		HashMap<Node, int[]> visited = new HashMap<>();
		Node curr = new Node(0, 0);
		int[] moveX = {0,1,1,1,0,-1,-1,-1};
		int[] moveY = {1,1,0,-1,-1,-1,0,1};

		for (int arrow : arrows) {
			Node next = new Node(curr.getX() + moveX[arrow], curr.getY() + moveY[arrow]);

			int[] currVisited = visited.get(curr) != null ? visited.get(curr) : new int[8];
			int[] nextVisited = visited.get(next) != null ? visited.get(next) : new int[8];
			if(currVisited[arrow] == 0) {
				// 방문했던 Node
				if(visited.containsKey(next)) {
					answer ++;
				}

				// 교차하는 경로
				if((moveX[arrow] + moveY[arrow]) % 2 == 0) {
					Node minus45 = new Node(curr.getX() + moveX[(arrow - 1)%8], curr.getY() + moveY[(arrow - 1)%8]);
					if(visited.containsKey(minus45) && visited.get(minus45)[(arrow + 2)%8] == 1) answer++;
				}

				currVisited[arrow] = 1;
				visited.put(curr, currVisited);
				nextVisited[(arrow+4)%8] = 1;
				visited.put(next, nextVisited);
			}
			curr = next;
		}

		return answer;
	}
	
	class Node {
		private int x;
		private int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Node node = (Node) o;
			return x == node.x && y == node.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}

}


	/*

					7	↑0	 1
					←6		→2
					5	↓4	 3
		ex) 1일때는 오른쪽 위로 이동

		그림을 그릴 때, 사방이 막히면 방하나로 샙니다.
		이동하는 방향이 담긴 배열 arrows가 매개변수로 주어질 때, 방의 갯수를 return 하도록 solution 함수를 작성하세요.

		제한사항
		배열 arrows의 크기는 1 이상 100,000 이하 입니다.
		arrows의 원소는 0 이상 7 이하 입니다.
		방은 다른 방으로 둘러 싸여질 수 있습니다.
		입출력 예
		arrows														return
		[6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0]	3
		입출력 예 설명
		스크린샷 2018-09-06 오후 5.08.09.png

		(0,0) 부터 시작해서 6(왼쪽) 으로 3번 이동합니다. 그 이후 주어진 arrows 를 따라 그립니다.
		삼각형 (1), 큰 사각형(1), 평행사변형(1) = 3*/