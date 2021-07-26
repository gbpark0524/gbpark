package kr.pe.gbpark.algorithm.dynamic;

public class IntTriangle2 {
	public int solution(int[][] triangle) {
		int answer = 0;
		int triLength = triangle.length;
		for (int i = 1; i < triLength-1; i++) {
			int[] row = triangle[i];
			int[] beforeRow = triangle[i-1];
			int rowLength = row.length;
			row[0] += beforeRow[0];
			row[rowLength-1] += beforeRow[rowLength-2];
			for (int j = 1; j < rowLength-1; j++) {
				row[j] += Math.max(beforeRow[j-1], beforeRow[j]);
			}
		}
		int[] lastRow = triangle[triLength-1];
		int[] lastBeforeRow = triangle[triLength-2];
		answer = lastRow[0] + lastBeforeRow[0];
		answer = Math.max(lastRow[triLength-1] + lastBeforeRow[triLength-2], answer);
		for (int i = 1; i < triLength-1; i++) {
			answer = Math.max(lastRow[i] + Math.max(lastBeforeRow[i - 1], lastBeforeRow[i]), answer);
		}
		return answer;
	}
}
