import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int totalTime = 0;
		
		// 구워야 할 면의 수
		
		sc.close();
		
		if (N >= 2) {
			totalTime = (N * K);
		}
		
		if (N==1) {
			totalTime = K * 2;
		}
		
		System.out.println(totalTime);
	}
}
