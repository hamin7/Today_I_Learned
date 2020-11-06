import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static boolean[] visited;
    static String aviation = "";
    ArrayList<String> candidateRoute = new ArrayList<>();
    static String[][] tickets;
    
    public String[] solution(String[][] airTickets) {
        String[] answer = {};
        
        tickets = new String[airTickets.length][airTickets[0].length];
        for (int i = 0; i < airTickets.length; i++) {
            for (int j = 0; j < airTickets[0].length; j++) {
                tickets[i][j] = airTickets[i][j];
            }
        }
        
        for (int i = 0; i < tickets.length; i++) {
            visited = new boolean[tickets.length];
            
            String departure = tickets[i][0];
            String arrival = tickets[i][1];
            
            if (departure.equals("ICN")) {
                boolean flag = false;
                aviation = departure + ",";
                visited[i] = true;
                flag = dfs(arrival, 1);
                
            }
        }
        
        Collections.sort(candidateRoute);
//         String을 배열로 바꿔주기
        answer = candidateRoute.get(0).split(",");
        
        return answer;
    }
    
    public boolean dfs(String arrival, int aviationCount) {
        aviation += arrival + ",";
        
//         2. 목적지인가
//         티켓을 다 사용 했다면, 끝
        if (aviationCount == tickets.length) {
            aviation = aviation.substring(0, aviation.length() - 1);
            candidateRoute.add(aviation);
            return true;
        }
        
//         3. 갈 수 있는 곳을 순회
//         다른 티켓 탐색
//         다른 티켓 시작 == arriaval && visited == false
        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            
//             4. 갈 수 있는가
//             전 단계 arrival과 이번 단계 start가 같고, 방문하지 않았다면
            if (start.equals(arrival) && visited[i] == false) {
                boolean flag = false;
//                 1. 체크인
                visited[i] = true;
//                 5. 간다 dfs(next)
                if (dfs(end, aviationCount + 1) == false) {
//                 6. 체크아웃 -> 안해도 됨.
                visited[i] = false;
                // 메모리 사용을 줄이기 위해 return 후 aviation을 지워줄 것.
                aviation = aviation.substring(0, aviation.length() - 4);
                }

            }
        }
        
        return false;
    }
}