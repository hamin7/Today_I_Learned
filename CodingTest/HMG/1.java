import java.util.ArrayList;

class Solution {
    public int solution(String s, String pattern) {
        int answer = 0;

        String patternPart;

        for (int i = 0; i < S.length() - pattern.length()+1; i++) {
            patternPart = S.substring(i, i+pattern.length());
            boolean canMake = canMakePattern(patternPart, pattern);
            if (canMake == true) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean canMakePattern(String candidate, String Pattern) {
        boolean available = false;
        ArrayList<Character> candidateList = new ArrayList<Character>();

        return available;
    }
}