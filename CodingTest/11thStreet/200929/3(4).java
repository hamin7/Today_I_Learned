// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        
        int ans = 0, count = 0;

        for (int i = 0; i < A.length; ++i) {
            int gap = 0;
            if (A[i] > i+1) {
                gap = A[i] - (i+1);
            } else if (A[i] < i+1) {
                gap = (i+1) - A[i];
            }
            count += gap;
        }

        return count;
    }
}
