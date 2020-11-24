package BruteForce.P1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int i = 666;
		int cnt = 1;
		
		while (cnt != n) {
			i++;
			String numString = Integer.toString(i);
			
			if (numString.contains("666")) {
				cnt++;
			}
		}
		System.out.println(i);
	}
}

/*
 * 666 1666 2666 3666 4666 5666 
 * 6660 6661 6662 6663 6664 6665 6666 6667 6668 6669 
 * 7666 8666 9666 
 * 10666 11666 12666 13666 14666 15666 
 * 16660 16661 16662 ... 16669
 * 17666 18666 19666
 * 20666 
 */