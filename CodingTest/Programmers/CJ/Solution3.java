public class Solution3 {
    public long solution(long k) {
        long answer = 0;

        for (long i = 1; i < 10000000; i++) {
            long num = (i*i) + i;
            if (num >= 2*k) {
                answer = k - (i*i - i)/2;
                break;
            }
        }
        return answer;
    }
}
