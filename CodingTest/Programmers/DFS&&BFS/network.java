class network {
    static int[][] networkMap;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        networkMap = new int[computers.length][computers[0].length];
        visited = new boolean[computers.length];
        
        // networkMap에 computers 넣기
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                networkMap[i][j] = computers[i][j];
            }
        }
        
        // 1번 컴퓨터부터 마지막 것까지 dfs 돌리기
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(int current) {
        // 1. 체크인
        visited[current] = true;
        
        // 2. 목적지인가 - 필요 없을 듯?
        // for (int i = 0; i < networkMap[current].length; i++) {
        //     if (networkMap[current][i] == 0)
        // }
        
        // 3. 갈 수 있는 곳을 순회
        for (int i = 0; i < networkMap[current].length; i++) {
            // 4. 갈 수 있는가
            // networkMap에서 1이고 visited == false
            if (networkMap[current][i] == 1 && visited[i] == false) {
                // 5. 간다 dfs(next)
                dfs(i);
                // 6. 체크아웃 - 필요 없음
            }
        }
    }
}