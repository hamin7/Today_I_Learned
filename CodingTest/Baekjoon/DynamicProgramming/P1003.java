package DynamicProgramming.P1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println(fibo(N) + " " + fibo(N+1));
		}
	}
	
	public static int fibo(int n) {
		int a = 1;		// f(0)
		int b = 0;		// f(1)
		int c = 1;		// f(2)
		
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 0;
		} else {
			for (int i = 3; i <= n; i++) {
				a = b;
				b = c;
				c = a + b;
			}
			return c;
		}
	}
}