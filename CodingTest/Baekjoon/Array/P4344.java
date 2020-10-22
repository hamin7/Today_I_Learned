package Array.P4344;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int i = 0; i < testCase; i++) {
			int howManyStudent = sc.nextInt();
			double howManyBeatAverage = 0;
			
			int[] scoreArray = new int[howManyStudent];
			
			for (int j = 0; j < howManyStudent; j++) {
				scoreArray[j] = sc.nextInt();
			}
			
			howManyBeatAverage = calculateHowManyPeopleBeatAverage(scoreArray);
			System.out.println(String.format("%.3f", howManyBeatAverage)+"%");
		}
		sc.close();
	}
	
	public static double calculateHowManyPeopleBeatAverage(int[] scores) {
		int total = 0;
		double average = 0;
		int count = 0;
		double percentage = 0;
		
		for (int i = 0; i < scores.length; i++) {
			total += scores[i];
		}
		
		average = (double) total/scores.length;
		
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > average)
				count++;
		}
		
		percentage = ((double) count*100/ (double) scores.length);
		
		return percentage;
	}
}
