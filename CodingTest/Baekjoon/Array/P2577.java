package Array.P2577;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		
		String number = Integer.toString(a*b*c);
		
		for (int i = 0; i < 10; i++) {
			int howMany = 0; 
			howMany = hasNumberHowMany(number, i);
			System.out.println(howMany);
		}
	}
	
	public static int hasNumberHowMany(String number, int n) {
		int count = 0;
		
		for (int i = 0; i < number.length(); i++) {
			if ((number.charAt(i) - '0') == n) {
				count++;
			}
		}
		
		return count;
	}
}
