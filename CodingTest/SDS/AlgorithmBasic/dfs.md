# DFS 문제풀이

1. 체크인                   visited[ 0 ~ 25 ] = true;<br>
2. 목적지인가?               selectCount == K => 최대개수 계산<br>
3. 갈 수 있는 곳을 순회        for ( 0 ~ 25 )<br>
   4. 갈 수 있는가?             if ( visited[] == false )<br>
      5. 간다 dfs(next)         dfs(next)<br>
6. 체크아웃                  visited[] = false;<br>