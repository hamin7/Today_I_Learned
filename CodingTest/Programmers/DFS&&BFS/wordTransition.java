class wordTransition {
    static String[] dictionary;
    static boolean[] visited;
    static String target;
    static int answer = 0;
    
    public int solution(String begin, String targetWord, String[] words) {
        
        dictionary = new String[words.length];
        visited = new boolean[words.length];
        target = targetWord;
        
        for (int i = 0; i < words.length; i++) {
            dictionary[i] = words[i];
        }
        
        dfs(begin, target, 0);
        
        return answer;
    }
    
    public static void dfs(String current, String target, int count) {
        
        // 2. 목적지인가?
        if (current.equals(target)) {
            answer = count;
            return;
        }
        
        // 3. 갈 수 있는 곳들 순회
        // dictionary의 각 단어마다 비교.
        for (int i = 0; i < dictionary.length; i++) {
            // current와 dictionary의 현재 단어가 하나만 다르면 변경 가능
            int diff = 0;
            if (visited[i] == true) {
                continue;
            }
            
            // 스펠링 몇 개가 다른지 비교
            for (int j = 0; j < current.length(); j++) {
                if (current.charAt(j) != dictionary[i].charAt(j)) {
                    diff++;
                }
            }
            
            // 4. 갈 수 있는가?
            // 스펠링 하나만 다르다면 변경
            if (diff == 1) {
                // 1. 체크인
                visited[i] = true;
                // 5. 간다 dfs(next)
                dfs(dictionary[i], target, count+1);
                // 6. 체크아웃
                visited[i] = false;
            }   
        }       
    }
}