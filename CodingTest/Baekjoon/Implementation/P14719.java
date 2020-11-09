package P14719;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		int[] block = new int[w];
		
		for (int i = 0; i < w; i++) {
			block[i] = sc.nextInt();
		}
		sc.close();
		
		int totalWater = 0;
		
		// 1번 블록부터 오른쪽에서 두 번째 블록까지 물 채우기
		for (int i = 1; i < w-1; i++) {
			int water = 0;
			// 왼쪽에서 젤 높은 것 찾기
			int leftBar = 0;
			
			for (int j = 0; j < i; j++) {
				if (block[j] > leftBar)
					leftBar = block[j];
			}
			
			// 오른쪽에서 젤 높은
			int rightBar = 0;
			
			for (int j = i+1; j < block.length; j++) {
				if (block[j] > rightBar)
					rightBar = block[j];
			}
			
			// 물이 차는 양
			if (block[i] < leftBar && block[i] < rightBar) {
				water = Math.min(leftBar, rightBar) - block[i];
			}
			
			totalWater += water;
		}
		
		System.out.println(totalWater);
	}
}