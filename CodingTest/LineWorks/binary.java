/*
정수 A를 B로 변환하기 위해 바꿔야하는 비트 개수를 계산하는 함수를 구현하세요.

예) 
입력: 35, 17
출력: 3

참고) 35: 00100011, 17: 00010001

bit 연산자 및 shift 연산자

   & (AND): 0011 & 0001 = 0001
    | (OR):     0010 | 0001 = 0011
    ^ (XOR):  0101 ^ 0011 = 0110
    ~ (NOT): ~0101 = 1010
    << (shift): 0001 << 1 == 0010
    >> (shift): 0110 >> 1 == 0011

피보나치 구현. 함수 vs 재귀 어떤 장점

*/

package test;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		sc.close();
		
		int c = a^b;
		String cString = Integer.toBinaryString(c);
		
		int count = 0;
		
		for (int i = 0; i < cString.length(); i++) {
			System.out.println(Integer.toBinaryString(c));
			if (cString.charAt(cString.length() - 1) - '0' == 1) {
				count++;
			}
			c = c >> 1;
		}
		
		System.out.println(count);
	}
}
