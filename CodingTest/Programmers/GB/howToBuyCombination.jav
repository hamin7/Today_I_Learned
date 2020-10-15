class Solution {
    public int solution(int a, int b, int budget) {
        int answer = 0;
        int max = budget/a;
        
        for (int i = 0; i <= max; i++) {
            if ((budget-(a*i)) % b == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}