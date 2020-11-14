// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    public int solution(int[] A) {
        int longestSpikeLength = 0;

        int[] answer = {};
        List<Integer> arrList = new ArrayList<>();
        int temp = 10;

        for (int num : A) {
            if (temp != num) {
                arrList.add(num);
            }
            temp = num;
        }

        answer = new int[arrList.size()];

        for (int i = 0; i < arrList.size(); i++) {
            answer[i] = arrList.get(i);
        }

        // System.out.println(answer.length);
        longestSpikeLength = answer.length;

        return longestSpikeLength;
    }
}
