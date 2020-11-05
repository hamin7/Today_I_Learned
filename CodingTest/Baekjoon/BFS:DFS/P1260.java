package BFS_DFS.P1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int vertex[][];		// 간선 연결상태
	static boolean[] visited;		// 확인 여부
	static int n, m, startNode;		// 정점 갯수, 간선 갯수, 시작 노드
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		startNode = Integer.parseInt(st.nextToken());
		
		vertex = new int[n+1][n+1];		// 좌표를 그대로 받아들이기 위해 +1 해서 선언
		visited = new boolean[n+1];		// 초기값은 false
		
		// 간선 연결상태 저장
		for (int i = 0; i < m; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			vertex[x][y] = vertex[y][x] = 1;
		}
		
		dfs(startNode);
		
		visited = new boolean[n+1];		// 확인 상태 초기화
		System.out.println();		// 줄 바꿈
		
		bfs();
	}
	
	// 시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출
	public static void dfs(int currentNode) {
		visited[currentNode] = true;
		System.out.print(currentNode + " ");
		
		for (int i = 1; i <= n; i++) {
			if(vertex[currentNode][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startNode);
		visited[startNode] = true;
		System.out.print(startNode + " ");
		
		while (!queue.isEmpty()) {
//			1. 큐에서 꺼내옴
			int temp = queue.poll();
			
			for (int i = 1; i <= n; i++) {
//				4. 갈 수 있는가? if (맵을 벗어나지 않는가)
				if (vertex[temp][i] == 1 && visited[i] == false) {
//					5. 체크인
					visited[i] = true;
//					6. 큐에 넣음 queue.add
					queue.add(i);
					System.out.print(i + " ");
				}
			}
		}
	}
}
