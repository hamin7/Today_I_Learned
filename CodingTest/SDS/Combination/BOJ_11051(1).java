import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11051 {
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		dp = new int[N + 1][N + 1];
		
		for (int n = 0; n <= N; n++) {
			for (int k = 0; k <= 0; k++) {
				if (k==0 || k == n) {
					dp[n][k] = 1;
				} else {
					dp[n][k] = (dp[n - 1][k - 1] + dp[n - 1][k]) % 10007;
				}
			}
		}
		
		for (int n = 0; n <= N; n++) {
			System.out.println(Arrays.toString(dp[n]));
		}
		
		System.out.println(dp[N][K]);
	}
}