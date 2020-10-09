package SamsungElec.P13458;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] array = new int[n];
		long result = 0;
		
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		
		int captain = sc.nextInt();
		int vice_captain = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			result++;
			array[i] -= captain;
			
			if (array[i] > 0) {
				result += Math.ceil(1.0 * array[i] / vice_captain);
			}
		}
		System.out.println(result);
		sc.close();
	}
}
