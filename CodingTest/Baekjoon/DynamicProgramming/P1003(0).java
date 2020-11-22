package DynamicProgramming.P1003;

import java.util.Scanner;

public class Main {
	static int zero;
	static int one;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			zero = 0;
			one = 0;
			
			int n = sc.nextInt();
			
			fibonacci(n);
			
			System.out.println(zero + " " + one);
		}
	}
	
	public static void fibonacci(int n) {
		if (n == 0) {
			zero++;
//			return 0;
		} else if (n == 1) {
			one++;
//			return 1;
		} else {
//			return fibonacci(n-1) + fibonacci(n-2);
			fibonacci(n-1);
			fibonacci(n-2);
		}
	}
}
