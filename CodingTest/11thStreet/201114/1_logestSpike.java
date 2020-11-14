// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    static void findLongestSpike(int a[], int n) {
        // Store both arrays
        Vector<Integer> v1 = new Vector<Integer>();
        Vector<Integer> v2 = new Vector<Integer>();

        // Used for hashing
        HashMap<Integer, Integer> mpp = new HashMap<>();

        // Iterate for every element
        for (int i = 0; i < n; i++) {
            // Increase the count
            mpp.put(a[i], (mpp.get(a[i])== null?0:mpp.get(a[i])) + 1);

            // If first occurrence
            if (mpp.get(a[i]) == 1) {
                v1.add(a[i]);
            }

            // If second occurrence
            else if (mpp.get(a[i]) == 2) {
                v2.add(a[i]);
            }

            // If occurs more than 2 times
            else {
                System.out.println("Not possible");
                return;
            }
        }

        // Sort in increasing order
        Collections.sort(v1);

        // Print the increasing order
        System.out.println("Strictly increasing array is:");
        for (int i = 0; i < v1.size(); i++) {
            System.out.println(v1.get(i) + " ");
        }

        // Sort
        Collections.sort(v2);
        Collections.reverse(v2);

        // print the devreasing arry
        System.out.println("\nStrictly decreasing array is:");
        for (int i = 0; i < v2.size(); i++){
            System.out.println(v2.get(i) + " ");
        }
    }

    public int solution(int[] A) {
        int answer = 0;
        int n = A.length;
        findLongestSpike(A, n);

        return answer;
    }
}
