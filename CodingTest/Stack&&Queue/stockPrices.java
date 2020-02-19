import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> beginIdxs = new Stack<>();   // beginIdxs는 스택.
        int i = 0;
        int[] answer = new int[prices.length];
        
        beginIdxs.push(i);
        for (i = 1; i < prices.length; i++){
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                answer[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            answer[beginIdx] = i - beginIdx - 1;
        }
        
        return answer;
    }
}
