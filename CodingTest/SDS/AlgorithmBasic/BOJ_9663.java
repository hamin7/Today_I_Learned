package Day01.P9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] board;
	static int n = 0, caseCount = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		board = new int[n];
		dfs(0);
		System.out.println(caseCount);
	}
	
	// count = row 즉 y
	public static void dfs(int count) {
		// 1. 체크인. - 이미 하고 들어옴.
		// 2. 목적지인가?
		if (count == n) {
			caseCount++;
		} else {
			// 3. 갈 수 있는 곳을 순회.
			// 이번에 고를 퀸이 있는 자리.
			for (int i = 0; i < n; i++) {
				board[count] = i;	// 이번 퀸은 row i에 위치.
				// count가 y, i == board[count]가 x에 해당.
				// 4. 갈 수 있는가?
				// 이번 퀸을 row i에 두어도 된다면 배치, 아니라면 다른 위치로 퀸 배치.
				if (isPossible(count)) {
					// 5. 간다 dfs(next)
					dfs(count+1);
				}
			}
		}
		// 6. 체크아웃. - no 필요.
	}
	
	public static boolean isPossible(int count) {
		// i가 x = (board[count], count가 y에 해당.
		for (int i = 0; i < count; i++) {
			// 같은 x이거나 (i == board[count] == 지금 앞까지의 board[i])
			// 대각선(board[i] - board[count] == i - count)이면 안됨.
			if (board[i] == board[count] || Math.abs(board[count] - board[i]) == count - i) {
				return false;
			}
		}
		return true;
	}
}

// 2차원 할필요가 없음. 한 라인에는 한 퀸만 가능해서.
// 대각선인지 여부 판단하는게 관건.
// (x, y) (a, b) -> x - a = y - b일 때 대각선.
// 갈 수 있는지 여부 체크해주는 함수 필요. -> isPossible
// 줄 수가 n이 되면 한 케이스 완료.
// board 배열의 각 인자는 모두 달라야 함.
