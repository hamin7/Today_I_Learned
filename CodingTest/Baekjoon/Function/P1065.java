// package Function.P1065;

import java.util.Scanner;

public class P1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        int n = sc.nextInt();
        
        sc.close();
		
		if (n < 100) {
			System.out.println(n);
		} else {
			int count = 99;
			
			for (int i = 100; i <= n; i++) {
				int flag = isHansoo(i); 
				if (flag == 1) {
					count++;
				} 
			}
			System.out.println(count);
		}
	}
	
	public static int isHansoo(int number) {
		int first = number / 100;
		int second = (number - (first*100)) / 10;
		int third = number % 10;
		
		if ((second - first) == (third - second)) {
			return 1;
		} else {
			return 0;
		}
		
	}

}
