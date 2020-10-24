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
		
		
		int totalWater = 0;
		
		for (int i = 1; i < w-1; i++) {
			int water = 0;
			// 왼쪽에서 젤 높은
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
			if (leftBar > rightBar && rightBar - block[i] > 0) {
				water = rightBar - block[i];
			} else if (leftBar - block[i] > 0){
				water = leftBar - block[i];
			}
			
			totalWater += water;
		}
		
		System.out.println(totalWater);
	}

}
