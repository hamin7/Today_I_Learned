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
	static int selectedCount = 0;		// 총 몇개의 알파벳을 내가 선택했는지.
	static int max = 0;			// 최대로 읽을 수 있는 단어의 갯수.

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Hi");
		
		System.setIn(new FileInputStream("/Users/hamin/eclipse-workspace/SamsungSDS/src/Day01/P1062/input.txt"));     // 어떤 input을 기본 input으로 할 것인지.
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(sc.next());	// string으로 들어오는 input을 string으로.
		K = Integer.parseInt(sc.next());
		
		System.out.println(N + ", " + K);
		
		words = new String[N];		// N개의 공간을 만들어줌.
		visited = new boolean[26];		// 26개의 알파벳 visited 체크.
		visited['a' - 'a'] = true;		// 방문 하고 시작할꺼야 라는 초깃값 세팅.
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['c' - 'a'] = true;
		
		selectedCount = 5;
		
		System.out.println(Arrays.toString(visited));
		
		for (int i = 0; i < N; i++) {
			words[i] = sc.next().replaceAll("[antic]", "");		// 중복되는 글자들을 공백으로 바꾸기(공통되는 것 제거).
		}
		
		System.out.println(Arrays.toString(words));
		
		selectedCount = 5;
		max = countWords();
		
		// 알파벳 a부터 시작하여 고르기.
		for (int i = 0; i < 26; i++) {
			// 아직 선택되지 않은 경우.
			if(visited[i] == false) {
				dfs(i);
			}
		}
		
		System.out.println(max);
	}
	
	// 파라미터는 상태정보, 내가 현재 고른 알파벳은 무엇인가...
	// DFS는 사람이 손으로 푸는 것과 비슷한 메커니즘.
	static void dfs(int index) {
//		1. 체크인                   visited[ 0 ~ 25 ] = true;<br>
		visited[index] = true;		// 체크인.
		selectedCount++;
//		2. 목적지인가?               selectCount == K => 최대개수 계산<br>
		if (selectedCount == K) {
			// max = 최대 단어 개수. 읽을 수 있는 최댓값.
			max = Math.max(countWords(), max);
		} else {
			// 최대 단어의 개수만큼 찾지 못함.
//			3. 갈 수 있는 곳을 순회        for ( 0 ~ 25 )<br>
			// index + 1 부터인 이유는 현재위치 다음 것 부터 가겠다는 뜻.
			// 알파벳이 26개 이니까 26까지 감.
			for (int i = index + 1; i < 26; i++) {
//				4. 갈 수 있는가?             if ( visited[] == false )<br>
				if(visited[i] == false) {
//					5. 간다 dfs(next)           dfs(next)<br>
					dfs(i);
				}
			}
		}
//		6. 체크아웃                  visited[] = false;<br>
		// 체크인과 체크아웃의 indent가 동일해야...
		visited[index] = false;
		selectedCount--;
	}
	
	// 현재 내가 읽을 수 있는 단어의 갯수 count.
	// 단어들을 순회하면서 읽을 수 있는가를 체크.
	static int countWords() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			boolean isPossible = true;
			String word = words[i];
			// 한 단어의 길이만큼 돌아주기.
			for (int j = 0; j < word.length(); j++) {
				// j 번째 char를 가져옴. 그것을 숫자로 바꿔주기.
				// 해당 알파벳을 배운적이 없으면..
				if(visited[word.charAt(j) - 'a'] == false) {
					isPossible = false;
					break;
				}
			}
			// 읽을 수 있는 단어.
			if(isPossible == true) {
				count++;
			}
		}
		
		return count;
	}
}

