// package Function.P4673;

public class P4673 {
	
	static boolean[] check = new boolean[100001];	// 1~100000

	public static void main(String[] args) {
		for (int i = 1; i < 100001; i++) {
			int n = d(i);
			
			if (n < 100001) {
				// 10000이 넘는 수는 필요 없음.
				check[n] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < 10001; i++) {
			if (!check[i]) {
				// if check is false, print
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}

	// number를 생성자로 하여 셀프 넘버가 아닌 것 return.
	public static int d(int number) {
		int sum = number;
		
		while (number != 0) {
			sum = sum + (number % 10);		// 가장 낮은 자릿 수.
			number = number / 10;		// 10을 나누어 첫 째 자리를 없앤다.
		}
		
		return sum;
	}
}
