// 피보나치를 재귀가 아니라 함수로 짤 때의 장점은?

package test;

import java.util.Scanner;

public class fiboArray {
	static int[] fiboArray;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		fiboArray = new int[n+1];
		
		fiboArray[1] = 1;
		fiboArray[2] = 1;
		
		for (int i = 3; i <= n; i++) {
			fiboArray[i] = fibo(fiboArray[i-2], fiboArray[i-1]);
		}
		
		System.out.println(fiboArray[n]);
	}

	public static int fibo (int a, int b) {
		int next = 0;
		next = a + b;
		
		return next;
	}
	
}
