package BFS_DFS.P2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int n;
	static int m;
	static int[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		map = new int[n+1][m+1];
		visited = new boolean[n+1][m+1][2];
		
		for (int i = 1; i <= n; i++) {
			input = br.readLine().split("");
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(input[j-1]);
			}
		}
		
		bfs(1, 1);
	}

	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 0, 1));
		
		visited[x][y][0] = true;
		visited[x][y][1] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			// 끝까지 왔다면.
			if (p.x == n && p.y == m) {
				System.out.println(p.count);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int breakWall = p.breakWall;
				int count = p.count;
				
				if (nx <= 0 || ny <= 0 || nx > n || ny > m)
					continue;
				
				if (map[nx][ny] == 1) {
					// 벽을 마주치면.
					if (breakWall == 0 && !visited[nx][ny][1]) {
						// 벽을 부순적이 없음.
						visited[nx][ny][1] = true;
						q.add(new Point(nx, ny, 1, count + 1));
					}
				} else {
					// 벽이 아니라면.
					if (!visited[nx][ny][breakWall]) {
						q.add(new Point(nx, ny, breakWall, count + 1));
						visited[nx][ny][breakWall] = true;
					}
				}
			}
		}
		
		System.out.println(-1);
	}
	
	static class Point {
		int x;
		int y;
		int breakWall;
		int count;
		
		public Point(int x, int y, int breakWall, int count) {
			this.x = x;
			this.y = y;
			this.breakWall = breakWall;
			this.count = count;
		}
	}
}
