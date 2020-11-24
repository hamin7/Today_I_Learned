package BruteForce.P1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean[][] board;
	public static int min = 64;		// 최악의 경우 8*8개 다시 색칠

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String boardSize = br.readLine();
		StringTokenizer st = new StringTokenizer(boardSize);
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		board = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				if (line.charAt(j) == 'W') {
					board[i][j] = true;		// W일 때 true
				} else {
					board[i][j] = false;	// B일 때 false
				}
			}
		}
		
		int nRow = n-7;
		int mCol = m-7;
		
		// (n-7) * (n-7) 가지 경우의 수 (8*8 체커판을 찾기 때문에) 탐색
		// i, j는 시작 좌표
		for (int i = 0; i < nRow; i++) {
			for (int j = 0; j < mCol; j++) {
				// 다시 칠해야 하는 것의 갯수를 구하는 함수
				minOfColorChange(i, j);
			}
		}
		
		System.out.println(min);
	}
	
	public static void minOfColorChange(int x, int y) {
		boolean flag = board[x][y];	// 첫번째가 W인지 B인지 여부
		int count = 0;			// 색칠 다시해야 하는 것의 갯수
		
		int xRow = x + 8;
		int yCol = y + 8;
		
		// x에서 x+7까지 탐색 세로)
		for (int i = x; i < xRow; i++) {
			// y에서 y+7까지 탐색 (가로)
			for (int j = y; j < yCol; j++) {
				// 이번것의 맞 것과 다르다면 count++
				if (board[i][j] != flag) {
					count++;
				}
				// 다음 칸은 색이 바뀌므로 true -> false, false -> true
				flag = (!flag);
			}
			// 다음 줄에서는 색이 바뀌므로 true - > false, false -> true
			flag = (!flag);
		}
		
		// count < min이면 min = count;
		// 반대가 더 적을 수도 있으니 64 - count도 고려해서 작은 것을 비교
		count = Math.min(count, 64 - count);
		min = Math.min(count, min);
	}
}
