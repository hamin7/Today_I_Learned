class Solution {
    public int solution(int mod1, int mod2, int max_range) {
        int answer = 0;
        int multipleCount = max_range/mod1;
        int lcm = getLCM(mod1, mod2);
        int lcmMultipleCount = max_range/lcm;
        
        answer = multipleCount - lcmMultipleCount;
        
        return answer;
    }
    
    public static int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }
    
    public static int getGCD(int a, int b) {
        while(b!=0) {
            int r = a % b;
            a= b;
            b = r;
        }
        return a;
    }
}