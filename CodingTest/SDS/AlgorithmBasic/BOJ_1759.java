/*
파라미터를 어떻게 조작하느냐에 따라서 체크인 생략 가능
시작점을 만들 때, 주어진 시작점에서 for문으로 시작해도 되고, 가상의 점을 하나 만들어서 그곳에서 시작으로 만들어도 된다.
체크인 하는 방식이 조금 빠르다. 이 코드의 맹점은 dfs함수의 String pwd를 +연산 한다는 맹점이 있다. 
String + 무언가는 new를 한다. 새로운 string을 생성한다는 것인데 performance가 매우 떨어진다.
알아보긴 쉽지만 효율이 떨어진다는 말이다.
대안은 List<Character>를 쓰는 방법이 있다.
또 다른 방식은 stringBuilder라는 것이 있다.
list는 뒤를 빼는 것이 편하지만 stringBuilder는 뒤를 빼는 것이 약간 불편하다.
현업에서 전역변수 쓰는것은 지양할 것.
String + 연산이 말도 안되게 느리므로 stringBuilder가 비교적 빠르다.
*/

package Day01.P1759;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1759 {
	
	static int L, C;
	static char[] data;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("/Users/hamin/eclipse-workspace/SamsungSDS/src/Day01/P1759/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		
//		System.out.println(L+ ", " + C);
		
		data = new char[C];
		
		for (int i = 0; i < C; i++) {
			data[i] = sc.next().charAt(0);		// string에서 첫번째 char를 가져옴.
		}
		
//		System.out.println(Arrays.toString(data));
		Arrays.sort(data);
//		System.out.println(Arrays.toString(data));
		
		// 호출은 보통 모든 시작점에 대해서 해줘야 함.
		for (int i = 0; i < C; i++) {
			if (data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o' || data[i] == 'u') {
				dfs(1, 0, 1, i, data[i] + "");
			} else {
				dfs(1, 1, 0, i, data[i] + "");
			}
		}
		
//		가상의 시작점을 두고 dfs를 시작하는 방법!
//		dfs(0, 0, 0, -1, "");
	}
	
	// 파라미터를 잘 정의하면 체크인, 체크아웃 생략 가능.
	// 조건 상 알파벳 순서대로기 때문에, 이전으로 돌아갈 필요가 없음. -> 체크인 안해도 됨.
	static void dfs(int length, int con, int vow, int current, String pwd) {
//		1. 체크인 - 생략 가능.
//		2. 목적지인가? => if (length == L) => 자음, 모음 개수 확인 => 맞으면 저장.
		if (length == L) {
			if (con >= 2 && vow >= 1) {
				// 답 발견. 출력 or 저장.
				System.out.println(pwd);
			}
		} else {
//			3. 갈 수 있는 곳을 순회 => for ( current + 1 - C - 1)
			for (int i = current + 1; i < C; i++) {
//				4. 	갈 수 있는가? - 생략가능.
//				5. 		간다 - dfs(next)
				if(data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o' || data[i] == 'u') {
					// 모음 갯수 1개 증가.
					dfs(length + 1, con, vow + 1, i, pwd + data[i]);
				} else {
					// 자음 갯수 1개 증가.
					dfs(length + 1, con + 1, vow, i, pwd + data[i]);
				}
			}
		}
//		6. 체크아웃 - 생략가능.
	}
}
