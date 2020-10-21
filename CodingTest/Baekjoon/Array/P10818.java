package Array.P10818;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] container = new int[n];
		
		for (int i = 0; i < n; i++) {
			container[i] = sc.nextInt();
		}
		
		sc.close();
		Arrays.sort(container);
		
		System.out.println(container[0] + " " + container[n-1]);
	}
}
