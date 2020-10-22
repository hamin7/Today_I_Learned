package Array.P1546;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		float[] score = new float[n];
		float[] convertedScores = new float[n];
		double averageScore = 0;
		
		for (int i = 0; i < n; i++) {
			score[i] = sc.nextInt();
		}
		
		sc.close();
		
		convertedScores = convertScore(score);
		averageScore = calculateAverage(convertedScores);
		
		System.out.println(averageScore);
	}

	public static float[] convertScore(float[] scoreArray) {
		float maxScore;
		Arrays.sort(scoreArray);
		maxScore = scoreArray[scoreArray.length-1];
		
		for (int i = 0; i < scoreArray.length; i++) {
			scoreArray[i] = (scoreArray[i]/maxScore)*100;
		}
		
		return scoreArray;
	}
	
	public static double calculateAverage(float[] scoreArray) {
		double average = 0;
		double total = 0;
		
		for (int i = 0; i < scoreArray.length; i++) {
			total += scoreArray[i];
		}
		
		average = total/scoreArray.length;
		
		return average;
	}
}
