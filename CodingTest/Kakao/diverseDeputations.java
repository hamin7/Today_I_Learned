// 2020.11.14
// HackerRank
// 항상 경곗값이 문제..

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'diverseDeputation' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER w
     */
    
    // Returns facorial of number
    static int fact (int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    
    // Function to calculate ncr
    static int ncr(int n, int r) {
        int temp = fact(r) * fact(n - r);
        int ncr = 0;
        if (temp != 0) {
            ncr = fact(n) / (fact(r) * fact(n - r));
        }
        return ncr;
    }
    
    // Fuction to calculate the total possible ways
    static int ways(int m, int w, int n, int k) {
        int ans = 0;
        while (m >= k && w >= k) {
            ans += ncr(m, k) * ncr(w, n - k);
            k += 1;
        }
        
        if (m < w) {
            ans--;
        }
        
        return ans;
    }

    public static int diverseDeputation(int m, int w) {
        // Write your code here
        int n = 3;      // total number of people that need to be selected to form the team.
        int k = 1;      // minimum number of men that have to be selected.
        
        int answer = ways(m, w, n, k);
        
        return answer;
    }

}
public class Solution {