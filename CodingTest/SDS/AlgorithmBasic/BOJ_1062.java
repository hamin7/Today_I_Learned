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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ_1062 {
    
    static int N, K;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src\\DAY01\\P1062\\input.txt"));
        Scanner sc = new Scanner(System.in);
    }
}