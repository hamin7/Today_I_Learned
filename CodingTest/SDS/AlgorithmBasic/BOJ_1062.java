/* 
antic 다섯개의 단어는 무조건 가르쳐야
모든 경우의 수 탐색해야

1. 체크인                   visited[ 0 ~ 25 ] = true;<br>
2. 목적지인가?               selectCount == K => 최대개수 계산<br>
3. 갈 수 있는 곳을 순회        for ( 0 ~ 25 )<br>
   4. 갈 수 있는가?             if ( visited[] == false )<br>
      5. 간다 dfs(next)         dfs(next)<br>
6. 체크아웃                  visited[] = false;<br>
*/
// package DAY01.P1062;

package Day01.P1062;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1062 {
	
	static int N, K;
	static String[] words;
	static boolean[] visited;		// 방문 체크.

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Hi");
		
		System.setIn(new FileInputStream("/Users/hamin/eclipse-workspace/SamsungSDS/src/Day01/P1062/input.txt"));     // 어떤 input을 기본 input으로 할 것인지.
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(sc.next());	// string으로 들어오는 input을 string으로.
		K = Integer.parseInt(sc.next());
		
		System.out.println(N + ", " + K);
		
		words = new String[N];		// N개의 공간을 만들어줌.
		visited = new boolean[26];		// 26개의 알파벳 visited 체크.
		
		for (int i = 0; i < N; i++) {
			words[i] = sc.next().replaceAll("[antic]", "");		// 중복되는 글자들을 공백으로 바꾸기(공통되는 것 제거).
		}
		
		System.out.println(Arrays.toString(words));
		
	}

}
