import java.util.Scanner;

public class B {
	static int[] data ;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num;
		num = input.nextInt();
		input.close();
		
		int numLength = (int)(Math.log10(num)+1);
		
		int shiftedNum = num;
		boolean testFlag;
		boolean resultFlag = false;
		
		int length = (int)(Math.log10(num)+1);
		data = new int[length];
		String tempString = Integer.toString(num);
		
		for (int i = 0; i < tempString.length(); i++) {
			data[i] = tempString.charAt(i) - '0';
		}

		for (int i = 0; i < numLength - 1; i++) {
			numberShift(length);
			
			int shiftedNumTemp = data[0];
			
			for(int j = 1; j < length; j++) { 
				shiftedNumTemp = shiftedNumTemp*10 + data[j];
			} 
			
			shiftedNum = shiftedNumTemp;
			
			if (shiftedNum == num) {
				break;
			}
			
			testFlag = isPrime(shiftedNum);
			
//			System.out.println(shiftedNum + ": " + testFlag);
			
			if (testFlag == true) {
				resultFlag = true;
			}
		}
		
		if (shiftedNum == num) {
			resultFlag = false;
		}
		
		if (resultFlag == true) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	public static boolean isPrime(int num) {
		boolean flag = true;
		
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				flag = false;
				break;
			}
		}
		
		return flag;
	}

	public static void numberShift(int length) {
		
		
		// 오른쪽으로 1칸 Shift 
		int temp = data[0]; 
		
		for(int i = 0; i < length - 1; i++) { 
			data[i] = data[i+1]; 
		} 
		data[length - 1] = temp; 
		

	}
}
