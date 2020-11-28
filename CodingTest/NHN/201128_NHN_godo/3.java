//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Solution{
    
    static int[] alphabet;
    
    public int solution(String s, int n) {
        int answer = 0;
        
        alphabet = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            alphabet[ch - 'a']++;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0) {
                list.add(alphabet[i]);
            }
        }
        
        Collections.sort(list);
        
        answer = list.get(list.size() - 1) - list.get(0);
        answer = answer - n;
        System.out.println(answer);
                
        // for (int i = 0; i < list.size(); i++) {
        //     System.out.println(list.get(i));
        // }
        
        return 0;
    }
}