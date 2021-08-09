package kr.pe.gbpark.algorithm.weakly;

import java.util.*;

public class FriendsSichuan {
	final static String IMPOSSIBLE = "IMPOSSIBLE";

	public String solution(int m, int n, String[] board) {
		StringBuilder answer = new StringBuilder();
		HashMap<Integer, FriendToken> map = new HashMap<>();
		LinkedList<FriendToken> list = new LinkedList<>();
		int[][] charBoard = new int[m][n];

		for (int i = 0; i < m ; i++) {
			String str = board[i];
			for (int j = 0; j < n; j++) {
				int ch = str.charAt(j);
				charBoard[i][j] = ch;
				if(ch > 46) {
					if(map.containsKey(ch)) {
						map.get(ch).setEnd(new int[] {i ,j});
					}else {
						map.put(ch,new FriendToken(new int[] {i ,j}, ch));
					}
				}
			}
		}

		for (int i = 65; i < 91; i++) if (map.containsKey(i)) list.add(map.get(i));

		while(!list.isEmpty()) {
			boolean flag = false;
			for (FriendToken friendToken : list) {
				if(friendToken.isLinked(charBoard)) {
					int[] start = friendToken.getStart();
					int[] end = friendToken.getEnd();
					char character = (char)friendToken.getCharacter();
					charBoard[start[0]][start[1]] = '.';
					charBoard[end[0]][end[1]] = '.';
					answer.append(character);
					flag = true;
					list.remove(friendToken);
					break;
				}
			}

			if(!flag) return IMPOSSIBLE;
		}

		return answer.toString();
	}

	static class FriendToken {
		private int[] start;
		private int[] end;
		private int character;

		public FriendToken(int[] start, int character) {
			this.start = start;
			this.character = character;
		}

		public boolean isLinked(int[][] board) {
			char ch = (char) board[start[0]][start[1]];
			int x = end[0] - start[0] != 0 ? (end[0] - start[0])/Math.abs(end[0] - start[0]) : 0;
			int y = end[1] - start[1] != 0 ? (end[1] - start[1])/Math.abs(end[1] - start[1]) : 0;
			boolean resultX = true;
			boolean resultY = true;

			for (int i = start[0] + x; i < end[0]; i += x) {
				if(resultX && board[i][start[1]] != 46) resultX = false;
				if(resultY && board[i][end[1]] != 46) resultY = false;
			}
			if(!(resultX || resultY)) return false;
			for (int i = start[1] + y; i < end[1]; i += y) {
				if(resultX && board[end[0]][i] != 46) resultX = false;
				if(resultY && board[start[0]][i] != 46) resultY = false;
			}
			if(resultX && !(board[end[0]][start[1]] == 46 || board[end[0]][start[1]] == ch )) resultX = false;
			if(resultY && !(board[start[0]][end[1]] == 46 || board[start[0]][end[1]] == ch )) resultY = false;

			return resultX || resultY;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			FriendToken that = (FriendToken) o;
			return character == that.character;
		}

		@Override
		public int hashCode() {
			return Objects.hash(character);
		}

		public void setEnd(int[] end) {
			this.end = end;
		}

		public int[] getStart() {
			return start;
		}

		public int[] getEnd() {
			return end;
		}

		public int getCharacter() {
			return character;
		}
	}
}


/*
* 다음 조건을 만족하는 경로가 있을 때 두 타일을 제거할 수 있다.

경로의 양 끝은 제거하려는 두 타일이다.
경로는 두 개 이하의 수평/수직 선분으로 구성되어 있고, 이들은 모두 연결되어 있다. (즉, 경로를 한 번 이하로 꺾을 수 있다)
참고: 프렌즈 사천성은 경로가 세 개 이하의 선분으로 구성되어야 한다는 점이 다르다. (즉, 경로를 두 번 이하로 꺾을 수 있다)
경로 상에는 다른 타일 또는 장애물이 없어야 한다.
scpuzzle

위의 배열에서 어피치 타일은 직선의 경로로 이을 수 있으므로 제거 가능하다. 라이언 타일 역시 한 번 꺾인 경로로 연결되므로 제거 가능하다. 무지 타일의 경우 다른 타일을 지나지 않는 경로는 두 번 꺾여야 하므로 제거할 수 없는 타일이며, 튜브 타일 역시 직선의 경로 사이에 장애물이 있으므로 제거 가능하지 않다.

타일 배열이 주어졌을 때, 규칙에 따라 타일을 모두 제거할 수 있는지, 그 경우 어떤 순서로 타일을 제거하면 되는지 구하는 프로그램을 작성해보자.

입력 형식
입력은 게임판의 크기를 나타내는 m과 n, 그리고 배치된 타일의 정보를 담은 문자열 배열 board로 주어진다. 이 배열의 크기는 m이며, 각각의 원소는 n글자의 문자열로 구성되어 있다. 입력되는 값의 제한조건은 다음과 같다.

1 <= m, n <= 100
board의 원소는 아래 나열된 문자로 구성된 문자열이다. 각 문자의 의미는 다음과 같다.
.: 빈칸을 나타낸다.
*: 막힌 칸을 나타낸다.
알파벳 대문자(A-Z): 타일을 나타낸다. 이 문제에서, 같은 글자로 이루어진 타일은 한 테스트 케이스에 항상 두 개씩만 존재한다.
board에는 알파벳 대문자가 항상 존재한다. 즉, 타일이 없는 입력은 주어지지 않는다.
출력 형식
해가 존재하는 경우 타일을 제거하는 순서대로 한 글자씩 이루어진 문자열을, 그렇지 않은 경우 IMPOSSIBLE을 리턴한다. 해가 여러 가지인 경우, 알파벳 순으로 가장 먼저인 문자열을 리턴한다.

예제 입출력
m	n	board								answer
3	3	["DBA", "C*A", "CDB"]				"ABCD"
2	4	["NRYN", "ARYA"]					"RYAN"
4	4	[".ZI.", "M.**", "MZU.", ".IU."]	"MUZI"
2	2	["AB", "BA"]						"IMPOSSIBLE"
예제에 대한 설명
첫 번째 테스트 케이스에서 처음으로 제거 가능한 타일은 A와 C이다. 그리고 모든 가능한 경우를 나열하면 ABCD, ACBD, ACDB, CABD, CADB, CDAB이다. 이 중 알파벳 순으로 가장 먼저인 ABCD가 정답이다.

네 번째 테스트 케이스는 초기 상태에서 제거할 수 있는 타일이 없으므로 타일을 모두 제거하는 것이 불가능하다. 따라서 정답은 IMPOSSIBLE이다.
* */