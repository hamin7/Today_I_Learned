// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int n = A.length;
        
        // Hash table to store frequency
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        // Increase the frequency of elements
        for (int i = 0; i < n; i++) {
            if (mp.get(A[i]) != null) {
                int x = mp.get(A[i]);
                mp.put(A[i], ++x);
            } else {
                mp.put(A[i], 1);
            }
        }
        
        int count = 0;
        
        // Traverse in the map to sum up the (occurrences - 1) of duplicate elements
        for (HashMap.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > 1) {
                count += (entry.getValue() - 1);
            }
        }
        
        return count;
    }
}
