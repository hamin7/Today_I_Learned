package BFS_DFS.P2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] network;
	static boolean[] visited;
	static int numberOfComputers;
	static int numberOfVertex;
	static int infectedCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		numberOfComputers = Integer.parseInt(br.readLine());
		numberOfVertex = Integer.parseInt(br.readLine());
		
		network = new int[numberOfComputers+1][numberOfComputers+1];
		visited = new boolean[numberOfComputers+1];
		
		for (int i = 1; i <= numberOfVertex; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			network[x][y] = network[y][x] = 1;
		}
		
		dfs(1);		// 1번 컴퓨터에서 시작
		System.out.println(infectedCount-1);		// 1번 컴퓨터는 갯수에서 제외
	}

	public static void dfs(int currentNode) {
//		1. 체크인
		visited[currentNode] = true;
		infectedCount++;
//		3. 갈 수 있는 곳들을 순회
		for (int i = 1; i <= numberOfComputers; i++) {
//			4. 갈 수 있는가?
			if (network[currentNode][i] == 1 && visited[i] == false) {
//				5. 간다 dfs(next)
				dfs(i);
			}
		}
	}
}