package BFS_DFS.P2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int[][] map;
	static int n;		// map의 한 변 길이
	static int[] dx = {-1, 0, 1, 0};		// x축 조이스틱 
	static int[] dy = {0, 1, 0, -1};		// y축 조이스틱
	static int houseCount;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int districtCount = 0;
		ArrayList<Integer> houseCountList = new ArrayList<>();
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 1로 되있는 부분들을 탐색. 탐색 후에는 1을 지울 것
				if (map[i][j] == 1) {
					houseCount = 0; 
					dfs(i, j);
					districtCount++;		// 단지수 +1
					houseCountList.add(houseCount);
				}
			}
		}
		System.out.println(districtCount);
		
		Collections.sort(houseCountList);
		
		for (int i = 0; i < houseCountList.size(); i++) {
			System.out.println(houseCountList.get(i));
		}
	}
	
	public static void dfs(int x, int y) {
		// 1. 체크인
		map[x][y] = 0;
		houseCount++;
//		System.out.println("x:"+x+" y:"+y+" count:"+houseCount);
		
		// 2. 목적지인가
		
		// 3. 갈 수 있는 곳을 순회
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			// 4. 갈 수 있는가?
			// 다음 좌표가 map 바깥이면 통과
			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
				continue;
			}
			// 다음 좌표가 0이면 통과 (집이 없는 경우)
			if (map[nextX][nextY] == 0) {
				continue;
			}
			
			// 5. 간다 dfs(next)
			dfs(nextX, nextY);
		}
		// 6. 체크아웃
	}
}
