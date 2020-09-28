package If.P2884;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int minute = sc.nextInt();
		
		if (minute >= 45) {
			System.out.print(hour + " " + (minute-45));
		} else if (minute < 45){
			if (hour == 0)
				hour = 24;
			hour--;
			int tmp = 45 - minute;
			minute = 60 - tmp;
			System.out.print(hour + " " + minute);
		}
	}
}
