import java.util.ArrayList;
import java.util.Collections;

class Solution1 {
    static int[][] costMap;     // 수수료 맵
    static int destination;     // 최종 목적지
    ArrayList<Integer> travelTimes = new ArrayList<>();

    public int solution(int N, int[][] fees, int dest) {
        int answer = 0;

        costMap = new int[fees.length][fees.length];
        boolean[] visited = new boolean[fees.length];
        destination = dest;

        // costMap에 은행 간 수수료 넣기
        for (int i = 0; i < fees.length; i++) {
            int from = fees[i][0];
            int to = fees[i][1];
            int cost = fees[i][2];

            costMap[from][to] = costMap[to][from] = cost;
        }

        // 1에서 시작하여 dfs 돌리기
        for (int i = 0; i < fees.length; i++) {
            // from이 1이라면
            if (fees[i][0] == 1) {
                int cost = 0;
                dfs(1, fees[i][1], cost, visited);
            }
        }

        // travelTimes를 sort해서 가장 작은 것을 answer에 넣자
        Collections.sort(travelTimes);

        answer = travelTimes.get(0);

        return answer;
    }

    public void dfs(int from, int current, int cost, boolean[] visited) {
        // 1. 체크인
        visited[from] = true;
        visited[current] = true;
        cost += costMap[from][current];

        // 2. 목적지 인가
        if (current == destination) {
            travelTimes.add(cost);
            return;
        }

        // 3. 갈 수 있는 곳을 순회
        for (int i = 1; i < visited.length; i++) {
            // 4. 갈 수 있는가
            if (visited[i] == false && costMap[current][i] != 0) {
                // 5. 간다 dfs(next)
                dfs(current, i, cost, visited);
                // 6. 체크아웃
                visited[i] = false;
            }
        }
    }
}