package kr.pe.gbpark.algorithm.dynamic;

import java.util.HashMap;

public class IntTriangle {
	public int solution(int[][] triangle) {
		HashMap<String, Integer> map = new HashMap<>();
		int floors = triangle.length;

		for (int i = 1; i < floors; i++) {
			calFloorMax(i, map, triangle[i-1]);
		}

		return calFloorMax(floors, map, triangle[floors-1]);
	}

	private int calFloorMax(int floor, HashMap<String, Integer> map, int[] floorArr) {
		if(floor == 1) {
			map.put("1,1", floorArr[0]);
			return floorArr[0];
		}

		String beforFloor = String.valueOf(floor-1);
		int max = 0;
		int temptNum = 0;

		max = floorArr[0] + map.get(beforFloor + ",1");
		map.put(floor + ",1",max);
		temptNum = floorArr[floor-1] + map.get(beforFloor + "," + beforFloor);
		map.put(floor + "," + floor, temptNum);
		max = Math.max(temptNum, max);

		for (int i = 2; i < floor; i++) {
			temptNum = floorArr[i-1] + Math.max(map.get(beforFloor + "," + (i - 1)),map.get(beforFloor + "," + i));
			map.put(floor + "," + i,temptNum);
			max = Math.max(temptNum, max);
		}
		return max;
	}
}




/*
				7
			3		8
		8		1		0
	2		7		4		4
4		5		2		6		5

위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.

삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.

제한사항
삼각형의 높이는 1 이상 500 이하입니다.
삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.
입출력 														예
triangle													result
[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]		30		*/
