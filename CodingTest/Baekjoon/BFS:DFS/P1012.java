package BFS_DFS.P1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int testCase;
	static int m;		// 가로길이
	static int n;		// 세로길이
	static int k;		// 배추가 심어져 있는 위치의 갯수 
	static int[][] map;		// 배추지도
	static int[] dx = {-1, 0, 1, 0};	// x축 조이스틱
	static int[] dy = {0, 1, 0, -1};	// y축 조이스틱

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCase; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[m+1][n+1];
			int count = 0;
			
			for (int j = 0; j < k; j++) {
				s = br.readLine();
				st = new StringTokenizer(s, " ");
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
			}
			
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[k][j] != 0) {
						dfs(k, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			// 다음 x, y 좌표가 배추지도 밖이면 그냥 통과.
			if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) {
				continue;
			}
			
			// 다음 좌표가 0이면 통과
			if (map[nextX][nextY] == 0) {
				continue;
			}
			
			// 방문한 곳 0으로 바꾸기
			map[nextX][nextY] = 0;
			dfs(nextX, nextY);
		}
	}
}
