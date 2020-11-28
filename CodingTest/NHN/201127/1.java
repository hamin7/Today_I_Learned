//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
public class Solution{
    public long solution(int n){
        long answer = 0;
        long[] fibo = new long[n+1];
        fibo[0] = (long) 0;
        
        if (n == 1) {
            answer = 1;
        }
        
        if (n > 1) {
            fibo[1] = 1;
            for (int i = 2; i <= n; i++) {
                fibo[i] = fibo[i-1] + fibo[i-2];
            }
        
            answer = fibo[n];
        }
        
        
        return answer;
    }
}