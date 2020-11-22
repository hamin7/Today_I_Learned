package BruteForce.P2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = combination(N);
		System.out.println(result);
	}
	
	public static int combination(int num) {
		int candidateNum = num;
		int minimum = 0;
		
		while (candidateNum > 0) {
			candidateNum--;
			String numString = Integer.toString(candidateNum);
			int sum = Integer.parseInt(numString);			
			int length = (int)(Math.log10(candidateNum)+1);
			
			for (int i = 0; i < length; i++) {
				sum +=  numString.charAt(i) - '0';
			}
			
			if (sum == num) {
				minimum = candidateNum;
			}
		}
		return minimum;
	}
}
