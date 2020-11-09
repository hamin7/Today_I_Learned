public class Solution2 {
    static int[][] map;

    public int solution(int V, int[][] bridge) {
        int answer = 0;

        map = new int[V+1][V+1];
        boolean[] visited = new boolean[map.length];

        for (int i = 0; i < bridge.length; i++) {
            int x = bridge[i][0];
            int y = bridge[i][1];

            map[x][y] = map[y][x] = 1;
        }

        for (int i = 1; i < map.length; i++) {
            if (visited[i] == false) {
                answer++;
                dfs(i, visited);
            }
        }

        answer--;           // 네트워크 수가 answer이니 하나 빼야 건설해야 할 다리의 수
        return answer;
    }

    public void dfs(int node, boolean[] visited) {
        // 1. 체크인
        visited[node] = true;

        for (int i = 1; i < map.length; i++) {
            if (visited[i] == false && map[node][i] == 1) {
                dfs(i, visited);
            }
        }
    }
}
