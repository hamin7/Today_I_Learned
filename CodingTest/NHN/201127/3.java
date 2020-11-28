//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
import java.util.Arrays;
import java.util.ArrayList;

public class Solution{
    public int solution(int[] goldValues){
        int youSum = 0;
        int otherSum = 0;
        
        int[] tmpArray = new int[goldValues.length];
        
        for (int i = 0; i < goldValues.length; i++) {
            tmpArray[i] = goldValues[i];
        }
        
        Arrays.sort(tmpArray);
        
        youSum += tmpArray[tmpArray.length - 1];
        otherSum += tmpArray[tmpArray.length - 2];
        
        for (int i = 0; i < goldValues.length; i++) {
            if (goldValues[i] == youSum || goldValues[i] == otherSum) {
                goldValues[i] = 0;
            } 
        }
        
        ArrayList<Integer> firstGroup = new ArrayList<Integer>();
        ArrayList<Integer> secondGroup = new ArrayList<Integer>();
        boolean flag = true;
        
        for (int i = 0; i < goldValues.length; i++) {
            if (flag = true && goldValues[i] != 0) {
                firstGroup.add(goldValues[i]);
            } else if (flag = false && goldValues[i] != 0) {
                secondGroup.add(goldValues[i]);
            } else if (goldValues[i] == 0) {
                flag = !flag;
            }
        }
        
        for (int i = 0; i < firstGroup.size(); i++) {
            System.out.print(firstGroup.get(i));
        }
        
        System.out.println();
        
        for (int i = 0; i < secondGroup.size(); i++) {
            System.out.print(secondGroup.get(i));
        }
        
        return 0;
    }
}