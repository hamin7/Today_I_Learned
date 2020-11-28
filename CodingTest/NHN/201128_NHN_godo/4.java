//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    static List<String> numbers = new ArrayList<String>();
    static boolean numCnt = true;      // cardNumber가 짝수면 true, 홀수면 false.
    
    public String solution(String cardNumber){
        String answer = "";
        
        if (cardNumber.length() % 2 == 0) {
            // even
            numCnt = true;
        } else {
            // odd
            numCnt = false;
        }
        
        String[] splitStr = cardNumber.split("");
        for (int i = 0; i < splitStr.length; i++) {
            numbers.add(splitStr[i]);
        }
        
        if (isValid(cardNumber)) {
            answer = "VALID";
        } else {
            answer = "INVALID";
        }
        
        System.out.println(number);
        
        return answer;
    }
    
    static boolean isValid(String number) {
        int cnt = 1;

        for (int i = number.length() - 1; i >= 0; i--) {
            if (numCnt == true) {
                // even
                if (cnt % 2 != 0) {
                    // 추후 모든 자리의 수를 더하기 위해 숫자로 저장
                    char[] tempNumber = number.toCharArray();
                    tempNumber[i] -= '0';
                    number = String.valueOf(tempNumber);
                    cnt++;
                    continue;
                }
            } else {
                // odd
                if (cnt % 2 == 0) {
                    // 추후 모든 자리의 수를 더하기 위해 숫자로 저장
                    char[] tempNumber = number.toCharArray();
                    tempNumber[i] -= '0';
                    number = String.valueOf(tempNumber);
                    cnt++;
                    continue;
                }
            }
            

            int twiceNum = (number.charAt(i) - '0') * 2;
            if (twiceNum >= 10) {
                // 2배로 만든 수는 무조건 10 이상 18 이하이므로 1 + (수 - 10)으로 계산
                twiceNum = 1 + (twiceNum - 10);
            }

            // 추후 모든 자리의 수를 더하기 위해 숫자로 저장
            char[] tempNumber = number.toCharArray();
            tempNumber[i] = (char)twiceNum;
            number = String.valueOf(tempNumber);

            cnt++;
        }

        int k = 0;

        for (int i = 0; i < number.length(); i++) {
            k += number.charAt(i);
        }
        
        System.out.println(k);

        return (k % 10 == 0) ? true : false;
    }
}