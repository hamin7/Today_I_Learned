package Array.P2562;

import java.util.Scanner;

public class P2562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] container = new int[9];
		
		for (int i = 0; i < 9; i++) {
			container[i] = sc.nextInt();
		}
		sc.close();
		
		int max = 0;
		int max_index = 0;
		int count = 0;
		
		for (int i = 0; i < container.length; i++) {
			count++;
			if (container[i] > max) {
				max = container[i];
				max_index = count;
			}
		}
		
		System.out.println(max + "\n" + max_index);
	}
}
