// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Arrays;
class Solution {
	public int solution(int[] A) {
		int N = A.length;
		if (N < 3) {
            return -1;
        }

		Arrays.sort(A);

		for (int i = N - 3; i >= 0; i--) {
			long P = A[i], Q = A[i + 1], R = A[i + 2];
			if (P + Q > R) {
                int sum = A[i] + A[i + 1] + A[i + 2];
                return sum;
            }
		}
		return -1;
	}
}