package BruteForce.P7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		String[] person;
		for (int i = 0; i < n; i++) {
			person = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(person[0]);
			arr[i][1] = Integer.parseInt(person[1]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		// rank 1부터 시작, 자신보다 큰 사람 찾을 때 마다 rank++
		for (int i = 0; i < n; i++) {
			int rank = 1;
			
			for (int j = 0; j < n; j++) {
				// 자기 자신은 비교할 필요 없음
				if (i == j) {
					continue;
				}
				
				// i사람과 j 사람 비교하여 i가 작으면 rank++
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
			
			sb.append(rank).append(" ");
		}
		System.out.print(sb);
	}
}
