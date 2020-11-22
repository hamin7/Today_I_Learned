package BruteForce.P2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] cards;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int result = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		cards = new int[N];
		
		line = br.readLine();
		st = new StringTokenizer(line);
		
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		result = combination(N, M);
		
		System.out.println(result);
	}
	
	static int combination(int N, int M) {
		int result = 0;
		
		// treverse to N-1 in order to pick first card.
		for (int i = 0; i < N - 2; i++) {
			
			// pick second card
			for (int j = i + 1; j < N - 1; j++) {
				
				// pick third card
				for (int k = j + 1; k < N; k++) {
					
					int sum = cards[i] + cards[j] + cards[k];
					
					// if M == sum, then return sum.
					if (M == sum) {
						return sum;
					}
					
					if (result < sum && sum < M) {
						result = sum;
					}
				}
			}
		}
		
		return result;
	}
}
